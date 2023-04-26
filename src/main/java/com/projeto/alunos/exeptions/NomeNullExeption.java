package com.projeto.alunos.exeptions;

public class NomeNullExeption extends Throwable {

    protected String nome;

    public NomeNullExeption(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "o nome '"+this.nome+"' está em branco ou nulo.";
    }
}
