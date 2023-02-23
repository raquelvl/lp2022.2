package banco.entidades;

import java.util.Objects;

/**
 * Classe abstrata de conta bancária com implementações default de alguns
 * métodos.
 * 
 * @author raquelvl
 * @author jacquesps
 * @verison 1.0
 *
 */
public abstract class Conta {
	private long numeroDaConta;
	private double saldo;
	private Pessoa titular;
	private static boolean sucesso = true;
	private static boolean falha = false;

	/**
	 * Cria uma conta a partir de uma pessoa. O número da conta é gerado
	 * automaticamente pelo sistema.
	 * 
	 * @param titular O titular (pessoa) da conta.
	 */
	public Conta(Pessoa titular) {
		super();
		this.titular = titular;
	}

	/**
	 * Cria uma conta a partir de um nome e CPF de titular da conta. O número da
	 * conta é gerado automaticamente pelo sistema.
	 * 
	 * @param nomeTitular Nome do titular da conta.
	 * @param cpfTitular  CPF do titular da conta.
	 */
	public Conta(String nomeTitular, String cpfTitular) {
		super();
		numeroDaConta = GeradorDeNumeroDeConta.geraNumero();
		titular = new Pessoa(nomeTitular, cpfTitular);
	}

	/**
	 * Recupera o saldo da conta.
	 * 
	 * @return O saldo da conta como um valor double.
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * Efetua saque na conta.
	 * 
	 * @param valor O valor a sacar.
	 * @return Sucesso ou não da operação. Sucesso ocorre quando o saldo da conta é
	 *         suficiente para o saque.
	 */
	public boolean saca(double valor) {
		if (valor >= 0 && valor <= saldo) {
			saldo -= valor;
			return sucesso;
		}
		return falha;
	}

	/**
	 * Efetua um depósito na conta.
	 * @param valor	O valor a depositar.
	 * @return	Sucesso ou não da operação. Sucesso ocorre quando o valor
	 *         	a depositar é positivo.
	 */
	public boolean deposita(double valor) {
		if (valor > 0) {
			saldo += valor;
			return sucesso;
		}
		return falha;
	}

	/**
	 * Efetua transferência entre contas.
	 * @param valor			O valor a ser transferido.
	 * @param contaDestino	A conta destido, isto é, para a qual 
	 * 						o valor será transferido.  
	 * @return				O sucesso ou não da operação. Há insucesso se não houver saldo suficiente.
	 */
	public boolean transfere(double valor, Conta contaDestino) {
		if (saca(valor)) {
			contaDestino.deposita(valor);
			return sucesso;
		}
		return falha;
	}

	/**
	 * Recupera o número da conta.
	 * @return	O número da conta.
	 */
	public long getNumeroDaConta() {
		return numeroDaConta;
	}

	/**
	 * Recupera a pessoa titular da conta.
	 * @return	O titular da conta.
	 */
	public Pessoa getTitular() {
		return titular;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroDaConta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Conta))
			return false;
		Conta other = (Conta) obj;
		return numeroDaConta == other.numeroDaConta;
	}

	@Override
	public String toString() {
		return "Conta [numeroDaConta=" + numeroDaConta + ", saldo=" + saldo + ", titular=" + titular + "]";
	}

}
