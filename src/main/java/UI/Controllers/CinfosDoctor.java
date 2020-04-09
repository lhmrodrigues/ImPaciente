package UI.Controllers;

import Application.*;
import Domain.Model.Medicine.Medicine;
import Domain.Model.Prescription.Prescription;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class CinfosDoctor {

    @FXML
    private Text closeButton;

    public Button btnAdicionarMedicamento;
    public Button btnCriarReceita;
    public TextField txtCPF;
    public TextField txtNomeMedicamento;
    public ListView listMedicamento;
    public MedicApp medicApp = new MedicApp();
    public PatientApp patientApp = new PatientApp();
    public MedicineApp medicineApp = new MedicineApp();
    public PrescriptionApp prescriptionApp = new PrescriptionApp();
    public ObservableList<Medicine> listaMedicamentosAdicioandos = new ObservableListBase<Medicine>() {
        @Override
        public Medicine get(int i) {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    };

    public void AddMedicine() throws IOException {
        try {
            //Medicine medicine = medicineApp.getById(Integer.parseInt(txtNomeMedicamento.getText()));
            Medicine medicine = new Medicine();
            medicine.id = Integer.parseInt(txtNomeMedicamento.getText());
            listaMedicamentosAdicioandos.add(medicine);
            listMedicamento.setItems(listaMedicamentosAdicioandos);
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
            prescription.setMedicineList(listaMedicamentosAdicioandos);
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
