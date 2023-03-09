package banco.entidades.util;

import java.util.Scanner;

public class RecebeDados {
	private static Scanner sc = new Scanner(System.in);

	public static double recebeValorMaiorQueZero(String prompt) {

		System.out.println(prompt);
		while (!sc.hasNextDouble()) {
			sc.next();
			return recebeValorMaiorQueZero(prompt);
		}
		double valor = sc.nextDouble();
		if (valor <= 0) {
			System.out.println("O valor deve ser maior que zero.");
			return recebeValorMaiorQueZero(prompt);
		}
		return valor;
	}

	public static int recebeInteiro(String prompt) {
		System.out.println(prompt);
		while (!sc.hasNextInt()) {
			sc.next();
			return recebeInteiro(prompt);
		}

		return sc.nextInt();
	}

}
