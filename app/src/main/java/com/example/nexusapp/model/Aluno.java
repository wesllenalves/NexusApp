package com.example.nexusapp.model;

import java.io.Serializable;

public class Aluno implements Serializable {
    private int id;
    private String nome;
    private String dataNasc;
    private String email;
    private String cel;
    private String tel;
    private String peso;
    private String alt;

    public Aluno() {
    }

    public Aluno(int id, String nome, String dataNasc, String email, String cel, String tel, String peso, String alt) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.email = email;
        this.cel = cel;
        this.tel = tel;
        this.peso = peso;
        this.alt = alt;
    }

    public Aluno(String nome, String dataNasc, String email, String cel, String tel, String peso, String alt) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.email = email;
        this.cel = cel;
        this.tel = tel;
        this.peso = peso;
        this.alt = alt;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
