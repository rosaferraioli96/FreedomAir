<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, entita.Volo" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/general.css" type="text/css"
	media="all">
<link rel="stylesheet" href="css/nav.css" type="text/css" media="all">
<link rel="stylesheet" href="css/login.css" type="text/css" media="all">

<title>Carrello</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<h2> I voli aggiunti al carrello sono: </h2>
	  <% ArrayList<Volo> volo = (ArrayList<Volo>) session.getAttribute("carrello"); 
          if(volo !=null){
        	  for(Volo v : volo){%>
   	<b> Luogo Partenza: <%=v.getLuogo_partenza()%> ,</b>
	<b> Data Partenza:<%=v.getData_partenza() %>, </b>
	<b> Ora Partenza:<%=v.getOra_partenza()%>, </b>
	<b> Luogo Arrivo: <%=v.getLuogo_arrivo()%>, </b>
	<b> Data Arrivo:<%=v.getData_arrivo()%>, </b>
	<b> Ora Arrivo <%=v.getOra_arrivo() %> .</b>
          <br>
       <%  }} %>

	
	 <%@ include file="footer.jsp"%>

</body>
</html>