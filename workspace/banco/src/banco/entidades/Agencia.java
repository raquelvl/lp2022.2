package banco.entidades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/*
 * Desenvolvido para a disciplina Programacao 1
 * Curso de Bacharelado em Ciência da Computação
 * Departamento de Sistemas e Computação
 * Universidade Federal da Paraíba
 *
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 * Não redistribuir sem permissão.
 * 
 * Autor original: Prof. Jacques Sauvé
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import banco.excecoes.NaoPodeFecharContaException;
import banco.entidades.GeradorDeNumeroDeConta;

/**
 * Classe de agência bancária simples.
 * Nesta versão, há uma única agência. A agência tem uma conta "caixa" para
 * depósitos e saques. A agência pode ser "persistente". Isto significa que
 * tudo que ocorreu de movimentação de contas pode ser gravado em disco
 * para uso posterior ao fechar a agência.
 *
 * @author   Jacques Philippe Sauvé, jacques@dsc.ufpb.br
 * @version 1.1
 * <br>
 * Copyright (C) 1999 Universidade Federal da Paraíba.
 */
public class Agencia {
  protected static boolean    aberto = false;
  protected static Conta    caixa = null;
  protected static Movimento  movimento = null; // movimento da agencia como um todo
  protected static Map    titulares = null;
  protected static Map    contas = null;

  /**
   * Recupera a conta "caixa".
   * @return A conta caixa.
   */
  public static Conta getContaCaixa() {
    abrirCaixa();
    return caixa;
  }

  /**
   * Recupera todo o movimento da agência.
   * @return O movimento da agência.
   */
  public static Movimento getMovimento() {
    abrirCaixa();
    return movimento;
  }

  /**
   * Obtem o iterador de todos os titulares da agência.
   * @return O iterador de titulares da agência.
   */
  public static Iterator getTitulares() {
    abrirCaixa();
    return titulares.values().iterator();
  }

  /**
   * Adiciona um titular à agência.
   * @param titular O titular a adicionar.
   */
  public static void addTitular(Pessoa titular) {
    abrirCaixa();
    titulares.put(titular.getCPF(), titular);
  }

  /**
   * Localiza um titular pela chave (cpf, cgc, ...).
   * @param chave A chave de busca do titular, para pessoa física é o CPF.
   * @return O titular pesquisado. Retorna null se não achar.
   */
  public static Pessoa localizarTitular(String chave) {
    abrirCaixa();
    return (Pessoa)titulares.get(chave);
  }

  /**
   * Obtem a iterador de todas as contas da agência.
   * @return O iterador de contas da agência.
   */
  public static Iterator getContas() {
    abrirCaixa();
    return contas.values().iterator();
  }

  /**
   * Adiciona uma conta à agência.
   * @param conta A conta a adicionar.
   */
  public static void addConta(Conta conta) {
    abrirCaixa();
    contas.put(Long.toString(conta.getNúmero()), conta);
  }

  /**
   * Localiza uma conta pelo número.
   * @param número	O número da conta a ser localizada
   * @return A conta pesquisada.<br>Retorna null se não localizar.
   */
  public static Conta localizarConta(long número) {
    abrirCaixa();
    return (Conta)contas.get(Long.toString(número));
  }

  /**
   * Fecha uma conta.
   * @param número O número da conta a fechar.
     * @throws NaoPodeFecharContaException se a conta não existir ou tiver saldo
   */
  /* observe visibilidade "package": tem que fechar a partir de fechar() da conta */
  static void fecharConta(long número) throws NaoPodeFecharContaException {
    abrirCaixa();
    Conta c = localizarConta(número);
    if(c == null) {
      throw new NaoPodeFecharContaException(c, "Conta nao existe");
    }
    if(c.getSaldo() != 0.0) {
      throw new NaoPodeFecharContaException(c, "Saldo nao esta zerado");
    }
    contas.remove(Long.toString(número));
    // tem que repensar o fechamento de contas porque
    // do jeito que esta, nao some do arquivo agencia
  }

  /**
   * Fechamento do caixa e gravação dos dados em arquivo.
   * Aborta o programa com mensagem se houver problemas.
   */
   /* deveria usar exceções se der pau aqui, mas vamos poupar os alunos principiantes (usamos isso em programas iniciais) */
  public static void fecharCaixa() {
    // usamos serializacao de objetos para manter os tipos dos objetos
    // se nao fizesse isso, teria problemas em distinguir tipos de contas, de pessoas, ...
    ObjectOutputStream out = null;
    try {
      try {
        out = new ObjectOutputStream(new FileOutputStream(getNomeArquivo()));
        } catch( FileNotFoundException e ) {
          System.err.println("Nao pode criar " + getNomeArquivo());
          System.exit(1);
        }
      List tudo = new ArrayList();  // junta tudo num unico objeto
                    // para nao perder as ligacoes entre objetos
      tudo.add(titulares);
      tudo.add(contas);
      tudo.add(movimento);
      out.writeObject(tudo);
      out.close();
    } catch(IOException e) {
      System.err.println(e);
      System.exit(1);
    }
  }

  /**
   * Abertura do caixa (da agencia) e leitura dos dados persistentes gravados em arquivo.
     * Aborta o programa com mensagem se houver problemas.
   */
  public static void abrirCaixa() {
    if(aberto) {
      return;
    }
    titulares = new HashMap();
    contas = new HashMap();
    movimento = new Movimento();
    aberto = true; // elimina recursao ao criar a conta caixa
    ObjectInputStream in = null;
    try {
      try {
        in = new ObjectInputStream(new FileInputStream(getNomeArquivo()));
      } catch( FileNotFoundException e ) {
        // nao achar o arquivo significa que estamos começando do zero
        caixa = new ContaCaixa();
        addConta(caixa);
        return;
      }
      List tudo = new ArrayList();
      tudo = (List)in.readObject();
      titulares = (Map)tudo.get(0);
      contas = (Map)tudo.get(1);
      movimento = (Movimento)tudo.get(2);
      caixa = localizarConta(0);
      GeradorDeNumeroDeConta.setNumero(contas.size());
      in.close();
    } catch(Exception e) {
      System.err.println(e);
      System.exit(1);
    }
  }

  protected static String getNomeArquivo() {
    return "agencia.dat";
  }
}
