package dao;

import model.Product;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductDAOImpl implements ProductDAO {

    private static final Logger logger = LoggerFactory.getLogger(ProductDAOImpl.class);

    public void addProduct(Product product) {
        Session session = HibernateLoader.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(product);
        session.flush();
        session.getTransaction().commit();
        logger.info("Product successfully added. Details: " + product);
    }

    public Product getById(int id) {
        Session session = HibernateLoader.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        if (product != null) {
            session.getTransaction().commit();
        } else session.getTransaction().rollback();
        logger.info("Product successfully loaded. Details: " + product);

        return product;
    }

    public void updateProduct(Product product) {
        Session session = HibernateLoader.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();
        logger.info("Product successfully loaded. Details: " + product);

    }

    public void deleteProduct(int id) {
        Session session = HibernateLoader.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        if (product != null) {
            session.delete(product);
            session.getTransaction().commit();
        } else session.getTransaction().rollback();
        logger.info("Product successfully loaded. Details: " + product);
    }

    public Set<Product> getAll() {
        Session session = HibernateLoader.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Product> list = session.createQuery("from Product ", Product.class).list();
        Set<Product> set = new HashSet<Product>(list);
        for (Product product: list) {
            logger.info("Product list: " + product);
        }
        session.getTransaction().commit();
        return set;
    }
}