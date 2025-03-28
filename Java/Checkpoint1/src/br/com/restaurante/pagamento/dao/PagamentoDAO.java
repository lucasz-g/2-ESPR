package br.com.restaurante.pagamento.dao;
import java.util.List;
import br.com.restaurante.pagamento.model.Pagamento;

public interface PagamentoDAO {
	void salvar(Pagamento pagamento);
	void atualizar(Pagamento pagamento);
	void apagar(int id);
	Pagamento buscarPorId(int id);
	List<Pagamento> listarTodos();
}
