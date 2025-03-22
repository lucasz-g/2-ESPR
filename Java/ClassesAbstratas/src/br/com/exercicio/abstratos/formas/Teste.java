package br.com.exercicio.abstratos.formas;

public class Teste {
	public static void main(String[] args) {
		FormaGeometrica circulo = new Circulo(50); 
		FormaGeometrica retangulo = new Retangulo(40, 20); 
		
		circulo.calcularArea();
		circulo.calcularPerimetro();
		
		retangulo.calcularArea();
		retangulo.calcularPerimetro();
		
	}
}
