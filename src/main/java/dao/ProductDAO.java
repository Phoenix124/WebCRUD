package dao;

import model.Product;

import java.util.Set;

public interface ProductDAO {

    void addProduct(Product product);

    Product getById(int id);

    void updateProduct(Product product);

    void deleteProduct(int id);

    Set<Product> getAll();

}