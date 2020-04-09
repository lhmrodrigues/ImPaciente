package Domain.Model.Prescription;

import Domain.Model.Medicine.Medicine;
import Domain.Model.Users.Medic;
import Domain.Model.Users.Patient;
import Domain.Shared.Entity;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@javax.persistence.Entity
public class Prescription extends Entity {

    //PROPERTIES
    @OneToOne(targetEntity = Medic.class,fetch = FetchType.EAGER)
    private Medic medic;

    @OneToOne(targetEntity = Patient.class,fetch = FetchType.EAGER)
    private Patient patient;

    @OneToMany(targetEntity = Medicine.class,fetch = FetchType.EAGER)
    private List<Medicine> medicineList;


    //GETTERS AND SETTERS
    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

}
