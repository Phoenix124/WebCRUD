package controller;

import dao.ProductDAOImpl;
import model.Manufacturer;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name="/ProductController")
public class ProductController extends HttpServlet {
    private static String INSERT_PRODUCT = "/pages/addProduct.jsp";
    private static String EDIT_PRODUCT = "/pages/editProduct.jsp";
    private static String LIST_PRODUCTS = "/pages/Products.jsp";
    private ProductDAOImpl dao;

    public ProductController() {
        super();
        dao = new ProductDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect="";
        String uId = request.getParameter("productId");
        String action = request.getParameter("action");
        if(!((uId)== null) && action.equalsIgnoreCase("insert"))
        {
            int id = Integer.parseInt(uId);
            Product product = new Product();
            product.setId((long) id);
            product.setName(request.getParameter("Name"));
            product.setPrice(Double.parseDouble(request.getParameter("price")));
            product.setManufacturer((Manufacturer) request.getAttribute("manufacture"));
            dao.addProduct(product);
            redirect = LIST_PRODUCTS;
            request.setAttribute("product", dao.getAll());
            System.out.println("Record Added Successfully");
        }
        else if (action.equalsIgnoreCase("delete")){
            String productId = request.getParameter("productId");
            int uid = Integer.parseInt(productId);
            dao.deleteProduct(uid);
            redirect = LIST_PRODUCTS;
            request.setAttribute("product", dao.getAll());
            System.out.println("Record Deleted Successfully");
        }else if (action.equalsIgnoreCase("editform")){
            redirect = EDIT_PRODUCT;
        } else if (action.equalsIgnoreCase("edit")){
            String productId = request.getParameter("productId");
            int uid = Integer.parseInt(productId);
            Product product = new Product();
            product.setId((long) uid);
            product.setName(request.getParameter("Name"));
            product.setPrice(Double.parseDouble(request.getParameter("price")));
            product.setManufacturer((Manufacturer) request.getAttribute("manufacture"));
            dao.updateProduct(product);
            request.setAttribute("product", product);
            redirect = LIST_PRODUCTS;
            System.out.println("Record updated Successfully");
        } else if (action.equalsIgnoreCase("listProducts")){
            redirect = LIST_PRODUCTS;
            request.setAttribute("products", dao.getAll());
        } else {
            redirect = INSERT_PRODUCT;
        }

        RequestDispatcher rd = request.getRequestDispatcher(redirect);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}