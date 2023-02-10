package aula1;

import java.time.LocalDate;

public class OutroExemploInutilDeClasse {
	public static void main(String[] args) {
		int ano = LocalDate.now().getYear();
		System.out.println("Imprime na saída padrão - a tela!");
		System.out.println("O ano é " + ano);
	}

}