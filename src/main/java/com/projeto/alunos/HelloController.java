package com.projeto.alunos;

import com.projeto.alunos.model.Aluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button btnCadastrar;

    @FXML
    private TableView<Aluno> tabela;

    @FXML
    private TableColumn<Aluno, Float> tableColumnMedia;

    @FXML
    private TableColumn<Aluno, String> tableColumnNome;

    @FXML
    private TableColumn<Aluno, Float> tableColumnPrimeiraNota;

    @FXML
    private TableColumn<Aluno, Float> tableColumnSegundaNota;

    @FXML
    private TableColumn<Aluno, String> tableColumnSituação;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfPrimeiraNota;

    @FXML
    private TextField tfSegundaNota;

    private List <Aluno> alunos = new ArrayList<>();

    private ObservableList<Aluno> observableListAlunos;

    @FXML
    void onCadastrarClick(ActionEvent event) {


    }

    public void carregarTableViewAlunos(){
        Aluno a1 = new Aluno("Rafael",10,2);
        Aluno a2 = new Aluno("Rafael",10,2);

        alunos.add(a1);
        alunos.add(a2);

        observableListAlunos = FXCollections.observableArrayList(alunos);
        tabela.setItems(observableListAlunos);

        tableColumnNome.setCellValueFactory(new PropertyValueFactory<Aluno,String>("nome"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarTableViewAlunos();
    }
}