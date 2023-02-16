package sincronas.aula2;

import java.util.Scanner;

public class Primosv1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numero = recebeInteiro(sc);

		if (numero == 1 || numero == 2 || numero == 3) {
			System.out.println("Numero " + numero + " eh primo");
			System.exit(0);
		}

		String resultado = verificaSeEhPrimo(numero);
		System.out.println("O numero " + numero + resultado);

		sc.close();
	}

	private static String verificaSeEhPrimo(int numero) {
		int[] numerosPrimos = { 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37 };
		boolean ehPrimo = false;
		for (int i = 0; i < numerosPrimos.length; i++) {
			if (numero == numerosPrimos[i]) {
				ehPrimo = true;
				break;
			}
		}

		String resultado = ehPrimo ? " eh primo " : " nao eh primo";
		return resultado;
	}

	private static int recebeInteiro(Scanner sc) {
		String prompt1 = "Qual numero voce quer testar? (numero entre 1 e 40) ";
		System.out.println(prompt1);

		String promptErro = "O numero deve estar entre 1 e 40";
		if (!sc.hasNextInt()) {
			System.out.println(promptErro);
			sc.next();
			return recebeInteiro(sc);
		}
		int numero = sc.nextInt();
		return numero;
	}

}
