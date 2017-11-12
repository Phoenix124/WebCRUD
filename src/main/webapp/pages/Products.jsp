<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Product" %>
<%@ page import="dao.ProductDAOImpl" %>
<%@ page import="java.util.Set" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Products</title>
</head>
<body>
<center>
    <h1>Products</h1>
    <h2>
        <a href="addProduct.jsp">Add New Product</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Products</h2></caption>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Manufacturer</th>
            <th>Action</th>
        </tr>
            <tr>
                </thead>
                <tbody>
                    <%
                     ProductDAOImpl dao = new ProductDAOImpl();
                     Set<Product> products = dao.getAll();
                     for (Product product : products) {
                 %>
                <tr>
                    <td><%=product.getId()%></td>
                    <td><%=product.getName()%></td>
                    <td><%=product.getPrice()%></td>
                    <td><%=product.getManufacturer()%></td>
                    <td>
                        <a href="ProductController?action=editProduct&productId=<%=product.getId()%>">Edit</a>
                        <a href="ProductController?action=deleteProduct&productId=<%=product.getId()%>">Delete</a>
                    </td>
                    <%}%>
                </tr>
                <tbody>
    </table>
</div>
</body>
</html>