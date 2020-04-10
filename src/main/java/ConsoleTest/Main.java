package ConsoleTest;

import Application.MedicApp;
import Application.MedicineApp;
import Application.PatientApp;
import Application.PrescriptionApp;
import Domain.Model.Medicine.Medicine;
import Domain.Model.Prescription.Prescription;
import Domain.Model.Users.Medic;
import Domain.Model.Users.Patient;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Started");
        PatientApp userApp = new PatientApp();
        Patient patient = new Patient();
        patient.setCpfCrm("11122233300");
        patient.setName("Douglas");
        patient.setPassword("1234");
        userApp.Add(patient);
        java.util.List<Patient> patientList = userApp.getAll(Patient.class);

        System.out.println(patientList.get(0).id);

        MedicApp medicApp = new MedicApp();
        Medic medic = new Medic();
        medic.setCpfCrm("1234");
        medic.setName("Luis");
        medic.setPassword("1234");
        medic.setPatientList(patientList);
        medicApp.Add(medic);
        java.util.List<Medic> medicList = medicApp.getAll(Medic.class);

        System.out.println(medicList.get(0).id);

        MedicineApp medicineApp = new MedicineApp();

        Medicine medicine = new Medicine();
        medicine.setName("Dramin");
        medicineApp.Add(medicine);

        Medicine medicine2 = new Medicine();
        medicine2.setName("Rivotril");
        medicineApp.Add(medicine2);

        Medicine medicine3 = new Medicine();
        medicine3.setName("Dorflex");
        medicineApp.Add(medicine3);

        Medicine medicine4 = new Medicine();
        medicine4.setName("Venlafaxina");
        medicineApp.Add(medicine4);

        Medicine medicine5 = new Medicine();
        medicine5.setName("Paracetamol");
        medicineApp.Add(medicine5);

        java.util.List<Medicine> medicineList = medicineApp.getAll(Medicine.class);

        System.out.println(medicineList.get(0).id);

        Date date = new Date();
        PrescriptionApp prescriptionApp = new PrescriptionApp();
        Prescription prescription = new Prescription();
        prescription.setPatient(patient);
        prescription.setMedic(medic);
        prescription.setDateOfInclude(date);
        prescription.setMedicineList(medicineList);
        prescriptionApp.Add(prescription);
        List<Prescription> prescriptionList = prescriptionApp.getAll(Prescription.class);

        System.out.println(prescriptionList.get(0).id);

    }
}
