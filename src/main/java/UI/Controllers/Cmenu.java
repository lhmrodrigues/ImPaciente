package UI.Controllers;

import Application.MedicApp;
import Application.PatientApp;
import Domain.Model.Users.Medic;
import Domain.Model.Users.Patient;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

public class Cmenu extends CBase{

    public Button btnEntrar;
    public Button btnCadastrar;
    public TextField txtUsuario;
    public TextField txtSenha;

    public void BtnEntrarClick() throws IOException {

        try {
            if (txtUsuario.getText().isBlank() || txtSenha.getText().isBlank()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Usuário Inválido");
                alert.setHeaderText("Usuário e/ou Senha em Branco");
                alert.show();
                return;
            }

            if (txtUsuario.getText().length() == 11) {
                Patient patient = new Patient();
                patient.setCpfCrm(txtUsuario.getText());
                patient.setPassword(txtSenha.getText());

                PatientApp patientApp = new PatientApp();
                patientApp.patientLogin(patient);

                Stage primaryStage = new Stage();
                OpenPage("InfoReceita.fxml", primaryStage);
            }
            else{
                Medic medic = new Medic();
                medic.setCpfCrm(txtUsuario.getText());
                medic.setPassword(txtSenha.getText());

                MedicApp medicApp = new MedicApp();
                medicApp.medicLogin(medic);

                Stage primaryStage = new Stage();
                OpenPage("InfosDoctorView.fxml", primaryStage);
            }
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    public void BtnCadastrarClick() throws IOException {
        Stage primaryStage = new Stage();
        OpenPage("CadastroView.fxml",primaryStage);
    }
}
