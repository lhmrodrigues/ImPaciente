package ConsoleTest;

import Application.PatientApp;
import Domain.Model.Users.Patient;
import Domain.Controller.Menu.Cmenu;
import javafx.stage.Stage;

import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Cmenu m = new Cmenu ();
        Stage stage = new Stage();
        m.RunMenu("MenuPrincipalView.fxml", stage);


        System.out.println("Started");
        PatientApp userApp = new PatientApp();
        Patient patient = new Patient();
        patient.setAge(10);
        patient.setCpf("42188612850");
        patient.setName("Douglas");
        userApp.Add(patient);
        List<Patient> patientList = userApp.getAll(Patient.class);

        System.out.println(patientList.get(0).id);
    }
}
