package banco.front;

import banco.entidades.ContaSimples;

public class ATM {

	public static void main(String[] args) {
		ContaSimples contaRaquel = new ContaSimples("Raquel Lopes", "000111222-33");
		System.out.println(contaRaquel);

		ContaSimples contaMarcus = new ContaSimples("Marcus Carvalho", "444555666-77");
		System.out.println(contaMarcus);

		contaRaquel.saca(10.0);
		System.out.println(contaRaquel);

		contaRaquel.transfere(10, contaMarcus);
		System.out.println(contaRaquel);
		System.out.println(contaMarcus);

		contaMarcus.deposita(10);
		System.out.println(contaMarcus);

		contaMarcus.transfere(5, contaRaquel);
		System.out.println(contaRaquel);
		System.out.println(contaMarcus);

	}

}
