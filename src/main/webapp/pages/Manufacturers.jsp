<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Manufacturer" %>
<%@ page import="dao.ManufacturerDAOImpl" %>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manufaturers</title>
</head>
<body>
<center>
    <h1>Manufaturers</h1>
    <h2>
        <a href="ManufacturerForm.jsp">Add New Manufacturer</a>
    </h2>
    <%
        ManufacturerDAOImpl dao = new ManufacturerDAOImpl();
        List<Manufacturer> manufacturers = dao.getAll();
        request.setAttribute("manufacturers", manufacturers);
    %>
</center>
    <table cellpadding="2" cellspacing="2" border="1">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>PRICE</th>
            <th>MANUFACTER</th>
            <th>DESCRIPTION</th>
        </tr>
        <c:forEach items="${manufacturers}" var="product">
        <tr>
            <td><c:out value="${product.id}" /></td>
            <td><c:out value="${product.name}" /></td>
            <td><c:out value="${product.price}" /></td>
            <td><c:out value="${product.manufacturer}" /></td>
            <td>
                <a href="<c:url value="/pages/editFormProduct.jsp?id=<c:out value='${product.id}' />"/>">Edit</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="<c:url value="/pages/deleteProduct.jsp?id=<c:out value='${product.id}' />"/>">Delete</a>
            </td>
        </tr>
        </c:forEach>
</body>
</html>
