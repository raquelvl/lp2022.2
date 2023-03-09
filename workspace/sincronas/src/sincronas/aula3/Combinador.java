package sincronas.aula3;

import java.util.Scanner;

public class Combinador {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int caso = 0; caso < N; caso++) {
			String str1 = sc.next();
			String str2 = sc.next();

			int menorString = getTamanhoMenorString(str1, str2);
			String maiorString = maiorStringEntre(str1, str2);

			int i = 0;
			String resultado = "";
			for (i = 0; i < menorString; i++) {
				resultado += str1.charAt(i);
				resultado += str2.charAt(i);
			}
			for (; i < maiorString.length(); i++) {
				resultado += maiorString.charAt(i);
			}
			System.out.println(resultado);
		}

	}

	private static String maiorStringEntre(String str1, String str2) {
		return str1.length() > str2.length() ? str1 : str2;
	}

	private static int getTamanhoMenorString(String str1, String str2) {
		return str1.length() > str2.length() ? str2.length() : str1.length();
	}
}
