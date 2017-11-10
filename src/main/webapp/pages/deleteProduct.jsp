<%--
  Created by IntelliJ IDEA.
  User: maksim.lyahovets
  Date: 08.11.2017
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@page import="dao.ProductDAOImpl"%>
<jsp:useBean id="p" class="model.Product"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>
<h2>
<%
    try {
        ProductDAOImpl dao = new ProductDAOImpl();
        int i = dao.deleteProduct(p);
        response.sendRedirect("Products.jsp");
    }catch (Exception e){
        e.getMessage();
        System.out.println("Error!");
    }
%>
</h2>