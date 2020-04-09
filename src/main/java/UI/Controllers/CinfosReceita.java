package UI.Controllers;

import Application.PrescriptionApp;
import Application.UserSession;
import Domain.Model.Prescription.Prescription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class CinfosReceita extends CBase implements Initializable {

    @FXML
    private ListView<Prescription> listaMedicamentos;
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
            listaMedicamentos.setItems(obsPrescription);
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    public void BtnConfirmarClick(ActionEvent actionEvent) {
    }


}
