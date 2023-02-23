package banco.entidades;

import java.util.Objects;

public class ContaSimples {
	private long numeroDaConta;
	private double saldo;
	private String nomeCliente;
	private String cpfCliente;
	private static boolean sucesso = true;
	private static boolean falha = false;

	public ContaSimples(double saldo, String nomeCliente, String cpfCliente) {
		super();
		numeroDaConta = GeradorDeNumeroDeConta.geraNumero();
		this.saldo = saldo;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public boolean saca(double valor) {
		if (valor >=0 && valor <= saldo) {
			saldo -= valor;
			return sucesso;
		}
		return falha;
	}

	public boolean deposita(double valor) {
		if(valor>0) {
			saldo += valor;
			return sucesso;
		}
		return falha;
	}
	
	public boolean transfere(double valor, ContaSimples outraConta) {
		if(saca(valor))	{
			outraConta.deposita(valor);
			return sucesso;
		}
		return falha;
	}

	@Override
	public String toString() {
		return "ContaSimples [numeroDaConta=" + numeroDaConta + ", saldo=" + saldo + ", nomeCliente=" + nomeCliente
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroDaConta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaSimples other = (ContaSimples) obj;
		return numeroDaConta == other.numeroDaConta;
	}

}
