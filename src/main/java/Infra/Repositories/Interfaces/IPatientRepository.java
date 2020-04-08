package Infra.Repositories.Interfaces;

import Domain.Model.Users.Patient;

public interface IPatientRepository extends IBaseRepository<Patient> {
    Patient patientByCPF(Patient patient);
}
