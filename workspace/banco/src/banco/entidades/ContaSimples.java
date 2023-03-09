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

/**
 * Classe de conta bancária simples para pessoa física.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */
public class ContaSimples extends Conta {
	// construtores
	/**
	 * Cria uma conta a partir de uma pessoa e número de conta.
	 * @param titular O titular da conta.
	 */
	public ContaSimples(Pessoa titular) {
		super(titular);
		Agencia.addTitular(titular);
		Agencia.addConta(this);
	}

	/**
	 * Cria uma conta a partir de um nome e cpf de pessoa física, e um número de conta.
	 * @param nome O nome do titular da conta.
	 * @param cpf O CPF do titular da conta.
	 */
	/* Este método existe para esconder a classe Pessoa dos principiantes */
	public ContaSimples(String nome, String cpf) {
		this(new Pessoa(nome, cpf));
	}

	/**
	 * Transforma os dados da conta em um String.
	 * @return O string com os dados da conta.
	 */
	public String toString() {
		return "ContaSimples " + super.toString();
	}
}