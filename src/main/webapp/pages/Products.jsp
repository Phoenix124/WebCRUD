<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="dao.ProductDAOImpl"%>
<%@page import="java.util.Set" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/style.css">
</head>
<body>
<table border="1" style="border-collapse: collapse;" width="70%">
    <thead>
    <tr>
        <th colspan="6">Product List Table</th>
    </tr>
    <tr>
        <th>ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Manufacture</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>

    <%
        List<Product> list = ProductDAOImpl.getAll();
        for(Product p : list){
    %>

    <tr style="text-align: center;">
        <td><%= p.getId() %></td>
        <td><%= p.getName()%></td>
        <td><%= p.getPrice()%></td>
        <td><%= p.getManufacturer()%></td>
        <td><a href="editProduct.jsp?productId=<%= p.getId() %>"><button>Edit</button></a></td>
        <td><a href="ProductController?productId=<%= p.getId() %>&&for=delete" onclick="return confirm('are you sure?')"><button>Delete</button></a></td>
    </tr>

    <% } %>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="6">
            <font color="green">
                <c:if test="${sessionScope.sm != null}">
                    <c:out value="${sessionScope.sm}"/>
                    <c:remove scope="session" var="sm"/>
                </c:if>
            </font>
            <font color="red">
                <c:if test="${sessionScope.em != null}">
                    <c:out value="${sessionScope.em}"/>
                    <c:remove scope="session" var="em"/>
                </c:if>
            </font>
        </td>
    </tr>
    </tfoot>
</table>
<h2>
    <a href="addProduct.jsp">Add New Product</a>
</h2>
</body>
</html>
