package integracaoBD.modelos;

import java.sql.*;

public class ServicesCRUD {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USER = "rm554070";
    private static final String PASSWORD = "fiap25";

    private Connection conectarBanco() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void inserirAluno(int id, String nome, String documento) {
        String sql = "INSERT INTO ALUNO (ID, NOME, DOCUMENTO) VALUES (?, ?, ?)";
        
        try (Connection conn = conectarBanco();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            
            statement.setInt(1, id);
            statement.setString(2, nome);
            statement.setString(3, documento);
            statement.executeUpdate();
            
            System.out.println("Aluno inserido com sucesso!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selecionarAlunos() {
        String sql = "SELECT * FROM ALUNO";

        try (Connection conn = conectarBanco();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String nome = resultSet.getString("NOME");
                String documento = resultSet.getString("DOCUMENTO");

                System.out.println("ID = " + id + " | NOME = " + nome + " | DOCUMENTO = " + documento);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void atualizarAluno(int id, String novoNome, String novoDoc) {
    	String sql = "UPDATE ALUNO SET NOME = ?, DOCUMENTO = ? WHERE ID = ?";
    	
    	try (Connection conn = conectarBanco();
    		PreparedStatement statement = conn.prepareStatement(sql)) {
    			
    		statement.setString(1, novoNome);
    		statement.setString(2, novoDoc);
    		statement.setInt(3, id);
    			
    		int linhasAfetadas = statement.executeUpdate();
    			
    		if (linhasAfetadas > 0) {
    			System.out.println("Aluno " + id + " atualizado com sucesso!");
    		} else {
    			System.out.println("Nenhum aluno encontrado com o ID " + id);
    		}
    			
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
   
    }

	public void deletarAluno(int id) {
		String sql = "DELETE FROM ALUNO WHERE ID = ?";
		
		try (Connection conn = conectarBanco();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			
			statement.setInt(1, id);
			int linhasAfetadas = statement.executeUpdate();
			
			if (linhasAfetadas > 0) {
				System.out.println("Aluno: " + id + " removido com sucesso!");
			} else {
				System.out.println("Nenhum aluno encontrado com o ID " + id);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
