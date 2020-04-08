package UI.Controllers;

import Application.MedicApp;
import Application.PatientApp;
import Domain.Model.Users.Medic;
import Domain.Model.Users.Patient;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Ccadastro {

    public TextField txtNome;
    public CheckBox checkBox;
    public TextField txtCpfCrm;
    public Button btnCadastrar;

    public void BtnCadastroClick(ActionEvent actionEvent) throws Exception {
        boolean ifDoctor = checkBox.isSelected();
        String nome = txtNome.getText();
        String doc = txtCpfCrm.getText();
        if(ifDoctor)
        {
            MedicApp save = new MedicApp();
            Medic novoUsuario = new Medic();
            novoUsuario.setCpfCrm(doc);
            novoUsuario.setName(nome);
            save.Add(novoUsuario);
        }
        else
        {
            PatientApp save = new PatientApp();
            Patient novoUsuario = new Patient();
            novoUsuario.setCpfCrm(doc);
            novoUsuario.setName(nome);
            save.Add(novoUsuario);
        }

    }
}
