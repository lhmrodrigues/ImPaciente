package Infra.Repositories;

import Domain.Model.Prescription.Prescription;
import Infra.Context.HibernateContext;
import Infra.Repositories.Interfaces.IPrescriptionRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PrescriptionRepository extends BaseRepository<Prescription> implements IPrescriptionRepository {

    public List<Prescription> getByPatient(int id) {
        Session session = HibernateContext.getInstance().getSession();
        try {
            Query query = session.createQuery("FROM Prescription WHERE patient_id = :id");
            query.setParameter("id", id);
            return (List<Prescription>) query.getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
