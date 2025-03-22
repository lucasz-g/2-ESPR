package br.com.exercicio.final_.banco;

public class Teste {

	public static void main(String[] args) {
		Banco banco = new Banco("Bradesco", "0001");
		Conta conta = new Conta(banco, "Lucas", 320); 
		
		conta.exibirSaldo();

	}

}
