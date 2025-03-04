package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.model.Pessoa;

public class TesteMap {
    public static void main(String[] args) {
        Map<String, Pessoa> pessoasMap = new HashMap<>();
        
        Pessoa pessoa1 = new Pessoa("Lucas", 23, "278273"); 
        Pessoa pessoa2 = new Pessoa("Joao", 22, "8836291");

        pessoasMap.put(pessoa1.getDocumento(), pessoa1);
        pessoasMap.put(pessoa2.getDocumento(), pessoa2);

        List<Pessoa> pessoasList = new ArrayList<>(pessoasMap.values());
        
        List<Pessoa> crescente = reordenarLista(pessoasList, "Crescente");
        System.out.println("\nOrdem crescente:");
        for (Pessoa pessoa : crescente) {
            pessoa.exibirPesoa();
        }

        List<Pessoa> decrescente = reordenarLista(pessoasList, "Decrescente");
        System.out.println("\nOrdem decrescente:");
        for (Pessoa pessoa : decrescente) {
            pessoa.exibirPesoa();
        }
    }

    public static List<Pessoa> reordenarLista(List<Pessoa> lista, String direcao){
        List<Pessoa> novaLista = new ArrayList<>(lista);
        
        if(direcao.equalsIgnoreCase("Crescente")){
            novaLista.sort(Comparator.comparingInt(Pessoa::getIdade));
        } else if(direcao.equalsIgnoreCase("Decrescente")){
            novaLista.sort(Comparator.comparingInt(Pessoa::getIdade).reversed());
        } else{
            System.out.println("Selecione uma opção válida, Crescente ou Decrescente");
        }
        return novaLista;
    }
}
