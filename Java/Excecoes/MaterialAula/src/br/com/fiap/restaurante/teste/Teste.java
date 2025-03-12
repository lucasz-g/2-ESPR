package br.com.fiap.restaurante.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fiap.restaurante.exceptions.MesaInvalidaException;
import br.com.fiap.restaurante.exceptions.PedidoInvalidoException;
import br.com.fiap.restaurante.model.Cardapio;
import br.com.fiap.restaurante.model.Pedido;
import br.com.fiap.restaurante.model.Prato;

public class Teste {

	public static void main(String[] args) {

		try {
			Cardapio cardapio = new Cardapio();

			System.out.println("###### CARDAPIO ######");
			for (Prato prato : cardapio.getPratos().values()) {
				prato.exibirPrato();
			}

			System.out.println("Escolha o seu prato: ");
			Scanner entrada = new Scanner(System.in);
			Prato prato = cardapio.getPratos().get(entrada.nextInt());

			List<Prato> listaPrato = new ArrayList<Prato>();
			listaPrato.add(prato);
			
			System.out.println("O prato escolhido é: ");
			prato.exibirPrato();

			Pedido pedido = new Pedido(1, listaPrato, null);
			pedido.fazerPedido();
			
			entrada.close();
		} catch (ArithmeticException e) {
			System.out.println("Erro de calculo" + e.getMessage()) ;
		} catch (NullPointerException e) {
			System.out.println("Erro de objeto null" + e.getMessage());
		} catch (PedidoInvalidoException e) {
			System.out.println("Pedido inválido: " + e.getMessage());
		} catch (MesaInvalidaException  e) {
			System.out.println("Mesa inválida: " + e.getMessage());
		}

	}
}
