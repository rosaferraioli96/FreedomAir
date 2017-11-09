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
<link rel="stylesheet" href="css/cssPerPagine.css" type="text/css"
	media="all">
<title> Password Dimenticata </title>
</head>
<body>
<%@ include file="header.jsp"%>
<br>
<br>
   <p> <strong> Inserisci: </strong><p>

	<form action="PasswordDimenticata" method="post">
		<p > <strong>Email : <input type="text" name="email" class="input_Pass"> 
		 Nuova password: <input type="text" name="pass" class="input_Pass"> <br>
		<input type="submit" class="US_sub" value="invio"></strong>  </p>
	</form>

	
	 <%@ include file="footer.jsp"%>

</body>
</html>