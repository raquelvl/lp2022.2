package aula1;

import java.util.Scanner;

public class NumerosPrimos {

	public static void main(String[] args) {
		int[] primos = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
		Scanner sc = new Scanner(System.in);
		String prompt1 = new String("Quantos números você quer testar? (numero > 0)");
		String prompt2 = "Qual numero voce quer testar agora? (numero entre 1 e 40) ";
		System.out.println(prompt1);
		int quantidadeDeTestes = sc.nextInt();
		
		if(quantidadeDeTestes < 0) {
			System.err.println("Digite um numero maior que zero de testes a serem realizados");
			System.exit(1);
		}
			
		for (int i = 0; i < quantidadeDeTestes; i++) {
			System.out.println(prompt2);
			int numero = sc.nextInt();
			
			if(numero == 1) {
				System.out.println("O numero " + numero + " eh primo!");
				break;
			}
			
			if(numero > 40 || numero < 0) {
				System.err.println("Digite um numero entre 1 e 40");
				System.exit(1);
			}
			
			boolean isPrimo = true;
			for (int j = 0; j < primos.length; j++) {
				System.out.println("primos[j] = " + primos[j]);
				if(primos[j] >= numero) {
					System.out.println("numero menor que primos[j] vai sair do for");
					System.out.println("isPrimo = " + isPrimo);
					break;
				}
				if(numero % primos[j] == 0) {
					System.out.println("O numero " + numero + " nao eh primo!");
					isPrimo = false;
					break;
				}				
			}
			if(isPrimo)
				System.out.println("O numero " + numero + " eh primo!");
		}	
		
	}

}
