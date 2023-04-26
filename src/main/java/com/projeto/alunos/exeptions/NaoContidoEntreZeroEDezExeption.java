package com.projeto.alunos.exeptions;

public class NaoContidoEntreZeroEDezExeption extends Exception{
    protected float num;
    protected int nota;

    public NaoContidoEntreZeroEDezExeption(float num, int nota) {
        this.num = num;
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "o numero "+this.num+" não está contido entre 0 e 10.";
    }
}
