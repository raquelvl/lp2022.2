package banco.entidades;

import java.util.Objects;

/**
 * Classe de conta bancária simples para pessoa física.
 * @author raquelvl
 * @author jacquesps
 * @version 1.0
 *
 */
public class ContaSimples extends Conta {

	/**
	 * Cria uma conta simples a partir de uma pessoa titular. 
	 * O número da conta é gerado automaticamente pelo sistema.
	 * 
	 * @param titular O titular (pessoa) da conta.
	 */
	public ContaSimples(Pessoa titular) {
		super(titular);
	}

	/**
	 * Cria uma conta a partir de um nome e CPF de titular da conta. O número da
	 * conta é gerado automaticamente pelo sistema.
	 * 
	 * @param nomeTitular Nome do titular da conta.
	 * @param cpfTitular  CPF do titular da conta.
	 */
	public ContaSimples(String nomeTitular, String cpfTitular) {
		super(nomeTitular, cpfTitular);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNumeroDaConta());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ContaSimples))
			return false;
		ContaSimples other = (ContaSimples) obj;
		return getNumeroDaConta() == other.getNumeroDaConta();
	}

}
