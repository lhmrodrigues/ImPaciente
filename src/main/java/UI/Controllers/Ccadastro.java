package UI.Controllers;

import Application.Interfaces.IMedicApp;
import Application.MedicApp;
import Application.PatientApp;
import Application.UserSession;
import Domain.Model.Users.Medic;
import Domain.Model.Users.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ccadastro extends CBase {

    public TextField txtNome;
    public TextField txtCpfCrm;
    public TextField txtSenha;
    public Button btnCadastrar;

    @FXML
    private Text closeButton;


    private MedicApp _medicApp;
    private PatientApp _patientApp;
    public Ccadastro(){
        _medicApp = new MedicApp();
        _patientApp = new PatientApp();
    }

    public void BtnCadastroClick(ActionEvent actionEvent) throws Exception {
        try {
            String nome = txtNome.getText();
            String doc = txtCpfCrm.getText();
            String senha = txtSenha.getText();

            if (doc.isBlank() || senha.isBlank() || nome.isBlank()) {
                OpenAlert("Usuário Inválido", "Usuário e/ou Senha e/ou Nome em Branco", "", Alert.AlertType.WARNING);
                return;
            }

            if (doc.length() == 11) {
                Patient novoUsuario = new Patient();
                novoUsuario.setCpfCrm(doc);
                novoUsuario.setName(nome);
                novoUsuario.setPassword(senha);
                _patientApp.add(novoUsuario);

                UserSession.getInstance().setUserLogado(novoUsuario);
                OpenSimplePage("InfoReceita.fxml");
            } else {
                Medic novoUsuario = new Medic();
                novoUsuario.setCpfCrm(doc);
                novoUsuario.setName(nome);
                novoUsuario.setPassword(senha);
                _medicApp.add(novoUsuario);

                UserSession.getInstance().setUserLogado(novoUsuario);
                OpenSimplePage("InfosDoctorView.fxml");
            }
        } catch (Exception e) {
            OpenAlert("Erro", e.getMessage(), "", Alert.AlertType.ERROR);
        }
    }

    public void clickedOnBackButton(MouseEvent mouseEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
