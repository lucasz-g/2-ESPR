package br.com.exercicio.interfaces.pagamento;

public class CartaoCredito implements Pagamento {
	
	@Override
	public void realizarPagamento() {
		System.out.println("Pagamento realizado com cartão");
	}

	@Override
	public void estornarPagamento() {
		System.out.println("Estorno realizado no cartão");
	}
	
}
