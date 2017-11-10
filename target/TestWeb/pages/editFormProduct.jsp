<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Form</title>
</head>
<body>
<%@page import="dao.ProductDAOImpl,model.Product" %>
<%@page import="java.sql.*" %>

<%
    ProductDAOImpl dao = new ProductDAOImpl();
    String id = request.getParameter("id");
    Product p = dao.getById(Integer.parseInt(id));
%>

<h1>Edit Form</h1>
<form action="editProduct.jsp" method="post">
    <input type="hidden" name="id" value="<%=p.getId() %>"/>
    <table>
        <tr>
            <td>Name:</td>
            <td>
                <input type="text" name="name" value="<%= p.getName()%>"/></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td>
                <input type="number" name="price" value="<%=p.getPrice()%>"/></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><input type="text" name="description" value="<%=p.getDescription()%>"/></td>
        </tr>

        <tr>
            <td>Manufacturer:</td>
            <td>
                <select name="manufacturer" style="width:155px">
                    <%! String driverName = "com.mysql.jdbc.Driver";%>
                    <%!String url = "jdbc:mysql://localhost:3306/management";%>
                    <%!String user = "root";%>
                    <%!String psw = "root";%>
                    <form action="#">
                            <%
                    Connection con = null;
                    PreparedStatement ps = null;
                    try
                    {
                    Class.forName(driverName).newInstance();;
                    con = DriverManager.getConnection(url,user,psw);
                    String sql = "SELECT * FROM manufacturer";
                    ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    %>
                        <p>Select Name :
                            <select>
                                <%
                                    while (rs.next()) {
                                        String name = rs.getString("name");
                                %>
                                <option value="<%=name %>"><%=name %>
                                </option>
                                <%
                                    }
                                %>
                            </select>
                        </p>
                            <%
                    }
                    catch(SQLException e)
                    {
                    System.out.println(e);
                    }
                    %>
                </select>
                </form>
</td></tr>
    <tr>
        <td colspan="2"><input type="submit" value="Edit User"/></td>
    </tr>
</table>
</form>

</body>
</html>
