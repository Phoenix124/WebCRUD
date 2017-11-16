package controller;

import dao.ManufacturerDAOImpl;
import model.Manufacturer;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet(urlPatterns = "/ManufacturerController")
public class ManufacturerController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();


        if(request.getParameter("insert") != null){

            String manufacturerName = request.getParameter("name");

            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setName(manufacturerName);
            Set<Product> productList = manufacturer.getProducts();
            manufacturer.setProducts((Set<Product>) request.getAttribute(String.valueOf(productList)));


            boolean status =  new ManufacturerDAOImpl().addManufacter(manufacturer);
            if(status){
                request.getSession().setAttribute("sm", "Manufacturer saved successfully");
            }else{
                request.getSession().setAttribute("em", "Manufacturer not saved");
            }

            request.getRequestDispatcher("/pages/addManufacturer.jsp").forward(request, response);


        }else if(request.getParameter("update") != null){

            String manufacturerName = request.getParameter("name");
            int manufacturerId = Integer.parseInt(request.getParameter("manufacturerId"));

            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setName(manufacturerName);
            Set<Product> productList = manufacturer.getProducts();
            manufacturer.setProducts((Set<Product>) request.getAttribute(String.valueOf(productList)));
            manufacturer.setId(manufacturerId);

            boolean status =  new ManufacturerDAOImpl().updateManufacter(manufacturer);
            if(status){
                request.getSession().setAttribute("sm", "Manufacturer update successfully");
            }else{
                request.getSession().setAttribute("em", "Manufacturer not update");
            }

            request.getRequestDispatcher("/pages/editProduct.jsp?manufactureId=" + manufacturerId).forward(request, response);

        }else if(request.getParameter("for").equalsIgnoreCase("delete")){

            int manufacturerId = Integer.parseInt(request.getParameter("manufacturerId"));

            Manufacturer m = ManufacturerDAOImpl.getById(manufacturerId);

            //out.println(p.toString());

            boolean status =  new ManufacturerDAOImpl().deleteManufacter(m);

            if(status){
                request.getSession().setAttribute("sm", "Manufacturer deleted successfully");
            }else{
                request.getSession().setAttribute("em", "Manufacturer not deleted");
            }

            request.getRequestDispatcher("/pages/Manufacturers.jsp").forward(request, response);
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