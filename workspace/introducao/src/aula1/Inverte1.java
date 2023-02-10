package aula1;

import java.util.Scanner;

/*
 * Ler 10 números inteiros da entrada, imprimir em ordem inversa
 * Autor: Raquel Lopes
 */

public class Inverte1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] números = new int[10];
		// criação do array de 10 inteiros

		for (int i = 0; i < 10; i++) {
			System.out.print("Entre com o proximo inteiro: ");
			números[i] = sc.nextInt();
		}
		for (int i = 10 - 1; i >= 0; i--) {
			System.out.print(números[i] + " ");
		}
		sc.close();
	}
}
