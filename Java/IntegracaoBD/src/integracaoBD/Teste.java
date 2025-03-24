package integracaoBD;

import integracaoBD.modelos.ServicesCRUD;

public class Teste {

    public static void main(String[] args) {
        ServicesCRUD servicos = new ServicesCRUD();
        
        servicos.inserirAluno(1, "Lucas", "88332");
        servicos.inserirAluno(2, "Matheus", "22111");
        servicos.selecionarAlunos();
        servicos.deletarAluno(2);
        servicos.atualizarAluno(1, "Lucas Garcia", "490196");
    }
}
