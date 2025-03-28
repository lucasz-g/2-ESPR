package br.com.concessionaria.cadastro.dao;

import java.util.List;

import br.com.concessionaria.cadastro.entities.*;

public interface CarroDAO {
	void salvar(Carro carro);
	void atualizar(Carro carro);
	void apagar(int id);
	void buscarPorId(int id);
	List<Carro> listarTodos();
}