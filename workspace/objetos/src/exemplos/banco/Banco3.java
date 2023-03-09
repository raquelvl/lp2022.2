package exemplos.banco;

import banco.entidades.Agencia;
import banco.entidades.ContaSimples;
import banco.entidades.Pessoa;
import banco.entidades.util.RecebeDados;

public class Banco3 {
	public static void main(String[] args) {
		// declaração de variáveis de 2 classes (tipos) diferentes
		// no fim, teremos 4 objetos de 2 classes
		Pessoa oTitular1, oTitular2;

		ContaSimples umaConta, outraConta;

		// tempo de vida: os objetos ainda nao existem
		// a seguinte linha daria erro:
		// umaConta.depositar(1000.0);
		// cria dois objetos Pessoa com nome e CPF

		oTitular1 = new Pessoa("Joao", "30914060506");
		oTitular2 = new Pessoa("Ana", "12345678901");

		// cria as duas contas
		// Observe que ContaSimples pode ser criada com um titular
		// do tipo Pessoa em vez de dar nome e CPF separadamente
		umaConta = new ContaSimples(oTitular1);
		outraConta = new ContaSimples(oTitular2);

		// Vamos ver quanto vamos depositar
		double valorADepositar = RecebeDados.recebeValorMaiorQueZero("Entre com o valor a depositar: ");

		System.out.println("Vou depositar " + valorADepositar);
		umaConta.depositar(valorADepositar);

		// Vamos ver quanto vamos transferir
		double valorATransferir = RecebeDados.recebeValorMaiorQueZero("Entre com o valor a transferir: ");

		System.out.println("Vou transferir " + valorATransferir);
		umaConta.transferir(outraConta, valorATransferir);

		// Fecha a agencia e guarda toda a informação em arquivo
		Agencia.fecharCaixa();

		System.out.println("OK. Caixa fechado.");
	}
}
