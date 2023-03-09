package exemplos.banco;

import banco.entidades.Agencia;
import banco.entidades.ContaSimples;
import banco.entidades.Extrato;
import banco.entidades.util.Data;
import banco.entidades.util.RecebeDados;

public class Banco4 {
	public static void main(String[] args) {
		// declaração de variáveis de 3 classes (tipos) diferentes
		// no fim, teremos 4 objetos de 3 classes
		ContaSimples umaConta;
		Extrato umExtrato;
		Data hoje, ontem;

		// localiza a conta de número 1
		// (ela já foi criada e armazenada anteriormente)
		// O "cast" (ContaSimples) será explicado em outro momento
		// O motivo é que localizarConta retorna um objeto do tipo Conta
		// que representa uma conta bancária genérica e não apenas uma
		// ContaSimples
		umaConta = (ContaSimples) Agencia.localizarConta(1);

		// Vamos fazer um saque
		System.out.println("Voce tem " + umaConta.getSaldoMonetário() + " na conta");

		double valor = RecebeDados.recebeValorMaiorQueZero("Quanto voce quer sacar? ");
		umaConta.sacar(valor);

		// Vamos tirar um extrato de conta entre ontem e hoje
		hoje = new Data(); // hoje representa a data de hoje
		ontem = new Data(); // ontem ainda representa hoje
		ontem.somarDia(-1); // agora, temos a data de ontem

		umExtrato = umaConta.criarExtrato(ontem, hoje);
		// Imprime o extrato
		System.out.println(umExtrato.formatar());
		System.out.println("Saldo: " + umaConta.getSaldoMonetário());

		// Vamos atualizar as informações persistentes
		Agencia.fecharCaixa();

	}
}
