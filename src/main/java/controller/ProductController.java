package controller;

import dao.ManufacturerDAOImpl;
import dao.ProductDAOImpl;
import model.Manufacturer;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/ProductController")
public class ProductController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        if(request.getParameter("insert") != null){
            int productId = Integer.parseInt(request.getParameter("productId"));
            String productName = request.getParameter("productName");
            double price = Double.parseDouble(request.getParameter("price"));
            String manufactureName = request.getParameter("manufacture");
            Manufacturer manufacturer = ManufacturerDAOImpl.getById(Integer.parseInt(manufactureName));
            Product product = new Product();
            product.setId(productId);
            product.setName(productName);
            product.setPrice(price);
            product.setManufacturer(manufacturer);


            boolean status =  new ProductDAOImpl().addProduct(product);
            if(status){
                request.getSession().setAttribute("sm", "Product saved successfully");
            }else{
                request.getSession().setAttribute("em", "Product not saved");
            }
            request.getRequestDispatcher("/pages/addProduct.jsp").forward(request, response);


        }else if(request.getParameter("update") != null){

            String productName = request.getParameter("productName");
            int productId = Integer.parseInt(request.getParameter("productId"));
            double price = Double.parseDouble(request.getParameter("price"));

            Product product = new Product();
            product.setName(productName);
            product.setPrice(price);
            product.setManufacturer((Manufacturer) request.getAttribute("manufacture"));
            product.setId(productId);

            boolean status =  new ProductDAOImpl().updateProduct(product);
            if(status){
                request.getSession().setAttribute("sm", "Product update successfully");
            }else{
                request.getSession().setAttribute("em", "Product not update");
            }

            request.getRequestDispatcher("/pages/editProduct.jsp?productId=" + productId).forward(request, response);

        }else if(request.getParameter("for").equalsIgnoreCase("delete")){

            int productId = Integer.parseInt(request.getParameter("productId"));

            Product p = ProductDAOImpl.getById(productId);

            //out.println(p.toString());

            boolean status =  new ProductDAOImpl().deleteProduct(p);

            if(status){
                request.getSession().setAttribute("sm", "Product deleted successfully");
            }else{
                request.getSession().setAttribute("em", "Product not deleted");
            }

            request.getRequestDispatcher("/pages/Products.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}