package UI.Controllers;

import Domain.Model.Medicine.Medicine;
import Domain.Model.Prescription.Prescription;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class CexcluirReceita extends CBase {

    public Button btnProcurar;
    private Prescription prescriptionSelected;
    private List<Medicine> medicinesList = new ArrayList<>();
    private ObservableList<Medicine> obsMedicines;
}
