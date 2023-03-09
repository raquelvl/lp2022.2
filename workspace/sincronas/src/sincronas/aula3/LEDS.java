package sincronas.aula3;

import java.util.Scanner;

public class LEDS {
	public static void main(String[] args) {
		int[] numeroDeLeds = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int rodada = 0; rodada < N; rodada++) {
			String numero = sc.next();
			char[] tokens = numero.toCharArray();

			int soma = 0;
			for (int i = 0; i < tokens.length; i++) {
				int indice = charToInt(tokens[i]);
				soma += numeroDeLeds[indice];
			}

			System.out.println(soma + " leds");

		}
		sc.close();
	}

	private static int charToInt(char token) {
		return Integer.parseInt(String.valueOf(token));
	}
}
