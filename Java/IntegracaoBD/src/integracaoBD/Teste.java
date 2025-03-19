package integracaoBD;

import java.sql.ResultSet;
import java.sql.SQLException;

import integracaoBD.modelos.ServicesCRUD;

public class Teste {

	public static void main(String[] args) throws SQLException {
		String insert = "INSERT INTO ALUNO (ID, NOME, DOCUMENTO) VALUES (?, ?, ?)";
		String select = "SELECT * FROM ALUNO";
		
		ServicesCRUD servicos = new ServicesCRUD();
		
		try {
			servicos.conectarBanco(); 
			System.out.println("Inclusão efetuada com sucesso");
			
			servicos.inserirAluno(insert, 12, "Lucas", "88332");
			
			ResultSet resultSet = servicos.selecionarAluno(select); 
			
			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String nome = resultSet.getString("NOME");
				String documento = resultSet.getString("DOCUMENTO");
				
				System.out.println("ID = " + id + " NOME = " + nome + " DOCUMENTO = " + documento);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}

}
