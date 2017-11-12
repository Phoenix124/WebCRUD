<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add New Product</title>
</head>
<body>
<form method="POST" action='ProductController' name="formAddProduct"><input
        type="hidden" name="action" value="insert"/>
    <p><b>Add New Record</b></p>
    <table>
        <tr>
            <td>Product ID</td>
            <td><input type="text" name="productId" /></td>
    </tr>
    <tr>
        <td>Name</td>
        <td><input type="text" name="Name" /></td>
    </tr>
    <tr>
        <td>Price</td>
        <td><input type="number" step="0.01" name="price"/></td>
    </tr>
        <tr>
            <td>Manufacturer</td>
            <<select class="form-control" style="width: 250px;">
                <option>Select Manufacturer</option>
                <%
                    try {
                        String query = "SELECT name FROM management.manufacturer";
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/management?useSSL=false");
                        Statement statement = connection.createStatement();
                        ResultSet rs = statement.executeQuery(query);
                        while (rs.next()){
                            %>
                            <option value="<%=rs.getInt("manufacturer_id")%>"><%=rs.getString("manufacturer_name")%></option>
                            <%
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        System.out.println("Error" + e.getMessage());
                    }

                %>
            </select>
        </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Submit" /></td>
    </tr>
    </table>
</form>
<p><a href="ProductController?action=listProducts">View-All-Products</a></p>
</body>
</html>