package com.example.geradordesenha;

import java.time.LocalDate;
import java.time.Period;

public class Cliente {
    private String nome;
    private LocalDate dataNascimento;
    private String senha;
    private boolean prioridade;

    public Cliente(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;

    }

    public Cliente() {

    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isPrioridade() {
        return prioridade;
    }

    private int calcularIdade(LocalDate dataNascimento) {
            LocalDate hoje = LocalDate.now();
            Period periodo = Period.between(dataNascimento, hoje);
            return periodo.getYears();
    }

    public void gerarSenha(String ultimaSenha) {

        int senha;

        if (ultimaSenha.isEmpty()) {
            senha = 0;
        } else {
            senha = Integer.parseInt(ultimaSenha.substring(1));
            senha++;
        }

        int idade = calcularIdade(dataNascimento);

        String senhaFormatada = String.format("%04d", senha);

        if (idade < 60) {
            this.senha = "A" + senhaFormatada;
            this.prioridade = false;
        } else {
            this.senha = "B" + senhaFormatada;
            this.prioridade = true;
        }
    }
}
