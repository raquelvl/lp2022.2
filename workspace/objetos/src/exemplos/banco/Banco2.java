package exemplos.banco;

import banco.entidades.ContaSimples;

public class Banco2 {
	public static void main(String[] args) {
		// Abra uma conta para João com CPF 309140605-06
		ContaSimples contaJoao = new ContaSimples("João", "309140605-06");
		// Pessoa joao = new Pessoa("João", "309140605-06");
		// ContaSimples contaJoao = new ContaSimples(joao);

		// Nesta conta, deposite R$1000,00
		contaJoao.depositar(1000);

		// Abra uma conta para Ana com CPF 123456789-01
		ContaSimples contaAna = new ContaSimples("Ana", "123456789-01");

		// Transfira R$400,00 da conta de João para a conta de Ana
		contaJoao.transferir(contaAna, 400);

		// Imprima a conta de João
		System.out.println(contaJoao);

		// Imprima a conta de Ana
		System.out.println(contaAna);
	}
}
