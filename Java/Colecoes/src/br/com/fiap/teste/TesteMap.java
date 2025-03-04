package br.com.fiap.teste;

import java.util.HashMap;
import java.util.Map;

import br.com.fiap.model.Pessoa;

public class TesteMap {
    public static void main(String[] args) {
        Map<String, Pessoa> pessoas = new HashMap<>();
        
        Pessoa pessoa1 = new Pessoa("Lucas", 23, "278273"); 
        Pessoa pessoa2 = new Pessoa("Joao", 22, "8836291");

        pessoas.put(pessoa1.getDocumento(), pessoa1);
        pessoas.put(pessoa2.getDocumento(), pessoa2);

        for(Pessoa pessoa : pessoas.values()){
            System.out.println(pessoa.toString());
        }
        
    }
}
