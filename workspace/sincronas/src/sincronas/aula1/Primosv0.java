package sincronas.aula1;

import java.util.Scanner;

public class Primosv0 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o numero. ");

		int numero = sc.nextInt();

		System.out.println("O numero eh " + numero);

		if (numero == 1 || numero == 2 || numero == 3) {
			System.out.println("Numero " + numero + " eh primo");
			System.exit(0);
		}

		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				System.out.println("Numero " + numero + " nao eh primo");
				System.exit(0);
			}
		}

		System.out.println("Numero " + numero + " eh primo");

		sc.close();
	}

}
