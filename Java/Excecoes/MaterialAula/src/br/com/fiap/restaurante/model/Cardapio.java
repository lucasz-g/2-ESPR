package br.com.fiap.restaurante.model;

import java.util.HashMap;
import java.util.Map;

public class Cardapio {
	
	private Map<Integer, Prato> pratos;
	private Map<Integer, Bebida> bebidas;
	
	public Cardapio() {
		this.pratos = carregarPratos();
		this.bebidas = carregarBebidas();
	}

	public Map<Integer, Prato> getPratos() {
		return pratos;
	}

	public void setPratos(Map<Integer, Prato> pratos) {
		this.pratos = pratos;
	}

	public Map<Integer, Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(Map<Integer, Bebida> bebidas) {
		this.bebidas = bebidas;
	}
	
	public Map<Integer, Prato> carregarPratos() {
		
		Map<Integer, Prato> pratos = new HashMap<>();
		Prato prato = new Prato(1, "Baião de Dois", "Arroz, feijao fradinho, linguica calabreza", 50.f);
		pratos.put(prato.getCodigo(), prato);
		
		Prato prato1 = new Prato(2, "Da casa", "Carne moida com batata", 30.f);
		pratos.put(prato1.getCodigo(), prato1);
		
		Prato prato2 = new Prato(3, "Parmegiana de Carne", "File Mignon, arroz, fritas", 70f);
		pratos.put(prato2.getCodigo(), prato2);
		
		return pratos;
	}
	
	public Map<Integer, Bebida> carregarBebidas() {
		
		Map<Integer, Bebida> bebidas = new HashMap<>();
		
		Bebida bebida = new Bebida(1, "Refrigerante", "Coca-cola, Fanta, Guaraná", 8f);
		bebidas.put(bebida.getCodigo(), bebida);
		
		Bebida bebida1 = new Bebida(2, "Cerveja", "Corona, Skol, Original", 12f);
		bebidas.put(bebida1.getCodigo(), bebida1);
		
		Bebida bebida2 = new Bebida(2, "Suco", "Laranja, Limão, Melancia, Melão", 12f);
		bebidas.put(bebida2.getCodigo(), bebida2);
		
		return bebidas;
		
	}

}
