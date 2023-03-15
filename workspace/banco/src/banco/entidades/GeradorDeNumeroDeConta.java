package banco.entidades;

public class GeradorDeNumeroDeConta {
	private static long num = 1;
	
	public static long geraNumero() {
		return num++;
	}
	
	public static void setNumero(long numero){
		num = numero;
	}
}
