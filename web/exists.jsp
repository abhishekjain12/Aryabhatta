<%--
  Created by IntelliJ IDEA.
  User: jabhi
  Date: 06-Apr-17
  Time: 12:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/brain-game", "root", "");

        PreparedStatement ps = con.prepareStatement("SELECT * FROM details WHERE username = ?");
        ps.setString(1,request.getParameter("username"));
        ResultSet res = ps.executeQuery();
        if(res.first()){
            out.print("exists");
        }else{
            out.print("available");
        }
    }catch (Exception e){
        System.out.println(e);
    }
%>