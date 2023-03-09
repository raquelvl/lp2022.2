package sincronas.aula3;

import java.util.Scanner;

public class SomaNumeros {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final int NUM_LEITURAS = 5;
		int soma = 0;
		
		for (int i = 0; i < NUM_LEITURAS; i++) {
			soma += leInteiro(sc);
		}
		
		System.out.println("A soma dos numeros é " + soma);
		sc.close();
	}

	private static int leInteiro(Scanner sc) {
		System.out.println("Digite um numero inteiro");
		if(sc.hasNextInt())
			return sc.nextInt();
		sc.next();
		return leInteiro(sc);
	}
}
