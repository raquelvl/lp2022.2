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
 * Classe abstrata representando uma moeda genérica com centavos.
 * O motivo da existência dessa classe é de permitir a manipulação
 * de valores financeiros sem se preocupar com frações de centavos.
 * Classes clientes podem usar double para manipular valores mas,
 * ao passar tais valores para uma Moeda, as frações de centavos
 * somem.
 * <P>A classe é abstrata porque não sabemos o nome da moeda e não temos portanto
 * um método toString().
 *
 * @author Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1 (adicionei setCentavos)
 * <br>
 * Copyright (C) 1999, 2000 Universidade Federal da Paraíba.
 */

public abstract class Moeda implements Serializable {
  static final long serialVersionUID = -51315915643707243L;
  private long  centavos;

  /**
   * Controi um valor 0,0 como Moeda.
   */
  public Moeda() {
    this(0.0);
  }

  /**
   * Controi um valor como Moeda.
   * @param valor O valor a representar.
   */
  public Moeda(double valor) {
    setValor(valor);
  }

  /**
   * Recupera o valor como double.
   * @return O valor como double.
   */
  public double getValor() {
    return centavos / 100.0;
  }

  /**
   * Ajusta o valor a ser representado como moeda.
   * @param valor O valor a representar como moeda.
   */
  public void setValor(double valor) {
    // Vai perder frações de centavos aqui
    // Ajustar 0.5 centavos é para arredondar ao
    // centavo mais próximo
    if(valor >= 0) {
      this.centavos = (long)(valor*100.0 + 0.5);
    } else {
      this.centavos = (long)(valor*100.0 - 0.5);
    }
  }

  /**
   * Compara igualdade de duas moedas.
   * @param outroObjeto O outro valor a comparar.
   */
  public boolean equals(Object outroObjeto) {
    if(!(outroObjeto instanceof Moeda)) {
      return false;
    }
    return getValor() == ((Moeda)outroObjeto).getValor();
  }

  /**
   * Compara dois valores de moeda.
   * @param outra A outra moeda a comparar.
   * @return 0 se a moeda for igual à outra moeda; -1 se ela for menor e +1 se for maior.
   */
   public int compareTo(Moeda outra) {
     long diferença = getCentavos() - outra.getCentavos();
     return diferença == 0 ? 0 : (diferença < 0 ? -1 : 1);
   }

  /**
   * Representa o valor da moeda como string.
   */
  public abstract String toString();

  protected long getCentavos() {
    return centavos;
  }
  protected void setCentavos(long centavos) {
    this.centavos = centavos;
  }
}