package UI.Controllers;

import Application.*;
import Application.Interfaces.IMedicApp;
import Domain.Model.Medicine.Medicine;
import Domain.Model.Prescription.Prescription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class CinfosDoctor extends CBase implements Initializable {

    public Button btnAdicionarMedicamento;
    public Button btnCriarReceita;
    public TextField txtCPF;
    public TextField txtNomeMedicamento;
    @FXML
    public ListView<Medicine> listMedicamento;
    public MedicApp medicApp;
    public PatientApp patientApp;
    public MedicineApp medicineApp;
    public PrescriptionApp prescriptionApp;
    @FXML
    private Text closeButton;
    private List<Medicine> medicinesList = new ArrayList<>();
    private ObservableList<Medicine> obsMedicines;

    public CinfosDoctor(){
        medicApp = new MedicApp();
        patientApp = new PatientApp();
        medicineApp = new MedicineApp();
        prescriptionApp = new PrescriptionApp();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            List<Medicine> allMedicines = medicineApp.getAll(Medicine.class);
            TextFields.bindAutoCompletion(txtNomeMedicamento, allMedicines);
        } catch (Exception e) {
            OpenAlert("Erro", e.getMessage(), "", Alert.AlertType.ERROR);
        }
    }

    public void AddMedicine() throws IOException {
        try {
            String[] array = txtNomeMedicamento.getText().split("-");
            Medicine medicine = medicineApp.getById(Integer.parseInt(array[0].trim()));
            if(medicine==null)
            {
                OpenAlert("Erro", "Este medicamento não existe", "", Alert.AlertType.ERROR);
                return;
            }
            medicinesList.add(medicine);
            obsMedicines = FXCollections.observableArrayList(medicinesList);
            listMedicamento.setItems(obsMedicines);
        } catch (Exception e) {
            OpenAlert("Erro", "Não foi possível adicionar o medicamento", "", Alert.AlertType.ERROR);
        }
    }

    public void AddPrescripton() throws Exception {
        try {
            Date date = new Date();
            Prescription prescription = new Prescription();
            prescription.setPatient(patientApp.getById(patientApp.getPatientByCPF(txtCPF.getText()).id));
            prescription.setMedic(medicApp.getById(UserSession.getInstance().getUsuarioLogado().id));
            prescription.setMedicineList(obsMedicines);
            if(obsMedicines==null || obsMedicines.size()==0)
            {
                OpenAlert("Atenção", "Não existe nenhum medicamento cadastrado na receita" , "", Alert.AlertType.WARNING);
                return;
            }
            prescription.setDateOfInclude(date);

            prescriptionApp.add(prescription);
            OpenAlert("Sucesso", "Prescrição médica criada", "", Alert.AlertType.CONFIRMATION);

        } catch (Exception e) {
            OpenAlert("Erro", "CPF não reconhecido/cadastrado", "", Alert.AlertType.ERROR);
        }
    }

    public void mouseClickOnListaMedicamentos(MouseEvent mouseEvent) throws Exception {
        try {
            Medicine medicineSelected = listMedicamento.getSelectionModel().getSelectedItem();
            listMedicamento.getItems().remove(medicineSelected);
            medicinesList.remove(medicineSelected);
        } catch (Exception e) {
            OpenAlert("Erro", "Nenhum medicamento pode ser retirado", "", Alert.AlertType.ERROR);
        }
    }

    public void clickedOnBackButton(MouseEvent mouseEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
