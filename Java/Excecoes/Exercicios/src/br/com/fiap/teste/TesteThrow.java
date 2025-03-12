package br.com.fiap.teste;

public class TesteThrow {
    public static void main(String[] args) {
        checkAge(20);
    }
   
    public static void checkAge(int age){
        if(age < 18){
            throw new IllegalArgumentException("Age is not valid");
        }
        System.out.println("Age is valid: " + age);
    }
}
