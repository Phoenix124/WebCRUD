<%@ page import="java.sql.*" %>
<a href="Products.jsp">View All Products</a><br/>

<h1>Add New Product</h1>
<form action="addProduct.jsp" method="post">
    <table>
        <tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
        <tr><td>Price:</td><td>
            <input type="number" name="price"/></td></tr>
        <tr><td>Description:</td><td><input type="text" name="description"/></td></tr>
        <tr><td>Manufacturer:</td><td>
            <select name="manufacturer" style="width:155px">
                <%! String driverName = "com.mysql.jdbc.Driver";%>
                <%!String url = "jdbc:mysql://localhost:3306/management";%>
                <%!String user = "root";%>
                <%!String psw = "root";%>
                <form action="#">
                    <%
                    Connection con = null;
                    PreparedStatement ps = null;
                    try{

                    Class.forName(driverName).newInstance();
                    con = DriverManager.getConnection(url,user,psw);
                    String sql = "SELECT * FROM manufacturer";
                    ps = con.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    %>
                    <p>Select Name :
                        <select>
                            <%
                            while(rs.next())
                            {
                            String name = rs.getString("name");
                            %>
                            <option value="<%=name%>"><%=name%></option>
                            <%
                            }
                            %>
                        </select>
                    </p>
                    <%
                    }catch(SQLException e){
                    System.out.println(e);
                    }
                    %>
            </select>
            </form>
        </td></tr>
        <tr><td colspan="2"><input type="submit" value="Add Product"/></td></tr>
    </table>
</form>