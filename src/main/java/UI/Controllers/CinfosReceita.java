package UI.Controllers;

import Application.PrescriptionApp;
import Application.UserSession;
import Domain.Model.Prescription.Prescription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class CinfosReceita extends CBase implements Initializable {

    @FXML
    private ListView<Prescription> listaReceitas;
    private List<Prescription> prescriptionList = new ArrayList<>();
    private ObservableList<Prescription> obsPrescription;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadPrescriptions();
    }

    private void loadPrescriptions() {
        try {
            PrescriptionApp prescriptionApp = new PrescriptionApp();
            prescriptionList = prescriptionApp.getByPatient(UserSession.getInstance().getUsuarioLogado());
            obsPrescription = FXCollections.observableArrayList(prescriptionList);
            listaReceitas.setItems(obsPrescription);
        }
        catch (Exception e)
        {
            OpenAlert("Erro",e.getMessage(),"", Alert.AlertType.ERROR);
        }
    }

    public void BtnConfirmarClick(ActionEvent actionEvent) {
        try {
            openSelectPrescription();
        }
        catch (Exception e)
        {
            OpenAlert("Erro",e.getMessage(),"", Alert.AlertType.ERROR);
        }
    }


    public void mouseClickOnListaMedicamentos(MouseEvent mouseEvent) {
        try {
            openSelectPrescription();
        }
        catch(Exception e)
        {
            OpenAlert("Erro",e.getMessage(),"", Alert.AlertType.ERROR);
        }
    }

    private void openSelectPrescription() throws IOException {
        Prescription prescriptionSelected = listaReceitas.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/InfosPacienteView.fxml"));

        Stage primaryStage = new Stage();

        CinfosPaciente controller = loader.<CinfosPaciente>getController();
        controller.initData(prescriptionSelected);

        primaryStage.setTitle("Informações da Receita");
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.show();
    }
}
