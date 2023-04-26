package com.projeto.alunos;

import com.projeto.alunos.model.Aluno;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button btnCadastrar;

    @FXML
    private TableView<Aluno> tabela;

    @FXML
    private TableColumn<Aluno, SimpleFloatProperty> tableColumnMedia;

    @FXML
    private TableColumn<Aluno, SimpleStringProperty> tableColumnNome;

    @FXML
    private TableColumn<Aluno, SimpleFloatProperty> tableColumnPrimeiraNota;

    @FXML
    private TableColumn<Aluno, SimpleFloatProperty> tableColumnSegundaNota;

    @FXML
    private TableColumn<Aluno, SimpleStringProperty> tableColumnSituação;

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
        if (event.getSource() == btnCadastrar) {
            tfNome.setStyle(null);
            tfPrimeiraNota.setStyle(null);
            tfSegundaNota.setStyle(null);

            String nome;

            if (tfNome.getText().length() > 0 && tfNome.getText() != null) {
                nome = tfNome.getText();
                System.out.println("peguei o nome " + nome);

                Aluno a1 = new Aluno(nome, 10, 10);
                alunos.add(a1);
                observableListAlunos = FXCollections.observableArrayList(alunos);
                tabela.setItems(observableListAlunos);
                mostrarAlertaCadastro();
            } else {
                final String cssDefault = "-fx-border-color: red;-fx-border-width: 4;";
                tfNome.setStyle(cssDefault);
                tfNome.setPromptText("INSIRA UMA NOME");
                mostrarAlertaCadastroNomeInvalido();
            }

        }


    }

    public void carregarTableViewAlunos() {
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnPrimeiraNota.setCellValueFactory(new PropertyValueFactory<>("primeiraNota"));
        tableColumnSegundaNota.setCellValueFactory(new PropertyValueFactory<>("segundaNota"));
        tableColumnMedia.setCellValueFactory(new PropertyValueFactory<>("media"));
        tableColumnSituação.setCellValueFactory(new PropertyValueFactory<>("situacao"));

        Aluno a1 = new Aluno("Rafael", 10, 2);
        Aluno a2 = new Aluno("Reginaldo", 10, 2);

        alunos.add(a1);
        alunos.add(a2);

        observableListAlunos = FXCollections.observableArrayList(alunos);
        tabela.setItems(observableListAlunos);
    }

    public void selecionarItemTableView(Aluno aluno) {
        System.out.println("Cliente selecionado no tableview: " + aluno.getNome());
    }

    @FXML
    public void mostrarAlertaCadastro() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cadastro concluído");
        alert.setHeaderText("");
        alert.setContentText("Cadastro realizado com sucesso!");
        alert.show();
    }

    @FXML
    public void mostrarAlertaCadastroNomeInvalido() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Dados invalidos");
        alert.setHeaderText("");
        alert.setContentText("preencha o campo nome!");
        alert.show();
    }

    @FXML
    private void mostrarAlertaCadastroNotaInvalida() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Dados invalidos");
        alert.setHeaderText("");
        alert.setContentText("notas digitadas fora do padrão de 0 a 10!");
        alert.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarTableViewAlunos();

        //listner da tabela -> escuta as interações tanto com mouse quanto teclado na selecao dos items da tabela
        tabela.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableView(newValue)
        );
    }
}