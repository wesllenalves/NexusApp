package com.example.nexusapp.model;

import java.io.Serializable;

public class Aluno implements Serializable {
    private int id;
    private String nome;
    private String dataNasc;
    private String email;
    private String cel;
    private String cpf;

    public Aluno() {
    }

    public Aluno(String nome, String dataNasc, String email, String cel, String cpf) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.email = email;
        this.cel = cel;
        this.cpf = cpf;
    }

    public Aluno(int id, String nome, String dataNasc, String email, String cel, String cpf) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.email = email;
        this.cel = cel;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString(){

        return nome;
    }
}
