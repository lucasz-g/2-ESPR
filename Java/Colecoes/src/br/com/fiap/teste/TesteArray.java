package br.com.fiap.teste;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.model.Endereco;
import br.com.fiap.model.Pessoa;

class TesteArray {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        List<Endereco> enderecos = new ArrayList<>();

        Endereco residencial = new Endereco("Rua teste", 278, "99900", "Residencial");
        Endereco comercial = new Endereco("Rua Trinta", 765, "6638219", "Comercial");

        enderecos.add(residencial);
        enderecos.add(comercial);

        Pessoa pessoa1 = new Pessoa("Lucas", 23, "CPF", enderecos);
        Pessoa pessoa2 = new Pessoa("Joao", 22, "RG", enderecos);

        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome());
        }

    }

}