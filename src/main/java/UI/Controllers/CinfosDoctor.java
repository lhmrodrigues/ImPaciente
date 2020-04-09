package UI.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CinfosDoctor {

    @FXML
    private Text closeButton;

    public Button btnAdicionarMedicamento;
    public TextField txtCPF;
    public TextField txtNomeMedicamento;

    public void AddMedicine() throws IOException {
        String medicamento = txtNomeMedicamento.getText();
        String cpf = txtCPF.getText();

    }

    public void clickedOnBackButton(MouseEvent mouseEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
