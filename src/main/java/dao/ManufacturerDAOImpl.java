package dao;

import model.Manufacturer;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ManufacturerDAOImpl {

    private static final Logger logger = LoggerFactory.getLogger(ManufacturerDAOImpl.class);

    public boolean addManufacter(Manufacturer manufacturer) {

        try {
            Session session = dao.HibernateLoader.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(manufacturer);
            session.flush();
            session.getTransaction().commit();
            logger.info("Manufacturer successfully added. Details: " + manufacturer);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public static Manufacturer getById(int id) {
        Session session = dao.HibernateLoader.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Manufacturer manufacturer = session.get(Manufacturer.class, id);
        if (manufacturer != null) {
            session.getTransaction().commit();
        } else session.getTransaction().rollback();
        logger.info("Manufacturer successfully loaded. Details: " + manufacturer);

        return manufacturer;
    }

    public boolean updateManufacter(Manufacturer manyfacter) {

        try {
            Session session = dao.HibernateLoader.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            session.update(manyfacter);
            session.getTransaction().commit();
            logger.info("Manufacturer successfully updated. Details: " + manyfacter);
            return true;
        }catch (Exception e ){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteManufacter(Manufacturer manufacturer) {
        try {
            Session session = dao.HibernateLoader.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            session.delete(manufacturer);
            session.getTransaction().commit();
            logger.info("Manufacturer successfully deleted. Details: " + manufacturer);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static List<Manufacturer> getAll() {
        Session session = dao.HibernateLoader.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Manufacturer> list = session.createQuery("from model.Manufacturer ", Manufacturer.class).list();
        for (Manufacturer manufacturer : list) {
            logger.info("Manufacturer list: " + manufacturer);
        }
        session.getTransaction().commit();
        return list;
    }
    public static List<Manufacturer> getDataByManufacturerName() {
        Session session = HibernateLoader.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Manufacturer> listManufacturers = session.createQuery("FROM Manufacturer", Manufacturer.class).list();
        for (Manufacturer manufacturer : listManufacturers ) {
            logger.info("Manufacturer list: " + manufacturer);
        }
        session.getTransaction().commit();
        return listManufacturers;
    }
}