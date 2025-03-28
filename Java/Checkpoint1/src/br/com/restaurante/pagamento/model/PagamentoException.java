package br.com.restaurante.pagamento.model;

public class PagamentoException extends Exception {
	/**
	 * Exceção personalizada para erros relacionados ao pagamento.
	 */
	public PagamentoException(String mensagem) {
		super(mensagem);
	}
}
