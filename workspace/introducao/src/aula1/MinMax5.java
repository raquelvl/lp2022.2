package aula1;

import java.util.Scanner;

/*
 * "Ler 3 números inteiros da entrada, imprimir o
 *  menor e o maior"
 *
 * Autor: Raquel Lopes
 */

public class MinMax5 {

	public static void main(String[] args) {

		final int NÚMEROS_A_LER = 3;
		Scanner sc = new Scanner(System.in);
		int mínimo = Integer.MAX_VALUE;
		int máximo = Integer.MIN_VALUE;

		for (int i = 0; i < NÚMEROS_A_LER; i++) {
			int num = recebeProximoInteiro(sc);
			mínimo = menorNumeroEntre(mínimo, num);
			máximo = maiorNumeroEntre(máximo, num);
		}

		System.out.println("O menor numero eh: " + mínimo);
		System.out.println("O maior numero eh: " + máximo);
	}

	private static int maiorNumeroEntre(int numero1, int numero2) {
		return numero2 > numero1 ? numero2 : numero1;
	}

	private static int menorNumeroEntre(int numero1, int numero2) {
		return numero2 < numero1 ? numero2 : numero1;
	}

	private static int recebeProximoInteiro(Scanner sc) {
		System.out.print("Entre com o proximo inteiro:");
		int num = sc.nextInt();
		return num;
	}

}
