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

import banco.excecoes.NaoPodeFecharContaException;

/**
 * Classe de conta caixa.
 * A agencia tem uma conta caixa que é uma conta com várias restrições.
 * A conta caixa representa o caixa da agência. Como todos os movimentos
 * feitos a contas bancárias devem envolver <i>duas</i> contas (pelos
 * princípios da contabilidade), a conta caixa é usada durante os depósitos
 * e saques feitos pelos clientes com suas contas normais.
 * <P>Por exemplo, um depósito envolve uma transferência de valor <i>para</i>
 * uma conta. De onde veio este dinheiro? Da conta caixa. Em outras palavras,
 * a conta caixa é debitada e a conta alvo é creditada.
 * <p>Da mesma forma, um saque envolve um débito de uma conta normal e um crédito
 * na conta caixa.
 * <p>A conta caixa tem um comportamento diferente das demais contas.
 * Por exemplo: ela pode ter saldo negativo à vontade (resultados de depósitos)
 * e certas outras operações lançam exceções.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */
public class ContaCaixa extends Conta {
	// construtores
    /** Constroi uma conta caixa */
	public ContaCaixa() {
		// usa uma pessoa fisica ficticia
		super(new Pessoa("caixa"), 0);
	}

	/**
	 * Transfere um valor do caixa para outra conta (depósito).
	 * @param destino A conta destino.
	 * @param valor O valor a transferir.
	 * @param descr A descrição da transação.
	 * @return O sucesso ou não da operação.
	 */
	public boolean transferir(Conta destino, double valor, String descr) {
		this.receber(-valor);
		destino.receber(valor);
		logarTransacao(this, destino, new Real(valor), descr);
		return true; // sempre pode debitar o caixa: nunca dá erro
	}

	/**
	 * Não deixa efetuar depósito no caixa. Para que não haja depósito feito
	 * diretamente na conta "caixa", fazemos override de um depósito normal
	 * para que este não seja permitido para a conta caixa.
	 * @param valor O valor que se quer depositar.
	 * @return O sucesso ou não da operação (sempre false).
	 */
	public boolean depositar(double valor) {
		return false; // nao se deve fazer "depósitos" diretos no caixa
	}

	/**
	 * Não deixa efetuar saques no caixa. Para que não haja saque feito
	 * diretamente na conta "caixa", fazemos override de um saque normal
	 * para que este não seja permitido para a conta caixa.
	 * @param valor O valor que se quer sacar.
	 * @return O sucesso ou não da operação (sempre dá false).
	 */
	public boolean sacar(double valor) {
		return false; // nao se deve fazer "saques" no caixa
	}

	/**
	 * Não permite o fechamento da conta
	 * @throws NaoPodeFecharContaException Porque não é permitido fechar o caixa.
	 */
	public void fechar() throws NaoPodeFecharContaException  {
		throw new NaoPodeFecharContaException(this, "Nao pode fechar o caixa");
	}

	/**
	 * Transforma os dados da conta em um String.
	 * @return O string com os dados da conta.
	 */
   	public String toString() {
		return "ContaCaixa saldo " + getSaldoMonetário();
	}
}