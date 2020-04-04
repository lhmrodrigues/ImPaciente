package Domain.Controller.Menu;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CinfosDoctor {

    public Button btnAdicionarMedicamento;
    public TextField txtCPF;
    public TextField txtNomeMedicamento;

    public void AddMedicine() throws IOException {
        String medicamento = txtNomeMedicamento.getText();
        String cpf = txtCPF.getText();

    }

}
