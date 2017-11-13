<%@page import="model.Product"%>
<%@page import="dao.ProductDAOImpl"%>
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
<form name="update_form" action="<%=request.getContextPath()%>/ProductController" method="post">
    <table>
        <thead>
        <tr>
            <th colspan="3">Update product</th>
        </tr>
        </thead>
        <tbody>
        <%
            Product p = ProductDAOImpl.getById(Integer.parseInt(request.getParameter("productId")));
        %>
        <tr>
            <td>Product Name</td>
            <td>:</td>
            <td>
                <input type="hidden" name="productId" value="<%= p.getId()%>"/>
                <input type="text" name="productName" value="<%= p.getName() %>"/>
            </td>
        </tr>
        <tr>
            <td>Price</td>
            <td>:</td>
            <td><input type="text" name="price" value="<%= p.getPrice()%>"/></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td><input type="submit" name="update" value="Update"/></td>
        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="3">
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
</form>
</body>
</html>
