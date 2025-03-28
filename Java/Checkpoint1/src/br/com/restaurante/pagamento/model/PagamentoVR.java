package br.com.restaurante.pagamento.model;

public class PagamentoVR extends Pagamento {

	public PagamentoVR(double valor) throws PagamentoException{
		super(valor, "Vale-Refeicao");
	}

}
