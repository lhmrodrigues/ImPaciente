package Infra.Repositories.Interfaces;

import Domain.Model.Prescription.Prescription;

import java.util.List;

public interface IPrescriptionRepository extends IBaseRepository<Prescription> {
    List<Prescription> getByPatient(int id);
}
