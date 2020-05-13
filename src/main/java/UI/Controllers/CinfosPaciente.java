package UI.Controllers;

import Domain.Model.Medicine.Medicine;
import Domain.Model.Prescription.Prescription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CinfosPaciente implements Initializable {

    @FXML
    private Text closeButton;
    @FXML
    private ListView<Medicine> listViewRemedios;

    public Button btnSair;

    private Prescription prescriptionSelected;
    private List<Medicine> medicinesList = new ArrayList<>();
    private ObservableList<Medicine> obsMedicines;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        medicinesList = prescriptionSelected.getMedicineList();
        obsMedicines = FXCollections.observableArrayList(medicinesList);
        listViewRemedios.setItems(obsMedicines);
    }

    public void initData(Prescription prescriptionSelected) {
        this.prescriptionSelected = prescriptionSelected;
    }

    public void clickedOnBackButton(MouseEvent mouseEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
