module com.projeto.alunos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.projeto.alunos to javafx.fxml;
    opens com.projeto.alunos.model to javafx.fxml;

    exports com.projeto.alunos;
    exports com.projeto.alunos.model;
}