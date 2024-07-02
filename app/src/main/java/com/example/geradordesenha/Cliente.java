package com.example.geradordesenha;

// Importa as classes necessárias para trabalhar com datas
import java.time.LocalDate;
import java.time.Period;

// Declaração da classe Cliente
public class Cliente {
    // Variáveis de instância para armazenar informações do cliente
    private String nome; // Nome do cliente
    private LocalDate dataNascimento; // Data de nascimento do cliente
    private String senha; // Senha gerada para o cliente
    private boolean prioridade; // Indica se o cliente tem prioridade (baseado na idade)

    // Construtor que recebe nome e data de nascimento do cliente
    public Cliente(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    // Construtor padrão sem argumentos
    public Cliente() {

    }

    // Método para obter o nome do cliente
    public String getNome() {
        return nome;
    }

    // Método para definir o nome do cliente
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para obter a data de nascimento do cliente
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    // Método para definir a data de nascimento do cliente
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Método para obter a senha do cliente
    public String getSenha() {
        return senha;
    }

    // Método para definir a senha do cliente
    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Método para verificar se o cliente tem prioridade
    public boolean isPrioridade() {
        return prioridade;
    }

    // Método privado para calcular a idade do cliente, baseado na data de nascimento
    private int calcularIdade(LocalDate dataNascimento) {
        LocalDate hoje = LocalDate.now(); // Obtém a data atual
        Period periodo = Period.between(dataNascimento, hoje); // Calcula o período entre a data de nascimento e hoje
        return periodo.getYears(); // Retorna a idade em anos
    }

    // Método para gerar a senha do cliente, baseado na última senha e na idade do cliente
    public void gerarSenha(String ultimaSenha) {
        int senha;

        // Verifica se a última senha está vazia, se sim, inicia a contagem de senhas
        if (ultimaSenha.isEmpty()) {
            senha = 1;
        } else {
            // Se não, incrementa a última senha
            senha = Integer.parseInt(ultimaSenha.substring(1));
            senha++;
        }

        // Calcula a idade do cliente
        int idade = calcularIdade(dataNascimento);

        // Formata a senha para ter 4 dígitos
        String senhaFormatada = String.format("%04d", senha);

        // Verifica se a idade do cliente é menor que 60 para definir a prioridade
        if (idade < 60) {
            this.senha = "A" + senhaFormatada; // Senha para clientes sem prioridade
            this.prioridade = false;
        } else {// Senha para clientes com prioridade
            this.senha = "B" + senhaFormatada;
            this.prioridade = true;
        }
    }
}
