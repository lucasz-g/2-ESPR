package integracaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Teste {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // URL para Oracle
        String user = "seu_usuario"; // Insira o seu usuário
        String password = "sua_senha"; // Insira a sua senha
        
        String insert = "INSERT INTO ALUNO (ID, NOME, DOCUMENTO) VALUES (?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        
        try {
            // Estabelece a conexão com o banco de dados
            conn = DriverManager.getConnection(url, user, password);
            
            // Prepara o statement para o INSERT
            preparedStatement = conn.prepareStatement(insert);
            
            // Definir os valores para os parâmetros do INSERT
            preparedStatement.setInt(1, 1); // ID do aluno (por exemplo, 1)
            preparedStatement.setString(2, "Lucas Garcia"); // Nome do aluno
            preparedStatement.setString(3, "12345678900"); // Documento do aluno
            
            // Executa o comando INSERT
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Linhas inseridas: " + rowsAffected);
        } catch (SQLException e) {
            // Exibe a mensagem de erro caso ocorra algum problema
            System.out.println("Erro: " + e.getMessage());
        } finally {
            // Fecha os recursos
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
}
