package br.com.concessionaria.cadastro.entities;

public class Carro {
	private int id;
	private int ano;
	private double preco;
	private String marca;
	private String modelo;
	
	public Carro() {
		// TODO Auto-generated constructor stub
	}
	
	public Carro(int id, int ano, double preco, String marca, String modelo) {
		super();
		this.id = id;
		this.ano = ano;
		this.preco = preco;
		this.marca = marca;
		this.modelo = modelo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	
}
