/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ciência da Computação
 * Departamento de Sistemas e Computação
 * Universidade Federal da Paraíba
 *
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 * Não redistribuir sem permissão.
 */
package banco.entidades;

import java.io.Serializable;
import java.util.Iterator;

import banco.entidades.util.Data;
import banco.excecoes.NaoPodeFecharContaException;

/**
 * Classe abstrata de conta bancária com implementações default de alguns métodos.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */
public abstract class Conta implements Serializable {
  static final long serialVersionUID = 8972898734498390810L;
	private long			   número;
	private Pessoa     titular;
	private Data       dataAbertura;
	private Moeda		   saldo;
	private Movimento  movimento;
	
	protected Conta(Pessoa titular, long numero) {
		this.número = 0;
		this.titular = titular;
		dataAbertura = new Data();	// A data representa este instante de tempo
		saldo = new Real(0.0);		// Conta em reais e zerada
		movimento = new Movimento();
	}

	// construtores
	/**
	 * Cria uma conta a partir de uma pessoa e número de conta.
	 * @param titular O titular da conta.
	 */
	public Conta(Pessoa titular) {
		this.número = GeradorDeNumeroDeConta.geraNumero();
		this.titular = titular;
		dataAbertura = new Data();	// A data representa este instante de tempo
		saldo = new Real(0.0);		// Conta em reais e zerada
		movimento = new Movimento();
	}
	
	/**
	 * Cria uma conta a partir de uma pessoa e número de conta.
	 * @param nome	Nome do titular da conta
	 * @param cpf	CPF do titular da conta
	 */
	public Conta(String nome, String cpf) {
		this.número = GeradorDeNumeroDeConta.geraNumero();
		this.titular = new Pessoa(nome, cpf);
		dataAbertura = new Data();	// A data representa este instante de tempo
		saldo = new Real(0.0);		// Conta em reais e zerada
		movimento = new Movimento();
	}

	// Métodos
	/**
	 * Recupera o número da conta.
	 * @return O número da conta.
	 */
	public long getNúmero() {
		return número;
	}

	/**
	 * Recupera o titular da conta.
	 * @return O titular da conta.
	 */
	public Pessoa getTitular() {
		return titular;
	}

	/**
	 * Recupera o nome do titular da conta.
	 * @return O nome do titular da conta.
	 */
	/* feito para ajudar os principiantes escondendo a classe Pessoa no inicio */
	public String getNome() {
		return titular.getNome();
	}

	/**
	 * Recupera o CPF do titular da conta.
	 * @return O CPF do titular da conta.
	 */
	/* feito para ajudar os principiantes escondendo a classe Pessoa no inicio */
	public String getCPF() {
		return titular.getCPF();
	}

	/**
	 * Recupera a data de abertura da conta.
	 * @return A data de abertura da conta.
	 */
	public Data getDataAbertura() {
		return dataAbertura;
	}
   
	/**
	 * Recupera o saldo da conta.
	 * @return O saldo da conta como double.
	 */
	public double getSaldo() {
		return saldo.getValor();
	}

	/**
	 * Recupera o saldo da conta.
	 * @return O saldo da conta como Moeda.
	 */
	public Moeda getSaldoMonetário() {
		return saldo;
	}

	/**
	 * Recupera o movimento da conta.
	 * @return O movimento da conta.
	 */
	public Movimento getMovimento() {
		return movimento;
	}

	/**
	 * Fornece um Iterator para varrer as transações por data.
	 * @return O Iterator.
	 */
	public Iterator getTransações() {
		return getMovimento().getTransações();
	}

	/**
	 * Transfere um valor para outra conta.
	 * @param destino A conta destino.
	 * @param valor O valor a transferir.
	 * @return O sucesso ou não da operação.
	 */
	public boolean transferir(Conta destino, double valor) {
		return transferir(destino, valor, "transferencia para conta " + destino.getNúmero());
	}

	/**
	 * Transfere um valor para outra conta.
	 * @param destino A conta destino.
	 * @param valor O valor a transferir.
	 * @param descr A descrição da transação.
	 * @return O sucesso ou não da operação. Há insucesso se não houver saldo suficiente.
	 */
	public boolean transferir(Conta destino, double valor, String descr) {
		if(saldo.getValor() - valor >= 0) {
			this.receber(-valor);
			destino.receber(valor);
			logarTransacao(this, destino, new Real(valor), descr);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Recebe valor na conta.
	 * @param valor O valor a receber.
	 */
    // observe que o método *não* é público
	void receber(double valor) {
		saldo.setValor(saldo.getValor() + valor);
	}

	/**
	 * Efetua um depósito numa conta.
	 * @param valor O valor a depositar.
	 * @return true Se o valor foi depositado com sucesso.
	 */
	public boolean depositar(double valor) {
		// credita a conta e debita o caixa
		return Agencia.getContaCaixa().transferir(this, valor, "deposito");
	}

	/**
	 * Efetua sacada na conta.
	 * @param valor O valor a sacar.
	 * @return O sucesso ou não da operação.
	 */
	public boolean sacar(double valor) {
		// debita a conta e credita o caixa
		return transferir(Agencia.getContaCaixa(), valor, "saque");
	}

	/**
	 * Efetua log de uma transação no movimento.
     * @param contaDébito A conta que foi debitada.
     * @param contaCrédito A conta que foi creditada.
	 * @param valor O valor da transação.
     * @param descr A descrição da transação.
	 */
    // observe que p método *não* é público
    void logarTransacao(Conta contaDébito, Conta contaCrédito, Moeda valor, String descr) {
		Transacao transacao = new Transacao(new Data(), contaDébito, contaCrédito, valor, descr);
		contaDébito.getMovimento().add(transacao);
		contaCrédito.getMovimento().add(transacao);
		Agencia.getMovimento().add(transacao);
	}

	/**
	 * Transforma os dados da conta em um String.
	 * @return O string com os dados da conta.
	 */
	public String toString() {
		return "numero " + getNúmero()
				+ ", titular " + getNome()
				+ ", data " + getDataAbertura().DDMMAAAA()
				+ ", saldo " + getSaldoMonetário();
	}

	/**
	 * Fecha a conta.
	 * @throws NaoPodeFecharContaException Quando se tenta fechar uma conta com saldo não zero.
	 */
	public void fechar() throws NaoPodeFecharContaException  {
		Agencia.fecharConta(número);
	}

	/**
	 * Cria um extrato com todas as transações entre duas datas.
	 * @param dataInicial A data inicial do extrato (inclusive).
	 * @param dataFinal A data final do extrato (inclusive).
	 * @return	O extrato da conta entre as datas escolhidas.
	 */
	public Extrato criarExtrato(Data dataInicial, Data dataFinal) {
		return new Extrato(dataInicial, dataFinal, movimento);
	}
}