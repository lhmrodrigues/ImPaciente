package UI.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CBase {
    public void OpenSimplePage(String formName) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Views/" + formName));
        primaryStage.setTitle(formName);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public boolean OpenAlert(String title, String menssageHeader, String messageContainer, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(menssageHeader);
        alert.setContentText(messageContainer);
        AtomicBoolean result = new AtomicBoolean(false);

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                result.set(true);
            }
        });
        return result.get();
    }
}
