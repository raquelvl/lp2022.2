package aula1;

import java.util.Scanner;

/*
 * "Ler 3 números inteiros da entrada, imprimir o 
 *  menor e o maior"
 *
 * Autor: Jacques Sauvé
 */

public class MinMax4 {
	public static void main(String[] args) {
		final int NÚMEROS_A_LER = 3;
		Scanner sc = new Scanner(System.in);
		int mínimo = Integer.MAX_VALUE;
		int máximo = Integer.MIN_VALUE;

		for (int i = 0; i < NÚMEROS_A_LER; i++) {
			System.out.print("Entre com o proximo inteiro:");
			int num = sc.nextInt();
			if (num < mínimo) {
				mínimo = num;
			}
			if (num > máximo) {
				máximo = num;
			}
		}
		sc.close();
		System.out.println("O menor numero eh: " + mínimo);
		System.out.println("O maior numero eh: " + máximo);
	}
}
