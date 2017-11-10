<%--
  Created by IntelliJ IDEA.
  User: Phoenix
  Date: 03.11.2017
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@page import="dao.ProductDAOImpl"%>
<jsp:useBean id="p" class="model.Product"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>

<h2>
<%
    try {
        ProductDAOImpl dao = new ProductDAOImpl();
        dao.addProduct(p);
        System.out.println("User added!");
    }catch (Exception e){
        e.getMessage();
        System.out.println("Error!");
    }
%>
</h2>