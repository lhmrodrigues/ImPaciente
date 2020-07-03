package Infra.Context;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateContext {
    private static HibernateContext INSTANCE = null;
    private SessionFactory sessionFactory;

    public HibernateContext() {
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        catch (Exception e){
            System.out.println("Erro ao procurar o config hibernate " + e.getMessage());
        }
    }

    public static HibernateContext getInstance() {
        if (INSTANCE == null)
            INSTANCE = new HibernateContext();

        return INSTANCE;

    }

    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
