package br.com.exercicio.interfaces.pagamento;

public class Boleto implements Pagamento{

	@Override
	public void realizarPagamento() {
		System.out.println("Pagamento realizado com boleto");
		
	}

	@Override
	public void estornarPagamento() {
		System.out.println("Estorno realizado no boleto");
		
	}
	
}
