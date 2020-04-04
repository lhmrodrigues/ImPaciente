package Domain.Controller.Menu;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CmenuDoctor extends Cmenu{

    public Button btnEntrar;
    public TextField txtCRM;

    public void BtnEntrarClick() throws IOException {
        Stage primaryStage = new Stage();
        String crm = txtCRM.getText();
        RunMenu("InfosDoctorView.fxml",primaryStage);
    }
}
