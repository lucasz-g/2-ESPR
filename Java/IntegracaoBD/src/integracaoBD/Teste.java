package integracaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teste {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
		String user = "rm554070";
		String password = "fiap25";
		
		String insert = "INSERT INTO ALUNO (ID, NOME, DOCUMENTO) VALUES (?, ?, ?)";
		
		String select = "SELECT * FROM ALUNO";
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			preparedStatement = conn.prepareStatement(insert);
			preparedStatement.setInt(1, 2);
			preparedStatement.setString(2, "Teste");
			preparedStatement.setString(3, "887979");
			preparedStatement.executeUpdate();
			System.out.println("Inclusão efetuada com sucesso");
			
			preparedStatement.close();
			
			preparedStatement = conn.prepareStatement(select);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String nome = resultSet.getString("NOME");
				String documento = resultSet.getString("DOCUMENTO");
				
				System.out.println("ID = " + id + " NOME = " + nome + " DOCUMENTO = " + documento);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			preparedStatement.close();
			conn.close();
		}

	}

}
