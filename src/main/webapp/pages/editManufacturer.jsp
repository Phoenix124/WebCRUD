<%@page import="model.Product"%>
<%@page import="dao.ProductDAOImpl"%>
<%@ page import="model.Manufacturer" %>
<%@ page import="dao.ManufacturerDAOImpl" %>
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
<form name="update_form" action="<%=request.getContextPath()%>/ManufactureController" method="post">
    <table>
        <thead>
        <tr>
            <th colspan="3">Update product</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <%
                Manufacturer m = ManufacturerDAOImpl.getById(Integer.parseInt(request.getParameter("manufacturerId")));
            %>
            <td>Product Name</td>
            <td>:</td>
            <td>
                <input type="hidden" name="manufacturerId" value="<%=m.getId()%>"/>
                <input type="text" name="manufacturerName" value="<%=request.getParameter("manufacturerName")%>"/>
            </td>
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
<h2>
    <a href="Manufacturers.jsp">All Records</a>
</h2>
</body>
</html>
