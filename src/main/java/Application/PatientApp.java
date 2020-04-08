package Application;

import Application.Interfaces.IPatientApp;
import Domain.Model.Users.Patient;
import Infra.Repositories.PatientRepository;

public class PatientApp extends BaseApp<Patient> implements IPatientApp {

    private PatientRepository _patientRepository;

    public PatientApp(){
        _patientRepository = new PatientRepository();
    }

    public Patient patientLogin(Patient patient) throws Exception {
        Patient sqlPacient =  _patientRepository.patientByCPF(patient);

        if(sqlPacient == null || !sqlPacient.getPassword().equals(patient.getPassword())){
            throw new Exception("CPF e/ou senha inválidos");
        }
        else{
            return sqlPacient;
        }
    }
}
