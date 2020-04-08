package UI.Controllers;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CmenuPaciente extends Cmenu{

    public Button btnEntrar;
    public TextField txtPaciente;

    public void BtnEntrarClick() throws IOException {
        Stage primaryStage = new Stage();
        String paciente = txtPaciente.getText();
        RunMenu("InfosPacienteView.fxml",primaryStage);
    }
}
