package aula1;

import javax.swing.JOptionPane;

public class Sobre {

	public static void main(String[] args) {
		String nome = "Raquel";
		char sexo = 'F';
		System.out.println("Nome:" + nome + ", sexo:" + sexo);
		
		nome = JOptionPane.showInputDialog("Digite o novo nome");
		System.out.println("Nome:" + nome + ", sexo:" + sexo);
		
		int idade = Integer.parseInt(JOptionPane.showInputDialog("Quantos anos vocë tem?"));
		double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite sua altura"));
		
		System.out.printf("O nome é %s e a pessoa tem %.2f de altura\n", nome, altura);
		JOptionPane.showMessageDialog(null, "Até mais. Parabéns pelos seus " + idade + " anos");
	}

}