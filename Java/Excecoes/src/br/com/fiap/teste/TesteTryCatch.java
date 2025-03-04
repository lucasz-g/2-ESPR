package br.com.fiap.teste;

public class TesteTryCatch {
    public static void main(String[] args) {
        try {
            int resultado = 10 / 0;
            System.out.println(resultado); 
        } catch (ArithmeticException e) {
            System.out.println("Divisão por 0 não é permitida");
        } finally {
            System.out.println("Resultado");
        }
    
    }
}
