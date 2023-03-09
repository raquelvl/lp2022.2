/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ciência da Computação
 * Departamento de Sistemas e Computação
 * Universidade Federal da Paraíba
 *
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 * Não redistribuir sem permissão.
 */
package banco.excecoes;

import banco.entidades.Conta;

/**
 * Classe de Exceção quando tenta-se fechar uma conta sem estar com saldo zerado.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */
public class NaoPodeFecharContaException extends Exception {
    static final long serialVersionUID = 6857729033909487478L;    
	Conta conta;

    /**
     * Construtor de exceção informando que uma conta não pode ser fechada.
     * @param conta A conta que não pode ser fechada.
     * @param motivo O motivo pelo qual não se pode fechar a conta.
     */
	public NaoPodeFecharContaException(Conta conta, String motivo) {
		super(motivo);
		this.conta = conta;
	}
}