<%@ page import="dao.ManufacturerDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: Phoenix
  Date: 03.11.2017
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="m" class="model.Manufacturer"></jsp:useBean>
<jsp:setProperty property="*" name="m"/>

<h2>
    <%
        try {
            ManufacturerDAOImpl dao = new ManufacturerDAOImpl();
            dao.addManufacter(m);
            System.out.println("Manufacturer added!");
        }catch (Exception e){
            e.getMessage();
            System.out.println("Error!");
        }
    %>
</h2>
