package br.com.fiap.teste;

import java.io.FileReader;
import java.io.IOException;

public class TesteThrowS {
    public static void main(String[] args) {
        try {
            lerArquivo("Arquivo.txt");
        } catch (IOException e){
            System.out.println("Erro ao abrir o arquivo " + e.getMessage());
        }
    }

    public static void lerArquivo(String arquivo) throws IOException{
        FileReader file = new FileReader(arquivo);
        System.out.println("Arquivo aberto com sucesso!" + file.read());
        file.close();
    }
}
