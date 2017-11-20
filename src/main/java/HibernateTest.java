import dao.HibernateLoader;
import dao.ManufacturerDAOImpl;
import dao.ProductDAOImpl;
import model.Manufacturer;
import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class HibernateTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateLoader.getSessionFactory();
        Session session = sessionFactory.openSession();
        ManufacturerDAOImpl dao = new ManufacturerDAOImpl();
        List<Manufacturer> products = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Manufacturer m");
            products = dao.getDataByManufacturerName();

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
        System.out.println(products);
    }
}