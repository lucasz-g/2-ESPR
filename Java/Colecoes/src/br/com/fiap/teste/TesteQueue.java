package br.com.fiap.teste;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TesteQueue {

    public static void main(String[] args) {
        Queue<Integer> inteiros = new LinkedList<>(); 
        inteiros.add(2);
        inteiros.add(3);
        inteiros.add(1);

        Queue<Integer> inteiros2 = new PriorityQueue<>(); 
        inteiros2.add(2);
        inteiros2.add(3);
        inteiros2.add(1);

        System.out.println("O elemento head é:" + inteiros.peek());
        System.out.println("O elemento head é:" + inteiros2.peek());

        System.out.println("Lista 1");
        for(Integer i : inteiros){
            System.out.println(i);
        }

        System.out.println("Lista 2");
        for(Integer i : inteiros){
            System.out.println(i);
        }

    }

}