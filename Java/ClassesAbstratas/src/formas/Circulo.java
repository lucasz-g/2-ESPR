package formas;

public class Circulo extends FormaGeometrica{
	
	private float raio; 
	
	public Circulo(float raio) {
		this.raio = raio;
		System.out.println("Raio do circulo: " + raio);
	}
	
	@Override
	public void calcularArea() {
		double rQuadrado = Math.pow(this.raio, 2); 
		double area = rQuadrado * 3.14; 
		System.out.println("Area do circulo: " + area);
	}

	@Override
	public void calcularPerimetro() {
		double perimetro = (2 * 3.14) * (this.raio); 
		System.out.println("Perimetro do circulo: " + perimetro);
	}

}
