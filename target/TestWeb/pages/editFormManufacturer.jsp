<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Form</title>
</head>
<body>
<%@page import="dao.ProductDAOImpl,model.Product" %>
<%@page import="java.sql.*" %>
<%@ page import="dao.ManufacturerDAOImpl" %>
<%@ page import="model.Manufacturer" %>

<%
    ManufacturerDAOImpl dao = new ManufacturerDAOImpl();
    String id = request.getParameter("id");
    Manufacturer m = dao.getById(Integer.parseInt(id));
%>

<h1>Edit Form</h1>
<form action="editManufacturer.jsp" method="post">
    <input type="hidden" name="id" value="<%=m.getId() %>"/>
    <table>
        <tr>
            <td>Name:</td>
            <td>
                <input type="text" name="name" value="<%= m.getName()%>"/>
            </td>
        </tr>
        <tr>
            <td>Products:</td>
            <td>
                <input type="text" name="name" value="<%= m.getProducts()%>"/>
            </td>
        </tr>
<tr>
    <td colspan="2"><input type="submit" value="Edit User"/></td>
</tr>
</table>
</form>

</body>
</html>
