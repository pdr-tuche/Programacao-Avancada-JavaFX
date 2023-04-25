package com.projeto.alunos.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Conexao {

    private Connection conexao;
    public Connection abrirConexao() {
        String base = "aluno";
        String url = "jdbc:mysql://localhost:3306/" + base + "?userTimezone=true&severTimezone=UTC";
        String user = "root";
        String pass = "";

        try {
            conexao = DriverManager.getConnection(url, user, pass);


        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }


        return conexao;
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
