package br.com.restaurante.pagamento.model;

public class PagamentoCredito extends Pagamento{
	
	public PagamentoCredito(double valor) throws PagamentoException{
		super(valor, "Credito");
	}
	
}
