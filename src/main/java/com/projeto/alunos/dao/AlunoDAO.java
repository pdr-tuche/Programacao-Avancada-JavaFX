package com.projeto.alunos.dao;


import com.projeto.alunos.model.Aluno;

import java.sql.*;
import java.util.ArrayList;

public class AlunoDAO {
    Connection conexao;

    public AlunoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirDados(Aluno aluno) {
        String sql = "INSERT INTO alunos(nome, primeira_nota, segunda_nota) VALUES (?,?,?);";
        PreparedStatement ps;

        try {
            ps = this.conexao.prepareStatement(sql);
            ps.setString(1, aluno.getNome());
            ps.setFloat(2, aluno.getPrimeiraNota());
            ps.setFloat(3,aluno.getSegundaNota());
            ps.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<Aluno> listarAlunos() {
        ArrayList<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";

        try {
            Statement declaracao = conexao.createStatement();
            ResultSet response = declaracao.executeQuery(sql);

            while (response.next()) {
                int auxint = response.getInt("id");
                String auxString1 = response.getString("nome");
                float auxFloat1 = response.getFloat("primeira_nota");
                float auxFloat2 = response.getFloat("segunda_nota");
                float media = response.getFloat("media");
                String auxString2 = response.getString("situação");

                Aluno persona = new Aluno(auxint, auxString1, auxFloat1, auxFloat2, media, auxString2);
                alunos.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return alunos;
    }

}
