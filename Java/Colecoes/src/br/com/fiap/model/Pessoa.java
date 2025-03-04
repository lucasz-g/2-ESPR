package br.com.fiap.model;

import java.util.List;

public class Pessoa {
    private String nome;
    private int idade;
    private String documento;
    private List<Endereco> endereco;

    public Pessoa(String nome, int idade, String documento) {
        this.nome = nome;
        this.idade = idade;
        this.documento = documento;
    }

    public Pessoa(String nome, int idade, String documento, List<Endereco> endereco) {
        this.nome = nome;
        this.idade = idade;
        this.documento = documento;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    public void exibirPesoa(){
        System.out.println("Nome: " + this.nome + " - Idade: " + this.idade + " - Documento: " + this.documento);
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + ", documento=" + documento + ", endereco=" + endereco
                + "]";
    }

}
