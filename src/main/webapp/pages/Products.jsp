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
        <a href="ProductForm.jsp">Add New Product</a>
    </h2>
<%
//    ProductDAOImpl dao = new ProductDAOImpl();
//    Set<Product> products = dao.getAll();
//    request.setAttribute("products", products);
//    for (Product p : products)
%>
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
        <%--<c:forEach items="${products}" var="product">--%>
            <tr>
                </thead>
                <tbody>
                    <%
                     ProductDAOImpl dao = new ProductDAOImpl();
                     Set<Product> products = dao.getAll();
                     for (Product u : products) {
                 %>
                <tr>
                    <td><%=u.getId()%></td>
                    <td><%=u.getName()%></td>
                    <td><%=u.getPrice()%></td>
                    <td><%=u.getManufacturer()%></td>
                </tr>
                    <%}%>
                <tbody>
                <td>
                    <a href="<c:url value="/pages/editFormProduct.jsp?id=<c:out value='${product.id}' />"/>">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="<c:url value="/pages/deleteProduct.jsp?id=<c:out value='${product.id}' />"/>">Delete</a>
                </td>

        <%--</c:forEach>--%>

    </table>
</div>
</body>
</html>