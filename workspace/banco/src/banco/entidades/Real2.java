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
 * A moeda Real (Brasil). Tem corte automático de frações de centavos.
 * O motivo da existência dessa classe é de permitir a manipulação
 * de valores financeiros sem se preocupar com frações de centavos.
 * Classes clientes podem usar double para manipular valores mas,
 * ao passar tais valores para uma Moeda, as frações de centavos
 * somem.
 *
 * ****** Esta classe tem erros e serve para ensinar testes de unidade ******
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */

public class Real2 {
  private long  centavos;

  /**
   * Controi um valor 0.0 em moeda Real
   */
  public Real2() {
    this(0.0);
  }

  /**
   * Controi um valor em moeda Real.
   * @param valor O valor em reais.
   */
  public Real2(double valor) {
    setValor(valor);
  }

  /**
   * Recupera o valor como double.
   * @return	O valor como double.
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
    // Tem um erro aqui (vide Moeda.java para ver o correto)
    setCentavos((long)(valor*100.0 + 0.5));
  }
  /**
   * Compara igualdade de duas moedas.
   * @param moeda O outro valor a comparar.
   */
  public boolean equals(Object moeda) {
    if(!(moeda instanceof Real2)) {
      return false;
    }
    return getValor() == ((Real2)moeda).getValor();
  }

  /**
   * Compara dois valores de moeda.
   * @param outra A outra moeda a comparar.
   * @return 0 se a moeda for igual à outra moeda; -1 se ela for menor e +1 se for maior.
   */
   public int compareTo(Real2 outra) {
     long diferença = getCentavos() - outra.getCentavos();
     return diferença == 0 ? 0 : (diferença < 0 ? -1 : 1);
   }

  /**
   * Representa o valor da moeda como string
   */
  public String toString() {
    String resultado = "R$";
    long centavos = getCentavos();
    long cent = centavos % 100;
    resultado += centavos/100 + "," + (cent < 10 ? "0" : "") + cent;
      return resultado;
  }
  protected long getCentavos() {
    return centavos;
  }
  protected void setCentavos(long centavos) {
    this.centavos = centavos;
  }
}