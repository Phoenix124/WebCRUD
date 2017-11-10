<%--
  Created by IntelliJ IDEA.
  User: maksim.lyahovets
  Date: 08.11.2017
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Product" %>
<%@ page import="dao.ProductDAOImpl" %>
<%@ page import="java.util.Set" %>
<a href="Manufacturers.jsp">View All Manufacturers</a><br/>

<%
    ProductDAOImpl dao = new ProductDAOImpl();
    Set<Product> products = dao.getAll();
    request.setAttribute("products", products);
%>
<h1>Add New Manufacturer</h1>
<form action="addManufacturer.jsp" method="post">
    <table>
        <tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
        <tr><td>Products:</td><td>
            <c:forEach items="${products}" var="product">
        <tr>
            <td><c:out value="${product.name}" /></td>
        </tr>
        </c:forEach>
        <tr><td colspan="2"><input type="submit" value="Add Product"/></td></tr>
</table>
</form>