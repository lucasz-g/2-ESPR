package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TesteAlgoitmos {
    public static void main(String[] args) {
        List<String> collection = new ArrayList<>(Arrays.asList("Banana", "Apple", "Orange"));
        
        // Ordenação
        Collections.sort(collection);

        // Busca
        int index = Collections.binarySearch(collection, "Apple");
        System.out.println(index);

        // Reversão
        Collections.reverse(collection);
    }
}
