package br.com.restaurante.pagamento.teste;

import br.com.restaurante.pagamento.model.Pagamento;
import br.com.restaurante.pagamento.model.PagamentoCredito;
import br.com.restaurante.pagamento.model.PagamentoDebito;
import br.com.restaurante.pagamento.model.PagamentoException;
import br.com.restaurante.pagamento.model.PagamentoVR;

public class TestePagamento {
	 public static void main(String[] args) {
	        try {
	            System.out.println("=== Teste Pagamento Crédito ===");
	            Pagamento pagamentoCredito = new PagamentoCredito(150.00);
	            pagamentoCredito.pagar();

	            System.out.println("\n=== Teste Pagamento Débito ===");
	            Pagamento pagamentoDebito = new PagamentoDebito(200.00);
	            pagamentoDebito.pagar();

	            System.out.println("\n=== Teste Pagamento VR ===");
	            Pagamento pagamentoVR = new PagamentoVR(180.00);
	            pagamentoVR.pagar();
	            
	            System.out.println("\n=== Teste Pagamento Inválido ===");
	            try {
	                Pagamento pagamentoInvalido = new PagamentoCredito(-50.00);
	                pagamentoInvalido.pagar();
	            } catch (PagamentoException e) {
	                System.err.println("Erro esperado: " + e.getMessage());
	            }

	        } catch (PagamentoException e) {
	            System.err.println("Erro inesperado: " + e.getMessage());
	        }
	    }
}
