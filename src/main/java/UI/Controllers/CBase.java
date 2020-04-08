package UI.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class CBase {
    public void OpenPage(String formName, Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/Views/"+formName));
        primaryStage.setTitle(formName);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}
