<%@ page import="java.io.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<%
	 	String name = (String) session.getAttribute("name");
		if (name != null){
			out.print("<h1> Welcome: "+ name +" </h1>");  %>

	<form action="Logout" method="post">
		<input type="submit" value="logout">
	</form>
	<% } else {
   	 %>
	<form action="Login" method="post">
		username : <input type="text" name="uname"> pass : <input
		type="text" name="pass"> <input type="submit" value="login">
	</form>
	<% }
	 %>

    <br>
	<br>
	<a href="PasswordDimenticata.jsp"> Password Dimenticata? </a>
	
	
</body>
</html>