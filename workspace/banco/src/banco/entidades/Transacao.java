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

import banco.entidades.util.Data;

/**
 * Uma transação bancária. Uma transação envolve a transferência de valores
 * entre contas. Toda a movimentação bancária envolve transações.
 * Quando há, aparentemente, uma única conta envolvida (depósito ou saque),
 * a segunda conta envolvida é a Conta Caixa.
 *
 * @see banco.entidades.ContaCaixa
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */
public class Transacao implements Serializable {
  static final long serialVersionUID = 6150522172556957388L;
	private Data	data;
	private Conta	contaDébito;
	private Conta	contaCrédito;
	private Moeda	valor;
	private String	descrição;

	// Construtores
    /**
     * Constroi uma transação.
     * @param data A data da transação.
     * @param contaDébito A conta que foi debitado.
     * @param contaCrédito A conta que foi creditado.
     * @param valor O valor da transação.
     * @param descrição A descrição da transação.
     */
	public Transacao(Data data, Conta contaDébito, Conta contaCrédito, Moeda valor, String descrição) {
		this.data = data;
		this.contaDébito = contaDébito;
		this.contaCrédito = contaCrédito;
		this.valor = valor;
		this.descrição = descrição;
	}


	/**
	 * Recupera a data da transação.
	 * @return A data da transação.
	 */
	public Data getData() {
		return data;
	}
   
	/**
	 * Recupera a conta débito.
	 * @return A conta débito.
	 */
	public Conta getContaDébito() {
		return contaDébito;
	}

	/**
	 * Recupera a conta crédito.
	 * @return A conta crédito.
	 */
	public Conta getContaCrédito() {
		return contaCrédito;
	}

	/**
	 * Recupera o valor da transação.
	 * @return O valor da transação como double.
	 */
	public double getValor() {
		return valor.getValor();
	}

	/**
	 * Recupera o valor da transação.
	 * @return O valor da transação como Moeda.
	 */
	public Moeda getValorMonetário() {
		return valor;
	}

	/**
	 * Recupera a descrição da transação.
	 * @return A descrição da transação.
	 */
	public String getDescrição() {
		return descrição;
	}

	/**
	 * Transforma os dados da transação em um String.
	 * @return O string descrevendo a transação.
	 */
	public String toString() {
		return "Transacao data " + getData().DDMMAAAA()
			+ ", debito " + getContaDébito().getNúmero()
			+ ", credito " + getContaCrédito().getNúmero()
			+ ", valor " + getValorMonetário()
			+ ", descricao [" + getDescrição();
	}
}