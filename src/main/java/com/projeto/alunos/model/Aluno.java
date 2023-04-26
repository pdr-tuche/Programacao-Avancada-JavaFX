package com.projeto.alunos.model;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Aluno {
    private SimpleIntegerProperty id;
    private SimpleStringProperty nome;
    private SimpleFloatProperty primeiraNota;
    private SimpleFloatProperty segundaNota;
    private SimpleFloatProperty media;
    private SimpleStringProperty situacao;

    public Aluno() {
    }

    public Aluno(String nome, float primeiraNota, float segundaNota) {
        this.nome = new SimpleStringProperty(nome);
        this.primeiraNota = new SimpleFloatProperty(primeiraNota);
        this.segundaNota = new SimpleFloatProperty(segundaNota);
        fazerMedia(this.primeiraNota, this.segundaNota);
    }

    public Aluno(int auxint, String auxString1, float auxFloat1, float auxFloat2, float media, String auxString2) {
        this.id = new SimpleIntegerProperty(auxint);
        this.nome = new SimpleStringProperty(auxString1);
        this.primeiraNota = new SimpleFloatProperty(auxFloat1);
        this.segundaNota = new SimpleFloatProperty(auxFloat2);
        this.media = new SimpleFloatProperty(media);
        this.situacao = new SimpleStringProperty(auxString2);
    }

    public void fazerMedia(SimpleFloatProperty n1, SimpleFloatProperty n2){
        float num1 = n1.floatValue();
        float num2 = n2.floatValue();
        float res = (num1+num2)/2;

        this.media = new SimpleFloatProperty(res);
        situacao();
    }

    public void situacao(){
        float media = this.media.floatValue();
        String situacao = null;
        if (media < 4){
            situacao = "reprovado";
        } else if (media >= 4 && media < 7) {
            situacao = "recuperação";
        } else if (media >= 7 && media <= 10) {
            situacao = "aprovado";
        }
        this.situacao = new SimpleStringProperty(situacao);
    }

    @Override
    public String toString() {
        return this.nome.get();
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public float getPrimeiraNota() {
        return primeiraNota.get();
    }

    public SimpleFloatProperty primeiraNotaProperty() {
        return primeiraNota;
    }

    public void setPrimeiraNota(float primeiraNota) {
        this.primeiraNota.set(primeiraNota);
    }

    public float getSegundaNota() {
        return segundaNota.get();
    }

    public SimpleFloatProperty segundaNotaProperty() {
        return segundaNota;
    }

    public void setSegundaNota(float segundaNota) {
        this.segundaNota.set(segundaNota);
    }

    public float getMedia() {
        return media.get();
    }

    public SimpleFloatProperty mediaProperty() {
        return media;
    }

    public void setMedia(float media) {
        this.media.set(media);
    }

    public String getSituacao() {
        return situacao.get();
    }

    public SimpleStringProperty situacaoProperty() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao.set(situacao);
    }
}
