package Domain.Controller.Menu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;

public class Cmenu {

    public Button btnDoutor;
    public Button btnPaciente;
    public Button btnCadastrar;

    public void RunMenu( String formName,Stage primaryStage) throws IOException {
        primaryStage.setTitle(formName);
        Parent root = FXMLLoader.load(getClass().getResource("Forms/src/"+formName));
        primaryStage.setTitle(formName);
        primaryStage.setScene(new Scene(root,300,300));
        primaryStage.show();
    }

    public void BtnDoutorClick() throws IOException {
        Stage primaryStage = new Stage();
        RunMenu("MenuDoctorView.fxml",primaryStage);
    }
    public void BtnPacienteClick() throws IOException {
        Stage primaryStage = new Stage();
        RunMenu("MenuPacienteView.fxml",primaryStage);
    }
    public void BtnCadastrarClick() throws IOException {
        Stage primaryStage = new Stage();
        RunMenu("CadastroView.fxml",primaryStage);
    }
}
