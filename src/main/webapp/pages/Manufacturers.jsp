<%@ page import="java.util.List" %>
<%@ page import="model.Manufacturer" %>
<%@ page import="dao.ManufacturerDAOImpl" %>
<%@ page import="java.util.Arrays" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/style.css">
</head>
<h1>
    <a href="<c:url value="/index.jsp"/>">Go to main menu</a>
</h1>
<body>
<table border="1" style="border-collapse: collapse;" width="70%">
    <thead>
    <tr>
        <th colspan="6">Product List Table</th>
    </tr>
    <tr>
        <th>ID</th>
        <th>Manufacturer Name</th>
        <th>Products</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>

    <%
        List<Manufacturer> list = ManufacturerDAOImpl.getAll();
        for(Manufacturer m : list){
    %>

    <tr style="text-align: center;">
        <td><%= m.getId() %></td>
        <td><%= m.getName()%></td>
        <td><%= m.getProducts()%></td>
        <td><a href="editManufacturer.jsp?manufacturerId=<%= m.getId() %>"><button>Edit</button></a></td>
        <td><a href="<%=request.getContextPath()%>/ManufactureController?manufacturerId=<%= m.getId()%>&&for=delete" onclick="return confirm('are you sure?')"><button>Delete</button></a></td>
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
    <a href="addManufacturer.jsp">Add New Manufacturer</a>
</h2>
</body>
</html>
