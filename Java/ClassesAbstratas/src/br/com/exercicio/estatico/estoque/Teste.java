package br.com.exercicio.estatico.estoque;

public class Teste {

	public static void main(String[] args) {
		
		Produto celular = new Produto("Celular", 2300);
		Produto televisao = new Produto("Televisao", 5000);
		Produto relogio = new Produto("Relogio", 8000);
		
		Estoque.adicionarProduto(celular);
		Estoque.adicionarProduto(televisao);
		Estoque.adicionarProduto(relogio);
		
		Estoque.totalEstocado();
	}

}
