package br.com.exercicio.interfaces.pagamento;

public class TestePagamento {
    public static void main(String[] args) {
        Pagamento cartao = new CartaoCredito();
        Pagamento boleto = new Boleto();

        cartao.realizarPagamento();
        cartao.estornarPagamento();

        boleto.realizarPagamento();
        boleto.estornarPagamento();
    }
}
