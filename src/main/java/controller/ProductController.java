package controller;

import dao.ProductDAOImpl;
import model.Manufacturer;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "web/pages/Products.jsp";
    private static String LIST_PRODUCTS = "web/pages/Products";
    private ProductDAOImpl dao;

    public ProductController() {
        super();
        dao = new ProductDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int productId = Integer.parseInt(request.getParameter("productId"));
            dao.deleteProduct(productId);
            forward = LIST_PRODUCTS;
            request.setAttribute("products", dao.getAll());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int productId = Integer.parseInt(request.getParameter("productId"));
            Product product = dao.getById(productId);
            request.setAttribute("product", product);
        } else if (action.equalsIgnoreCase("listProducts")) {
            forward = LIST_PRODUCTS;
            request.setAttribute("products", dao.getAll());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        product.setName(request.getParameter("firstName"));
        product.setPrice(Integer.parseInt(request.getParameter("lastName")));
        //product.setManufacturer(request.getParameter();
        String productId = request.getParameter("productId");
        if (productId == null || productId.isEmpty()) {
            dao.addProduct(product);
        } else {
            product.setId(Long.parseLong(productId));
            dao.updateProduct(product);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_PRODUCTS);
        request.setAttribute("products", dao.getAll());
        view.forward(request, response);
    }
}