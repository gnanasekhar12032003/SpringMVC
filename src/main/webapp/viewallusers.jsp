<%@page import="com.jsp.Controller.User"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <% List<User> users=(List<User>)request.getAttribute("allusersinfo");
     %>
     <table cellpadding="20px" border="1">
       <th>id</th>
       <th>name</th>
       <th>email</th>
       <th>password</th>
       <th>mobilenumber</th>
       <th>update</th>
       <th>delete</th>
       <%
         for(User user:users){
       %>
       <tr>
           <td><%= user.getId() %></td>
           <td><%= user.getName() %></td>
           <td><%= user.getEmail() %></td>
           <td><%= user.getPassword() %></td>
           <td><%= user.getMobilenumber() %></td>
           <td><a href="updateuser?id=<%= user.getId() %>">update</a></td>
           <td><a href="deleteuser?id=<%= user.getId() %>">delete</a></td>
       </tr>
       <% } %>
     </table>
</body>
</html>