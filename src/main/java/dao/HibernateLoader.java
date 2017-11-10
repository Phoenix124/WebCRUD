package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateLoader  {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    /**
     * Method return static field sessionFactory referenced on SessionFactory object created by configuration
     * @return SessionFactory object
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Method shutdown SessionFactory object
     */
    public static void shutdown() {
        getSessionFactory().close();
    }
}
