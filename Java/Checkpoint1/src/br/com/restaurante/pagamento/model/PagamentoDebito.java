package br.com.restaurante.pagamento.model;

public class PagamentoDebito extends Pagamento{

	public PagamentoDebito(double valor) throws PagamentoException {
		super(valor, "Debito");
	}

}
