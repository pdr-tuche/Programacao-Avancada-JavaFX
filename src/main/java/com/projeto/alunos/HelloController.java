package com.projeto.alunos;

import com.projeto.alunos.exeptions.NaoContidoEntreZeroEDezExeption;
import com.projeto.alunos.exeptions.NomeNullExeption;
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
            limparCssTf();

            String nome;
            float primeiraNota = -1;
            float segundaNota = -1;
            boolean contido1;
            boolean contido2;
            final String cssDefault = "-fx-border-color: red;-fx-border-width: 2;";

            try {
                primeiraNota = Float.parseFloat(tfPrimeiraNota.getText());
                segundaNota = Float.parseFloat(tfSegundaNota.getText());
                nome = tfNome.getText();

                if (nome.isBlank()) {
                    throw new NomeNullExeption(nome);
                } else if (tfPrimeiraNota.getText().isBlank()) {
                    throw new NumberFormatException();
                } else if (tfSegundaNota.getText().isBlank()) {
                    throw new NumberFormatException();
                }

                contido1 = primeiraNota >= 0 && primeiraNota <= 10;
                if (!contido1) {
                    throw new NaoContidoEntreZeroEDezExeption(primeiraNota, 1);
                }

                contido2 = segundaNota >= 0 && segundaNota <= 10;
                if (!contido2) {
                    throw new NaoContidoEntreZeroEDezExeption(segundaNota, 2);
                }

                Aluno aluno = new Aluno(nome, primeiraNota, segundaNota);
                alunos.add(aluno);
                mostrarAlertaCadastro();
                carregarTableViewAlunos();

            } catch (NaoContidoEntreZeroEDezExeption exeption) {
                if (exeption.getNota() == 1) {
                    mostrarAlertaCadastroNotaInvalida();
                    tfPrimeiraNota.setStyle(cssDefault);
                    tfPrimeiraNota.setPromptText("INSIRA UMA NOTA ENTRE 0 E 10");
                } else {
                    mostrarAlertaCadastroNotaInvalida();
                    tfSegundaNota.setStyle(cssDefault);
                    tfSegundaNota.setPromptText("INSIRA UMA NOTA ENTRE 0 E 10");
                }

            } catch (NomeNullExeption exeption) { // para nome invalido
                tfNome.setStyle(cssDefault);
                tfNome.setPromptText("INSIRA UMA NOME");
                mostrarAlertaCadastroNomeInvalido();

            } catch (NumberFormatException exception) { // nao consigo deixar igual a exessao do naocontido
                mostrarAlertaCadastroNotaInvalida();
                tfPrimeiraNota.setText("");
                tfSegundaNota.setText("");
                tfPrimeiraNota.setPromptText("INSIRA UMA NOTA ENTRE 0 E 10");
                tfSegundaNota.setPromptText("INSIRA UMA NOTA ENTRE 0 E 10");
                tfPrimeiraNota.setStyle(cssDefault);
                tfSegundaNota.setStyle(cssDefault);
            }
        }
    }

    private void limparDadosTf() {
        tfNome.setText("");
        tfPrimeiraNota.setText("");
        tfSegundaNota.setText("");
    }

    private void limparCssTf() {
        tfNome.setStyle(null);
        tfPrimeiraNota.setStyle(null);
        tfSegundaNota.setStyle(null);
    }

    public void carregarTableViewAlunos() {
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnPrimeiraNota.setCellValueFactory(new PropertyValueFactory<>("primeiraNota"));
        tableColumnSegundaNota.setCellValueFactory(new PropertyValueFactory<>("segundaNota"));
        tableColumnMedia.setCellValueFactory(new PropertyValueFactory<>("media"));
        tableColumnSituação.setCellValueFactory(new PropertyValueFactory<>("situacao"));

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
        alert.setHeaderText("NOTAS INVALIDAS");
        alert.setContentText("Insira notas entre 0 e 10");
        alert.show();
    }

    @FXML
    private void mostrarAlertaCadastroNotaNull(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Dados invalidos");
        alert.setHeaderText("NOTAS NAO PREENCHIDAS");
        alert.setContentText("Insira notas entre 0 e 10");
        alert.show();
    }

    @FXML
    private void mostrarAlertaCadastroNotaNaoContidaEntreZeroEDez() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Dados invalidos");
        alert.setHeaderText("");
        alert.setContentText("Notas nao contidas entre 0 e 10!");
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