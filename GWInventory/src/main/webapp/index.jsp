<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<h1>Hahahaha</h1>
<table>
<tr>
<td><a href="./">Index</a></td>
<td><a href="./DemoServlet">Demo</a></td>
<td><a href="./user/MaterialStorage">Material Storage</a></td>
</tr>
</table>
<% if(session.getAttribute("username")== null) { %>
	<p> Not logged in. </p>
	<a href="./login.jsp">Login</a>
	<a href="./register.jsp">Register</a>
<% } else {%>
	<p>Logged in as ${username} ${id}</p>
	<a href="./logout">Logout</a>
<% } %>
</body>
</html>
