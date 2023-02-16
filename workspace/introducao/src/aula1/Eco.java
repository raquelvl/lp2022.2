package aula1;

/*
 * Ecoar argumentos de linha de comando
 * Autor: Jacques Sauvé
 */

public class Eco {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}