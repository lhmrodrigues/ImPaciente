package UI.Controllers;

import Application.MedicApp;
import Application.PatientApp;
import Application.UserSession;
import Domain.Model.Users.Medic;
import Domain.Model.Users.Patient;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Ccadastro extends CBase{

    public TextField txtNome;
    public TextField txtCpfCrm;
    public TextField txtSenha;
    public Button btnCadastrar;

    public void BtnCadastroClick(ActionEvent actionEvent) throws Exception {
        String nome = txtNome.getText();
        String doc = txtCpfCrm.getText();
        String senha = txtSenha.getText();

        if (doc.isBlank() || senha.isBlank() || nome.isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Usuário Inválido");
            alert.setHeaderText("Usuário e/ou Senha e/ou Nome em Branco");
            alert.show();
            return;
        }

        if(doc.length() == 11)
        {
            PatientApp save = new PatientApp();
            Patient novoUsuario = new Patient();
            novoUsuario.setCpfCrm(doc);
            novoUsuario.setName(nome);
            novoUsuario.setPassword(senha);
            save.Add(novoUsuario);

            Stage primaryStage = new Stage();
            UserSession.getInstance().setUserLogado(novoUsuario);
            OpenPage("InfoReceitaView.fxml", primaryStage);
        }
        else
        {
            MedicApp save = new MedicApp();
            Medic novoUsuario = new Medic();
            novoUsuario.setCpfCrm(doc);
            novoUsuario.setName(nome);
            novoUsuario.setPassword(senha);
            save.Add(novoUsuario);

            Stage primaryStage = new Stage();
            UserSession.getInstance().setUserLogado(novoUsuario);
            OpenPage("InfosDoctorView.fxml", primaryStage);
        }
    }
}
