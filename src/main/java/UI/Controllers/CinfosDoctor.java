package UI.Controllers;

import Application.*;
import Domain.Model.Medicine.Medicine;
import Domain.Model.Prescription.Prescription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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

public class CinfosDoctor extends CBase{

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
            //Medicine medicine = medicineApp.getById(Integer.parseInt(txtNomeMedicamento.getText()));
            Medicine medicine = new Medicine();
            medicine.id = 1;
            medicine.setName("aa");
            medicinesList.add(medicine);
            obsMedicines = FXCollections.observableArrayList(medicinesList);
            listMedicamento.setItems(obsMedicines);

        }
        catch (Exception e)
        {
            OpenAlert("Erro",e.getMessage(),"", Alert.AlertType.ERROR);
        }
    }

    public void AddPrescripton() throws Exception {
        try {
            Date date = new Date();
            Prescription prescription = new Prescription();
            prescription.setPatient(patientApp.getById(patientApp.getPatientByCPF(txtCPF.getText()).id));
            prescription.setMedic(medicApp.getById(UserSession.getInstance().getUsuarioLogado().id));
            prescription.setMedicineList(obsMedicines);
            prescription.setDateOfInclude(date);

            prescriptionApp.Add(prescription);
            OpenAlert("Sucesso","Prescrição médica criada","", Alert.AlertType.CONFIRMATION);

        }
        catch (Exception e) {
            OpenAlert("Erro",e.getMessage(),"", Alert.AlertType.ERROR);
        }
    }

    public void mouseClickOnListaMedicamentos(MouseEvent mouseEvent) throws Exception {
        try {
            Medicine medicineSelected = listMedicamento.getSelectionModel().getSelectedItem();
            listMedicamento.getItems().remove(medicineSelected);
            medicinesList.remove(medicineSelected);
        }
        catch(Exception e)
        {
            OpenAlert("Erro",e.getMessage(),"", Alert.AlertType.ERROR);
        }
    }

    public void clickedOnBackButton(MouseEvent mouseEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}
