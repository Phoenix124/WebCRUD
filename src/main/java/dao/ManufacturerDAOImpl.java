package dao;

import model.Manufacturer;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ManufacturerDAOImpl implements ManufacturerDAO {

    private static final Logger logger = LoggerFactory.getLogger(ManufacturerDAOImpl.class);

    public void addManufacter(Manufacturer manufacturer) {
        Session session = dao.HibernateLoader.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(manufacturer);
        session.flush();
        session.getTransaction().commit();
        logger.info("Manufacturer successfully added. Details: " + manufacturer);
    }

    public Manufacturer getById(int id) {
        Session session = dao.HibernateLoader.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Manufacturer manufacturer = session.get(Manufacturer.class, id);
        if (manufacturer != null) {
            session.getTransaction().commit();
        } else session.getTransaction().rollback();
        logger.info("Manufacturer successfully loaded. Details: " + manufacturer);

        return manufacturer;
    }

    public void updateManufacter(Manufacturer manyfacter) {
        Session session = dao.HibernateLoader.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.update(manyfacter);
        session.getTransaction().commit();
        logger.info("Manufacturer successfully updated. Details: " + manyfacter);
    }

    public void deleteManufacter(int id) {
        Session session = dao.HibernateLoader.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Manufacturer manufacturer = session.get(Manufacturer.class, id);
        if (manufacturer != null) {
            session.delete(manufacturer);
            session.getTransaction().commit();
        } else session.getTransaction().rollback();
        logger.info("Manufacturer successfully deleted. Details: " + manufacturer);
    }

    public List<Manufacturer> getAll() {
        Session session = dao.HibernateLoader.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Manufacturer> list = session.createQuery("from Manufacter ", Manufacturer.class).list();
        for (Manufacturer manufacturer : list) {
            logger.info("Manufacturer list: " + manufacturer);
        }
        session.getTransaction().commit();
        return list;
    }
}