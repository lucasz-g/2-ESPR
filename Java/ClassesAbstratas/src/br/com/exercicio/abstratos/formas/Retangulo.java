package br.com.exercicio.abstratos.formas;

public class Retangulo extends FormaGeometrica {

	private float base;
	private float altura; 
	
	public Retangulo(float base, float altura) {
		this.base = base;
		this.altura = altura; 
	}
	
	@Override
	public void calcularArea() {
		float area = this.base * this.altura; 
		System.out.println("Area do retangulo: " + area);
		
	}

	@Override
	public void calcularPerimetro() {
		float perimetro = 2 * (this.base + this.altura);
		System.out.println("Perimetro do retangulo: " + perimetro);
	}
	
}
