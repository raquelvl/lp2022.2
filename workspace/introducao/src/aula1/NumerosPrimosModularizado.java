package aula1;

import java.util.Scanner;

public class NumerosPrimosModularizado {
	static int[] primos = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37 };

	public static void main(String[] args) {

		String prompt1 = "Quantos números você quer testar? (numero > 0)";
		String prompt2 = "Qual numero voce quer testar agora? (numero entre 1 e 40) ";
		
		
		int quantidadeDeTestes = recebeNumero(prompt1);
		validaQuantidadeDeTestes(quantidadeDeTestes); //sai do programa se nao for num. ok

		for(int i = 0; i < quantidadeDeTestes; i++) { 		
			int numero = recebeNumero(prompt2);

			if(!isNumeroValido(numero))
				continue; //se nao validar pula tudo que vem depois e inicia o proximo loop no for
			
			System.out.println(resultadoToString(numero, testaSeEhPrimo(numero)));

		}

	}

	private static boolean testaSeEhPrimo(int numero) {
		boolean isPrimo = true;

		if (numero == 1) {
			return isPrimo;
		}

		for (int j = 0; j < primos.length; j++) {
			if (primos[j] >= numero) {
				break;
			}
			if (numero % primos[j] == 0) {
				isPrimo = false;
				break;
			}
		}
		return isPrimo;
	}

	private static String resultadoToString(int numero, boolean isPrimo) {
		return isPrimo ? "O numero " + numero + " eh primo!" : "O numero " + numero + " nao eh primo!";
	}

	private static void validaQuantidadeDeTestes(int quantidadeDeTestes) {
		if (quantidadeDeTestes < 0) {
			System.err.println("Digite um numero maior que zero de testes a serem realizados");
			System.exit(1);
		}
	}
	
	private static boolean isNumeroValido(int numero) {
		if(numero > 40 || numero < 0) {
			System.err.println("O numero a ser testado deve estar entre 1 e 40.");
			return false;
		}
		return true;
	}

	private static int recebeNumero(String prompt) {
		Scanner sc = new Scanner(System.in);
		System.out.println(prompt);
		while(!sc.hasNextInt()) sc.next();
		int numero = sc.nextInt();
		return numero;
	}

}
