package Infra.Repositories;

import Domain.Model.Users.Medic;
import Infra.Context.HibernateContext;
import Infra.Repositories.Interfaces.IMedicRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class MedicRepository extends BaseRepository<Medic> implements IMedicRepository {

    public Medic medicByCRM(String crm) {
        Session session = HibernateContext.getInstance().getSession();
        try {
            Query query = session.createQuery("FROM Medic WHERE cpfCrm = :crm");
            query.setParameter("crm", crm);
            return (Medic) query.uniqueResult();
        } catch (Exception e) {
            throw e;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
