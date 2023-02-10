package aula1;

import java.util.Scanner;

/*
 * "Ler 3 números inteiros da entrada, imprimir o 
 *  menor e o maior"
 *
 * Autor: Jacques Sauvé
 */

public class MinMax3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		int mínimo = Integer.MAX_VALUE;
		int máximo = Integer.MIN_VALUE;

		System.out.print("Entre com o primeiro inteiro: ");
		num = sc.nextInt();
		if (num < mínimo) {
			mínimo = num;
		}
		if (num > máximo) {
			máximo = num;
		}

		System.out.print("Entre com o segundo inteiro: ");
		num = sc.nextInt();
		if (num < mínimo) {
			mínimo = num;
		}
		if (num > máximo) {
			máximo = num;
		}

		System.out.print("Entre com o terceiro inteiro: ");
		num = sc.nextInt();
		if (num < mínimo) {
			mínimo = num;
		}
		if (num > máximo) {
			máximo = num;
		}
		sc.close();
		System.out.println("O menor numero eh: " + mínimo);
		System.out.println("O maior numero eh: " + máximo);
	}
}
