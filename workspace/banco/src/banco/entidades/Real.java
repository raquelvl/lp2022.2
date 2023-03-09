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
import java.io.*;

/**
 * A moeda Real (Brasil). O importante aqui é o método toString que
 * sabe o símbolo da moeda (R$).
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */

public class Real extends Moeda implements Serializable {

  /**
   * Controi um valor 0.0 em moeda Real
   */
  public Real() {
    this(0.0);
  }

  /**
   * Controi um valor em moeda Real.
   * @param valor O valor em reais.
   */
  public Real(double valor) {
    super(valor);
  }

  /**
   * Representa o valor da moeda como string
   */
  public String toString() {
    String resultado = "R$";
    long centavos = getCentavos();
    if(centavos < 0) {
      resultado += "-";
      centavos = -centavos;
    }
    long cent = centavos % 100;
    resultado += centavos/100 + "," + (cent < 10 ? "0" : "") + cent;
    return resultado;
  }
}