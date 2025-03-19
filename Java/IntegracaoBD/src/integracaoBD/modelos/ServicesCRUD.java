package integracaoBD.modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicesCRUD {
	
	private Connection conn; 
	private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private String user = "rm554070";
	private String password = "fiap25";	
	
	public void conectarBanco() throws SQLException {
		this.conn = DriverManager.getConnection(this.url, this.user, this.password);
	}
	
	public PreparedStatement statement(String statementType) throws SQLException {
		PreparedStatement preparedStatement = this.conn.prepareStatement(statementType);
		return preparedStatement;
	}
	
	public void inserirAluno(String sql, int id, String nome, String documento) throws SQLException {
		PreparedStatement statementInsert = statement(sql);
		
		statementInsert.setInt(1, id);
		statementInsert.setString(2, nome);
		statementInsert.setString(3, documento);
		
		statementInsert.executeUpdate();

		statementInsert.close();
	}
	
	public ResultSet selecionarAluno(String sql) throws SQLException {
		PreparedStatement statementSelect = statement(sql);
		ResultSet resultSet = statementSelect.executeQuery();
		return resultSet; 
	}
	
}
