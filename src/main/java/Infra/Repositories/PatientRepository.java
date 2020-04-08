package Infra.Repositories;

import Domain.Model.Users.Patient;
import Infra.Context.HibernateContext;
import Infra.Repositories.Interfaces.IPatientRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class PatientRepository extends BaseRepository<Patient> implements IPatientRepository {

    public Patient patientByCPF(Patient patient) {
        Session session = HibernateContext.getInstance().getSession();
        try {
            Query query = session.createQuery("FROM Patient WHERE cpfCrm = :cpf");
            query.setParameter("cpf", patient.getCpfCrm());
            return (Patient) query.uniqueResult();
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
