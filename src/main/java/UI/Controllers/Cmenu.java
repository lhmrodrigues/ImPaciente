package UI.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;


import java.io.IOException;

public class Cmenu extends CBase{

    public Button btnEntrar;
    public Button btnCadastrar;
    public TextField txtUsuario;

    public void BtnEntrarClick() throws IOException {

        Stage primaryStage = new Stage();
        OpenPage(".fxml",primaryStage);
    }

    public void BtnCadastrarClick() throws IOException {
        Stage primaryStage = new Stage();
        OpenPage("CadastroView.fxml",primaryStage);
    }
}
