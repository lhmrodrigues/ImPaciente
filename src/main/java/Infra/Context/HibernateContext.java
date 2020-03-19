package Infra.Context;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateContext {

    private static HibernateContext INSTANCE = null;

    public static HibernateContext getInstance(){
        if(INSTANCE == null)
            INSTANCE = new HibernateContext();

        return INSTANCE;

    }

    private SessionFactory sessionFactory;

    public void setSessionFactory(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public HibernateContext(){
        sessionFactory   = new Configuration().configure().buildSessionFactory();
    }
}
