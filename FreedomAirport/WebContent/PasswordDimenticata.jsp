<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/general.css" type="text/css"
	media="all">
<link rel="stylesheet" href="css/nav.css" type="text/css" media="all">
<link rel="stylesheet" href="css/login.css" type="text/css" media="all">
<title> Password Dimenticata </title>
</head>
<body>
<%@ include file="header.jsp"%>
<br>
<br>
   Inserisci :
<br>
<br>
	<form action="PasswordDimenticata" method="post">
		Email : <input type="text" name="email"> 
		Nuova password: <input type="text" name="pass"> 
		<input type="submit" value="invio">
	</form>

	
	 <%@ include file="footer.jsp"%>

</body>
</html>