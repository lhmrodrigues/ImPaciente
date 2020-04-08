package Application.Interfaces;

import Domain.Model.Users.Patient;

public interface IPatientApp extends IBaseApp<Patient> {
    Patient patientLogin(Patient patient) throws Exception;
}
