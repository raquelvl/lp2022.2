package banco.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe que implementa um movimento de transações.
 * Um movimento é apenas uma série de transações feitas.
 * Todas as transações devem entrar aqui em ordem cronológica.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */
public class Movimento implements Serializable {
    static final long serialVersionUID = 6598108299168173551L;
    // a coleção deve manter a ordem de inserção
	private List<Transacao> transações;

	// Construtores
    /**
     * Controi um Movimento vazio (sem transações).
     */
	public Movimento() {
		transações = new ArrayList();
	}

	/**
	 * Adiciona uma transações ao movimento.
	 * @param transação A transação a adicionar ao movimento.
	 */
	public void add(Transacao transação) {
		transações.add(transação);
	}

	/**
	 * Fornece um Iterator para varrer as transações por data.
	 * @return O Iterator.
	 */
	public Iterator getTransações() {
		return transações.iterator();
	}
}