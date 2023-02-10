package aula1;

import java.util.Scanner;

/*
 * Ler 10 números inteiros da entrada, imprimir em ordem inversa
 * Autor: Jacques Sauvé
 */

public class Inverte {
	public static void main(String[] args) {
		final int NÚMEROS_A_LER = 10;
		Scanner sc = new Scanner(System.in);
		int[] números = new int[NÚMEROS_A_LER];
		// criação do array de 10 inteiros

		for (int i = 0; i < números.length; i++) {
			System.out.print("Entre com o proximo inteiro: ");
			números[i] = sc.nextInt();
		}
		for (int i = números.length - 1; i >= 0; i--) {
			System.out.println(números[i]);
		}
	}
}
