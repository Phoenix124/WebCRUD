package controller;

import dao.ManufacturerDAOImpl;
import model.Manufacturer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManufacturerController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "web/pages/Products.jsp";
    private static String LIST_MMANUFACTERES = "web/pages/Manufacteres.JSP";
    private ManufacturerDAOImpl dao;

    public ManufacturerController() {
        super();
        dao = new ManufacturerDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int manufaterId = Integer.parseInt(request.getParameter("manufaterId"));
            dao.deleteManufacter(manufaterId);
            forward = LIST_MMANUFACTERES;
            request.setAttribute("manufacturers", dao.getAll());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int manufacturerId = Integer.parseInt(request.getParameter("manufacturerId"));
            Manufacturer manufacturer = dao.getById(manufacturerId);
            request.setAttribute("manufacturer", manufacturer);
        } else if (action.equalsIgnoreCase("listProducts")) {
            forward = LIST_MMANUFACTERES;
            request.setAttribute("manufacturers", dao.getAll());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(request.getParameter("Name"));
        String manufacturerId = request.getParameter("manufacturerId");
        if (manufacturerId == null || manufacturerId.isEmpty()) {
            dao.addManufacter(manufacturer);
        } else {
            manufacturer.setId(Long.parseLong(manufacturerId));
            dao.updateManufacter(manufacturer);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_MMANUFACTERES);
        request.setAttribute("manufacturers", dao.getAll());
        view.forward(request, response);
    }
}