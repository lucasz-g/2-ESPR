package br.com.exercicio.abstratos.animais;

public class Cachorro extends Animal{
	
	@Override
	public void emitirSom() {
		System.out.println("O cachorro late");
	}
	
	public void dormir() {
		System.out.println("O cachorro está dormindo!");
	}
		
}
