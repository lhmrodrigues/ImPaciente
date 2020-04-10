package Application;

import Application.Interfaces.IPatientApp;
import Domain.Model.Users.Patient;
import Infra.Repositories.PatientRepository;

public class PatientApp extends BaseApp<Patient> implements IPatientApp {

    private PatientRepository _patientRepository;

    public PatientApp() {
        _patientRepository = new PatientRepository();
    }

    public Patient patientLogin(Patient patient) throws Exception {
        Patient sqlPacient = _patientRepository.patientByCPF(patient);

        if (sqlPacient == null || !sqlPacient.getPassword().equals(patient.getPassword())) {
            throw new Exception("CPF e/ou senha inválidos");
        } else {
            UserSession.getInstance().setUserLogado(sqlPacient);
            return sqlPacient;
        }
    }

    public Patient getPatientByCPF(String cpf) throws Exception {
        Patient patient = new Patient();
        patient.setCpfCrm(cpf);
        Patient sqlPacient = _patientRepository.patientByCPF(patient);

        if (sqlPacient == null) {
            throw new Exception("CPF desconhecido");
        } else {
            return sqlPacient;
        }
    }

    @Override
    public void Add(Patient entity) throws Exception {
        Patient sqlPacient = _patientRepository.patientByCPF(entity);
        if (sqlPacient == null) {
            super.Add(entity);
        } else {
            throw new Exception("Já existe Paciente com esse CPF");
        }
    }
}
