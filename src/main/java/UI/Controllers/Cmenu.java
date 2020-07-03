package UI.Controllers;

import Application.MedicApp;
import Application.PatientApp;
import Domain.Model.Users.Medic;
import Domain.Model.Users.Patient;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Cmenu extends CBase {

    public Button btnEntrar;
    public Button btnCadastrar;
    public TextField txtUsuario;
    public TextField txtSenha;

    public void BtnEntrarClick() throws IOException {

        try {
            if (txtUsuario.getText().trim().isEmpty() || txtSenha.getText().trim().isEmpty()) {
                OpenAlert("Usuário Inválido", "Usuário e/ou Senha e/ou Nome em Branco", "", Alert.AlertType.WARNING);
                return;
            }

            if (txtUsuario.getText().length() == 11) {
                Patient patient = new Patient();
                patient.setCpfCrm(txtUsuario.getText());
                patient.setPassword(txtSenha.getText());

                PatientApp patientApp = new PatientApp();
                patientApp.patientLogin(patient);

                OpenSimplePage("InfoReceita.fxml");
            } else {
                Medic medic = new Medic();
                medic.setCpfCrm(txtUsuario.getText());
                medic.setPassword(txtSenha.getText());

                MedicApp medicApp = new MedicApp();
                medicApp.medicLogin(medic);

                OpenSimplePage("InfosDoctorView.fxml");
            }
        } catch (Exception e) {
            OpenAlert("Erro", "Usuário inexistente", "", Alert.AlertType.ERROR);
        }
    }

    public void BtnCadastrarClick() throws IOException {

        OpenSimplePage("CadastroView.fxml");
    }
}
