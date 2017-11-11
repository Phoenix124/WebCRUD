import dao.HibernateLoader;
import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class HibernateTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateLoader.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Product> products = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM model.Product");
            products = query.getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
        for (Product product : products){
            System.out.println(product.toString());
        }
    }
}