package br.com.exercicio.final_.banco;

public final class Banco {
	
	private String nomeBanco; 
	private String agencia;
	
	public Banco(String nomeBanco, String agencia) {
		this.nomeBanco = nomeBanco;
		this.agencia = agencia;
	}
	
	public void imprimirDadosBancarios() {
		System.out.println("Nome do banco: " + this.nomeBanco);
		System.out.println("Agencia: " + this.agencia);
	}
	
}
