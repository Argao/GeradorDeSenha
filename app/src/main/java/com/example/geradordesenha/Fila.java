package com.example.geradordesenha;

// Importações necessárias para a classe
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Declaração da classe Fila
public  class Fila {
    // Declaração de duas filas LinkedList para clientes prioritários e regulares
    private static LinkedList<Cliente> filaPrioridade = new LinkedList<>();
    private static LinkedList<Cliente> filaRegular = new LinkedList<>();
    // Variável para armazenar a última senha gerada
    private static String ultimaSenha = "";

    // Método para adicionar um cliente na fila apropriada com base na prioridade
    public static void adicionarNaFila(Cliente cliente){
        // Gera uma senha para o cliente e atualiza a última senha gerada
        cliente.gerarSenha(ultimaSenha);
        ultimaSenha = cliente.getSenha();
        // Verifica se a senha do cliente começa com "B" (prioritário) e o adiciona na fila correspondente
        if (cliente.getSenha().startsWith("B")) {
            filaPrioridade.add(cliente);
        } else {
            filaRegular.add(cliente);
        }
    }

    // Método para obter o último cliente da fila, dando prioridade aos clientes prioritários
    public static Cliente getUltimoCliente(){
        // Verifica se a fila de prioridade não está vazia e retorna o primeiro cliente, removendo-o da fila
        if (!filaPrioridade.isEmpty()) {
            return filaPrioridade.poll();
        } else {
            // Se a fila de prioridade estiver vazia, retorna o primeiro cliente da fila regular, removendo-o da fila
            return filaRegular.poll();
        }
    }

    // Método para visualizar o próximo cliente na fila sem removê-lo
    public static Cliente verProximoCliente(){
        // Verifica se a fila de prioridade não está vazia e retorna o primeiro cliente sem removê-lo
        if (!filaPrioridade.isEmpty()) {
            return filaPrioridade.peek();
        } else {
            // Se a fila de prioridade estiver vazia, retorna o primeiro cliente da fila regular sem removê-lo
            return filaRegular.peek();
        }
    }

    // Método para obter uma lista com os próximos clientes na fila, até uma quantidade especificada
    public static List<String> verProximosClientes(int quantidade){
        // Lista para armazenar os próximos clientes
        List<String> proximosClientes = new ArrayList<>();
        // Cria cópias temporárias das filas para manipulação
        LinkedList<Cliente> filaPrioridadeTemp = new LinkedList<>(filaPrioridade);
        LinkedList<Cliente> filaRegularTemp = new LinkedList<>(filaRegular);

        // Loop para adicionar os próximos clientes na lista, até atingir a quantidade especificada
        while (proximosClientes.size() < quantidade) {
            // Verifica se a fila de prioridade temporária não está vazia e adiciona o próximo cliente na lista
            if (!filaPrioridadeTemp.isEmpty()) {
                proximosClientes.add(filaPrioridadeTemp.poll().getSenha());
            } else if (!filaRegularTemp.isEmpty()) {
                // Se a fila de prioridade estiver vazia, verifica a fila regular temporária e adiciona o próximo cliente
                proximosClientes.add(filaRegularTemp.poll().getSenha());
            } else {
                // Se ambas as filas estiverem vazias antes de atingir a quantidade, adiciona "-" para os espaços restantes
                proximosClientes.add("-");
            }
        }

        // Retorna a lista com os próximos clientes
        return proximosClientes;
    }
}