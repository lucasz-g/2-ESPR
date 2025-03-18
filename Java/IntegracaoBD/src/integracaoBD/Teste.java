package integracaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Teste {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:XE"; // URL para Oracle
        String user = "admin_lucas"; // Insira o seu usuário
        String password = "root"; // Insira a sua senha
        
        String insert = "INSERT INTO ALUNO (ID, NOME, DOCUMENTO) VALUES (?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement()) {
        	
        	String createTable = "CREATE TABLE ALUNO ("
        	        + "ID NUMBER, "
        	        + "NOME VARCHAR(100) NOT NULL, "
        	        + "DOCUMENTO VARCHAR(100) NOT NULL, "
        	        + "PRIMARY KEY (ID)"
        	        + ")";      	
        	statement.executeUpdate(createTable);
        	System.out.println("Tabela criada com sucesso!");
        } catch (SQLException e ) {
        	e.printStackTrace();
        }
    }       
}
