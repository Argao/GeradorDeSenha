package com.example.geradordesenha;

import java.time.LocalDate;
import java.time.Period;

public class Cliente {
    private String nome;
    private LocalDate dataNascimento;
    private String senha;

    public Cliente(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.senha = null;
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


    private int calcularIdade(LocalDate dataNascimento) {
            LocalDate hoje = LocalDate.now();
            Period periodo = Period.between(dataNascimento, hoje);
            return periodo.getYears();
    }

    public void gerarSenha(String ultimaSenha) {

        int senha;

        if (ultimaSenha.isEmpty()) {
            senha = 0;
        }else {
            senha =  Integer.parseInt(ultimaSenha.substring(1)) ;
            senha++;
        }

        int idade = calcularIdade(dataNascimento);

        if(idade < 60) {
            this.senha = "A" + senha;
        }else {
            this.senha = "B" + senha;
        }
    }
}
