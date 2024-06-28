package com.example.geradordesenha;

import java.util.LinkedList;
import java.util.Queue;

public  class Fila {
    public static Queue<Cliente> fila = new LinkedList<>();
    private static String ultimaSenha = "";

    public static void adicionarNaFila(Cliente cliente){
        gerarSenha(cliente);
        ultimaSenha = cliente.getSenha();
        fila.add(cliente);
    }

    public static Cliente getUltimoCliente(){
        return ((LinkedList<Cliente>) fila).getLast();
    }

    private static void gerarSenha(Cliente cliente){
        cliente.gerarSenha(ultimaSenha);
    }
}
