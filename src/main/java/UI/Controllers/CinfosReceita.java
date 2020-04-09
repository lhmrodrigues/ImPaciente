package UI.Controllers;

import Application.PrescriptionApp;
import Application.UserSession;
import Domain.Model.Prescription.Prescription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;


public class CinfosReceita extends CBase {

    public CinfosReceita(){
        try {
            PrescriptionApp prescriptionApp = new PrescriptionApp();
            List<Prescription> prescriptionList = prescriptionApp.getByPatient(UserSession.getInstance().getUsuarioLogado());
            List<String> prescriptionString = new ArrayList<String>();

            for(Prescription item : prescriptionList){
                prescriptionString.add(item.getPatient().getName());
            }

            ObservableList<String>  prescriptionObs = FXCollections.observableArrayList(prescriptionString);
            ListView<String> listaMedicamentos = new ListView<>(prescriptionObs);
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
