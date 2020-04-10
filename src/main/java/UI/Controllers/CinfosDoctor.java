package UI.Controllers;

import Application.*;
import Domain.Model.Medicine.Medicine;
import Domain.Model.Prescription.Prescription;
import Domain.Model.Users.Medic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CinfosDoctor {

    @FXML
    private Text closeButton;

    public Button btnAdicionarMedicamento;
    public Button btnCriarReceita;
    public TextField txtCPF;
    public TextField txtNomeMedicamento;

    @FXML
    public ListView<Medicine> listMedicamento;
    private List<Medicine> medicinesList = new ArrayList<>();
    private ObservableList<Medicine> obsMedicines;

    public MedicApp medicApp = new MedicApp();
    public PatientApp patientApp = new PatientApp();
    public MedicineApp medicineApp = new MedicineApp();
    public PrescriptionApp prescriptionApp = new PrescriptionApp();

    public void AddMedicine() throws IOException {
        try {
            Medicine medicine = new Medicine();
            medicine.id = 1;
            medicine.setName("aa");

            medicinesList.add(medicine);
            obsMedicines = FXCollections.observableArrayList(medicinesList);
            listMedicamento.setItems(obsMedicines);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    public void AddPrescripton() throws IOException {
        try {
            Prescription prescription = new Prescription();
            prescription.setPatient(patientApp.getById(UserSession.getInstance().getUsuarioLogado().id));
            prescription.setMedic(medicApp.getById(Integer.parseInt(txtNomeMedicamento.getText())));
            prescription.setMedicineList(obsMedicines);
            prescription.setDateOfInclude(new Date());

            prescriptionApp.Add(prescription);

        }
        catch (Exception e) {

        }
    }

    public void clickedOnBackButton(MouseEvent mouseEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
