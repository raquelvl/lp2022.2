package banco.entidades;

import java.util.Objects;

/**
 * Classe representando uma pessoa física.
 * @author raquelvl
 * @author jacquesps
 *
 */
public class Pessoa {
	private String nome;
	private String cpf;

	/**
	 * Cria uma pessoa a partir de seu nome e CPF.
	 * @param nome	O nome da pessoa física.
	 * @param cpf	O CPF da pessoa física.
	 */
	public Pessoa(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}

	/**
	 * Cria uma pessoa a partir de seu nome.
	 * @param nome	O nome da pessoa física.
	 */
	public Pessoa(String nome) {
		super();
		this.nome = nome;
	}

	public Pessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Recupera o nome da pessoa.
	 * @return	O nome da pessoa.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Ajusta o nome da pessoa.
	 * @param nome	O novo nome a ser ajustado.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Recupea o CPF da pessoa.
	 * @return	O CPF da pessoa.
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Ajusta o CPF da pessoa.
	 * @param cpf	O novo CPF a ser ajustado.
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Pessoa))
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(nome, other.nome);
	}

}
