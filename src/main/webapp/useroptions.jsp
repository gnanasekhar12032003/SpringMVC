<%@page import="com.jsp.Controller.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <% 
     User u=(User) session.getAttribute("userobj"); 
     %>
     
     <%if(u!=null)  {
     %>
     <h1>${message}</h1> <br>
    <a href="adduser"> Add User Information</a>
    
    <a href="fetchalldata">View All Users</a>
    <%
    } else { 
     %>
    <a href="login.jsp"><h1>Please Login first</h1></a>
    
    <% } %>
    
</body>
</html>