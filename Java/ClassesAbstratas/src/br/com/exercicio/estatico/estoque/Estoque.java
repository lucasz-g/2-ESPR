package br.com.exercicio.estatico.estoque;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
	private static int totalProdutos = 0; 
	private static List<Produto> produtosEmEstoque = new ArrayList<>();
	
	public static void adicionarProduto(Produto produto) {
		produtosEmEstoque.add(produto);
		totalProdutos++; 
	}
	
	public static void totalEstocado() {
		System.out.println("Total estocado: " + totalProdutos);
		System.out.println("Produtos em estoque: ");		
		for(Produto produto : produtosEmEstoque) {
			System.out.println(produto.getNome());
		}
	}
}