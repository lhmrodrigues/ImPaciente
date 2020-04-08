package ConsoleTest;

import Application.PatientApp;
import Domain.Model.Users.Patient;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Started");
        PatientApp userApp = new PatientApp();
        Patient patient = new Patient();
        patient.setCpf("42188612850");
        patient.setName("Douglas");
        userApp.Add(patient);
        List<Patient> patientList = userApp.getAll(Patient.class);

        System.out.println(patientList.get(0).id);
    }
}
