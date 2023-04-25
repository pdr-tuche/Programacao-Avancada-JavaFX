package com.projeto.alunos.model;

public class Aluno {
    private int id;
    private String nome;
    private float primeiraNota;
    private float segundaNota;
    private float media;
    private String situacao;

    public Aluno() {
    }

    public Aluno(String nome, float primeiraNota, float segundaNota) {
        this.nome = nome;
        this.primeiraNota = primeiraNota;
        this.segundaNota = segundaNota;
    }

    public Aluno(int auxint, String auxString1, float auxFloat1, float auxFloat2, float media, String auxString2) {
        this.id = auxint;
        this.nome = auxString1;
        this.primeiraNota = auxFloat1;
        this.segundaNota = auxFloat2;
        this.media = media;
        this.situacao = auxString2;
    }

    @Override
    public String toString() {
        return getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrimeiraNota() {
        return primeiraNota;
    }

    public void setPrimeiraNota(float primeiraNota) {
        this.primeiraNota = primeiraNota;
    }

    public float getSegundaNota() {
        return segundaNota;
    }

    public void setSegundaNota(float segundaNota) {
        this.segundaNota = segundaNota;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }
}
