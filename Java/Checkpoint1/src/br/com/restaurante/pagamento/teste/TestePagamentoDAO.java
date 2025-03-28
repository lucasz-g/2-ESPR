package br.com.restaurante.pagamento.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import br.com.restaurante.pagamento.dao.PagamentoDAOImpl;
import br.com.restaurante.pagamento.model.Pagamento;
import br.com.restaurante.pagamento.model.PagamentoException;

public class TestePagamentoDAO {
    public static void main(String[] args) {
        try {
            // Conectar ao banco de dados
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm554070", "fiap25");
            PagamentoDAOImpl pagamentoDAO = new PagamentoDAOImpl(conn);

            // Criar um pagamento
            Pagamento pagamento = new Pagamento(100.0, "Crédito");
            pagamentoDAO.salvar(pagamento);

            // Buscar e exibir o pagamento
            Pagamento pagamentoEncontrado = pagamentoDAO.buscarPorId(pagamento.getId());
            if (pagamentoEncontrado != null) {
                System.out.println("Pagamento encontrado: " + pagamentoEncontrado.getValor());
            }

            // Atualizar pagamento
            pagamento.setValor(120.0);
            pagamentoDAO.atualizar(pagamento);

            // Listar todos os pagamentos
            pagamentoDAO.listarTodos().forEach(element -> System.out.println("Pagamento ID: " + element.getId()));

            // Deletar pagamento
            pagamentoDAO.apagar(pagamento.getId());

            // Fechar conexão
            conn.close();
        } catch (SQLException | PagamentoException e) {
            e.printStackTrace();
        }
    }
}
