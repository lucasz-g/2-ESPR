package br.com.fiap.exercicios;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();

        try {
            Usuario usuario1 = new Usuario("Lucas", "lucas@email.com", 24);
            cadastrarUsuario(usuarios, usuario1);
        } catch (IllegalArgumentException e){
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
        
        try {
            Usuario usuario2 = new Usuario("Joao", "joao@email.com", 12);
            cadastrarUsuario(usuarios, usuario2);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public static void cadastrarUsuario(List<Usuario> lista, Usuario usuario){
        lista.add(usuario);
        System.out.println("Usuário " + usuario.getNome() + " Cadastrado com sucesso");
    }
}
