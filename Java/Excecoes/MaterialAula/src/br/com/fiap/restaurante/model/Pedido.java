package br.com.fiap.restaurante.model;

import java.util.List;

import br.com.fiap.restaurante.exceptions.MesaInvalidaException;
import br.com.fiap.restaurante.exceptions.PedidoInvalidoException;

public class Pedido {
	
	private int numMesa;
	private List<Prato> pratos;
	private List<Bebida> bebidas;
	
	public Pedido(int numMesa, List<Prato> pratos, List<Bebida> bebidas) {
		this.numMesa = numMesa;
		this.pratos = pratos;
		this.bebidas = bebidas;
	}

	public int getNumMesa() {
		return numMesa;
	}

	public void setNumMesa(int numMesa) {
		this.numMesa = numMesa;
	}

	public List<Prato> getPratos() {
		return pratos;
	}

	public void setPratos(List<Prato> pratos) {
		this.pratos = pratos;
	}

	public List<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	public void fazerPedido() throws MesaInvalidaException, PedidoInvalidoException{
		
		if(this.numMesa == 0) {
			throw new MesaInvalidaException("Número da mesa inválido!");
		}
		
		if(this.pratos == null && this.bebidas == null) {
			throw new PedidoInvalidoException("Precisa informar o prato ou bebida");
		}
	
	}

}
