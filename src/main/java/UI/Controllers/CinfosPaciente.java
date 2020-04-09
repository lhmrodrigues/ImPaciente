package UI.Controllers;

import Domain.Model.Prescription.Prescription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CinfosPaciente implements Initializable {

    private Prescription prescriptionSelected;

    @FXML
    private ListView<Prescription> listViewRemedios;
    private List<Prescription> medicinesList = new ArrayList<>();
    private ObservableList<Prescription> obsMedicines;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initData(Prescription prescriptionSelected) {
        this.prescriptionSelected = prescriptionSelected;
    }
}
