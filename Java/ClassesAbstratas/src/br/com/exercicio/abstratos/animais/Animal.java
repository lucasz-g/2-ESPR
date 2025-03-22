package br.com.exercicio.abstratos.animais;

public abstract class Animal {
	
	// Declarado, mas sem corpo.
	public abstract void emitirSom();
	
	public void dormir() {
		System.out.println("O animal está dormindo");
	}
	
}