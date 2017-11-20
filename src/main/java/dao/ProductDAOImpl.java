package dao;

import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductDAOImpl {

    private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

    public boolean addProduct(Product product) {
        try {
            Session session = HibernateLoader.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(product);
            session.flush();
            session.getTransaction().commit();
            logger.info("Product successfully added. Details: " + product);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public static Product getById(int id) {
        Session session = HibernateLoader.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        if (product != null) {
            session.getTransaction().commit();
        } else session.getTransaction().rollback();
        logger.info("Product successfully loaded. Details: " + product);

        return product;
    }

    public boolean updateProduct(Product product) {
        try {
            Session session = HibernateLoader.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
            logger.info("Product successfully loaded. Details: " + product);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean deleteProduct(Product product) {
        try {
            SessionFactory factory = HibernateLoader.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(product);

            session.getTransaction().commit();
            session.close();
            logger.info("Product successfully loaded. Details: " + product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<Product> getAll() {
        Session session = HibernateLoader.getSessionFactory().openSession();
        session.beginTransaction();
        List<Product> list = session.createQuery("FROM model.Product ", Product.class).list();
        for (Product product: list) {
            logger.info("Product list: " + product);
        }
        session.getTransaction().commit();
        return list;
    }

}