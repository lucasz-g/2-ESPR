package br.com.restaurante.pagamento.dao;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.restaurante.pagamento.model.Pagamento;
import br.com.restaurante.pagamento.model.PagamentoException;

public class PagamentoDAOImpl implements PagamentoDAO {
    
    private Connection conn;
    
    public PagamentoDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void salvar(Pagamento pagamento) {
        try {
            // Verifica se o pagamento é válido
            if (pagamento.getValor() < 0) {
                throw new PagamentoException("Valor de pagamento não pode ser negativo!");
            }
            
            String insert = "INSERT INTO RM554070.PAGAMENTO (ID, VALOR, FORMA_PAGAMENTO, DATA) VALUES (?, ?, ?, ?);";
            
            try (PreparedStatement preparedStatement = conn.prepareStatement(insert)) {
                preparedStatement.setInt(1, pagamento.getId());
                preparedStatement.setDouble(2, pagamento.getValor());
                preparedStatement.setString(3, pagamento.getTipoPagamento());
                preparedStatement.setTimestamp(4, Timestamp.valueOf(pagamento.getDataHora()));
                
                preparedStatement.executeUpdate();
                System.out.println("Inclusão realizada!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (PagamentoException e) {
            // Log ou tratativa específica de erro de pagamento
            System.err.println("Erro ao salvar pagamento: " + e.getMessage());
        }
    }

    @Override
    public void atualizar(Pagamento pagamento) {
        
    	try {
            // Verifica se o pagamento é válido
            if (pagamento.getValor() < 0) {
                throw new PagamentoException("Valor de pagamento não pode ser negativo!");
            }
    	
    	String update = "UPDATE RM554070.PAGAMENTO SET VALOR=?, FORMA_PAGAMENTO=?, DATA=? WHERE ID=?;";
        
    	try (PreparedStatement preparedStatement = conn.prepareStatement(update)) {
            preparedStatement.setDouble(1, pagamento.getValor());
            preparedStatement.setString(2, pagamento.getTipoPagamento());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(pagamento.getDataHora()));
            preparedStatement.setInt(4, pagamento.getId());

            preparedStatement.executeUpdate();
            System.out.println("Atualização realizada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } catch (PagamentoException e) {
        // Log ou tratativa específica de erro de pagamento
        System.err.println("Erro ao atualizar pagamento: " + e.getMessage());
    }
}

    @Override
    public void apagar(int id) {
        String delete = "DELETE FROM RM554070.PAGAMENTO WHERE ID=?;";
        
        try (PreparedStatement preparedStatement = conn.prepareStatement(delete)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Remoção realizada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pagamento buscarPorId(int id) {
        String select = "SELECT ID, VALOR, FORMA_PAGAMENTO, DATA FROM RM554070.PAGAMENTO WHERE ID=?;";
        Pagamento pagamento = null;

        try (PreparedStatement preparedStatement = conn.prepareStatement(select)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                double valor = resultSet.getDouble("VALOR");
                if (valor < 0) {
                    throw new PagamentoException("Valor de pagamento inválido encontrado no banco de dados!");
                }

                String tipoPagamento = resultSet.getString("FORMA_PAGAMENTO");
                LocalDateTime dataHora = resultSet.getTimestamp("DATA").toLocalDateTime();

                pagamento = new Pagamento(valor, tipoPagamento);
                pagamento.setId(resultSet.getInt("ID"));
                pagamento.setDataHora(dataHora);
            }

            System.out.println("Consulta realizada!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PagamentoException e) {
            // Tratar erro específico de pagamento
            System.err.println("Erro ao buscar pagamento: " + e.getMessage());
        }

        return pagamento;
    }


    @Override
    public List<Pagamento> listarTodos() {
        String select = "SELECT ID, VALOR, FORMA_PAGAMENTO, DATA FROM RM554070.PAGAMENTO;";
        List<Pagamento> pagamentos = new ArrayList<>();

        try (PreparedStatement preparedStatement = conn.prepareStatement(select)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                double valor = resultSet.getDouble("VALOR");
                String tipoPagamento = resultSet.getString("FORMA_PAGAMENTO");
                LocalDateTime dataHora = resultSet.getTimestamp("DATA").toLocalDateTime();

                Pagamento pagamento = new Pagamento(valor, tipoPagamento);
                pagamento.setId(resultSet.getInt("ID"));
                pagamento.setDataHora(dataHora);

                pagamentos.add(pagamento);
            }

            System.out.println("Consulta realizada!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PagamentoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return pagamentos;
    }
}
