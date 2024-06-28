package com.example.geradordesenha;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public  class Fila {
    private static LinkedList<Cliente> filaPrioridade = new LinkedList<>();
    private static LinkedList<Cliente> filaRegular = new LinkedList<>();
    private static String ultimaSenha = "";

    public static void adicionarNaFila(Cliente cliente){
        gerarSenha(cliente);
        ultimaSenha = cliente.getSenha();
        if (cliente.getSenha().startsWith("B")) {
            filaPrioridade.add(cliente);
        } else {
            filaRegular.add(cliente);
        }
    }

    public static Cliente getUltimoCliente(){
        if (!filaPrioridade.isEmpty()) {
            return filaPrioridade.poll();
        } else {
            return filaRegular.poll();
        }
    }


    public static List<Cliente> verProximosClientes(int quantidade){
        List<Cliente> proximosClientes = new ArrayList<>();
        LinkedList<Cliente> filaPrioridadeTemp = new LinkedList<>(filaPrioridade);
        LinkedList<Cliente> filaRegularTemp = new LinkedList<>(filaRegular);

        while (proximosClientes.size() < quantidade) {
            if (!filaPrioridadeTemp.isEmpty()) {
                proximosClientes.add(filaPrioridadeTemp.poll());
            } else if (!filaRegularTemp.isEmpty()) {
                proximosClientes.add(filaRegularTemp.poll());
            } else {
                break;
            }
        }

        return proximosClientes;
    }

    private static void gerarSenha(Cliente cliente){
        cliente.gerarSenha(ultimaSenha);
    }
}
