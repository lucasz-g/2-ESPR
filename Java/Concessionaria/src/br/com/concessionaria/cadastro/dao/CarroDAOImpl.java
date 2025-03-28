package br.com.concessionaria.cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.concessionaria.cadastro.entities.Carro;

public class CarroDAOImpl implements CarroDAO {
	
	Connection conn = null; 
	
	public CarroDAOImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void salvar(Carro carro) {
		String insert = "INSERT INTO RM554070.CARRO\r\n"
				+ "(ID, ANO, PRECO, MARCA, MODELO)\r\n"
				+ "VALUES(?, ?, ?, ?, ?);";
		
		try (PreparedStatement preparedStatement = conn.prepareStatement(insert)){
			preparedStatement.setInt(1, carro.getId());
			preparedStatement.setInt(2, carro.getAno());
			preparedStatement.setDouble(3, carro.getPreco());
			preparedStatement.setString(4, carro.getMarca());
			preparedStatement.setString(5, carro.getModelo());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Inclusão realizada!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void atualizar(Carro carro) {
		String update = "UPDATE RM554070.CARRO\r\n"
				+ "SET ANO=?, PRECO=?, MARCA=?, MODELO=?\r\n"
				+ "WHERE ID=?;";
		
		try (PreparedStatement preparedStatement = conn.prepareStatement(update)){
			preparedStatement.setInt(1, carro.getAno());
			preparedStatement.setDouble(2, carro.getPreco());
			preparedStatement.setString(3, carro.getMarca());
			preparedStatement.setString(4, carro.getModelo());
			preparedStatement.setInt(5, carro.getId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Atualização realizada!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void apagar(int id) {
		String delete = "DELETE FROM RM554070.CARRO\r\n"
				+ "WHERE ID=?;";
		
		try (PreparedStatement preparedStatement = conn.prepareStatement(delete)){
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
			
			System.out.println("Remoção realizada!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void buscarPorId(int id) {

	}

	@Override
	public List<Carro> listarTodos() {
		String select = "SELECT ID, ANO, PRECO, MARCA, MODELO\r\n"
				+ "FROM RM554070.CARRO;";
		
		List<Carro> carros = new ArrayList<Carro>();
		
		try (PreparedStatement preparedStatement = conn.prepareStatement(select)){
			ResultSet resultSet = preparedStatement.getResultSet();
			
			while(resultSet.next()) {
				Carro carro = new Carro();
				
				carro.setId(carro.getId());
				carro.setAno(carro.getAno());
				carro.setPreco(carro.getPreco());
				carro.setMarca(carro.getMarca());
				carro.setModelo(carro.getModelo());
				
				carros.add(carro);
			}
			
			System.out.println("Consulta realizada!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return carros;
	}

}
