module com.projeto.alunos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.projeto.alunos to javafx.fxml;
    exports com.projeto.alunos;
}