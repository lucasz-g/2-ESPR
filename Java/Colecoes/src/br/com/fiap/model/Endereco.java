package br.com.fiap.model;

public class Endereco {
    private String rua;
    private int numero;
    private String cep;
    private String tipo;

    public Endereco(String rua, int numero, String cep, String tipo) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.tipo = tipo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
