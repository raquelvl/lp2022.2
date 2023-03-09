package exemplos.banco;

import banco.entidades.ContaSimples;

public class Banco1 {
	public static void main(String[] args) {
		// Abra uma conta para João com CPF 309140605-06
		ContaSimples umaConta = new ContaSimples("João", "309140605-06");
		// A conta será "referenciada" com a variável umaConta

		// Nesta conta, deposite R$1000,00
		umaConta.depositar(1000.0);

		// Imprima o saldo da conta de João
		System.out.println("Saldo da conta " + umaConta.getNúmero() + " antes do saque é R$ " + umaConta.getSaldo());

		// Saque R$300,00 desta conta
		umaConta.sacar(300.0);

		// Imprima o objeto umaConta
		System.out.println(umaConta);

		// Imprima o saldo da conta de João
		System.out.println("Saldo da conta " + umaConta.getNúmero() + " depois do saque é R$ " + umaConta.getSaldo());

	}
}
