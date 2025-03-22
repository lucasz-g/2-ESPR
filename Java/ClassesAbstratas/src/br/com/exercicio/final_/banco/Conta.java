package br.com.exercicio.final_.banco;

public class Conta {
	
	private Banco banco; 
	private String titular;
	private float saldo;

	public Conta(Banco banco, String titular, float saldo) {
		this.banco = banco; 
		this.titular = titular; 
		this.saldo = saldo;
	}
	
	public final void exibirSaldo() {
		this.banco.imprimirDadosBancarios();
		System.out.println("Titular da conta: " + titular);
		System.out.println("Saldo da conta: " + saldo);
	}
	
}
