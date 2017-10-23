<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, entita.Volo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/general.css" type="text/css"
	media="all">
<link rel="stylesheet" href="css/nav.css" type="text/css" media="all">
<link rel="stylesheet" href="css/login.css" type="text/css" media="all">
<title>Voli</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<br>
	<br>
		 <% String username= (String) session.getAttribute("name");
		 if(username != null ){
		  %>
	<% ArrayList<Volo> voloAndata = (ArrayList<Volo>) session.getAttribute("voloAndata"); 
        for(Volo v : voloAndata){
     %>

	<b> Luogo Partenza: <%=v.getLuogo_partenza()%> ,</b>
	<b> Data Partenza:<%=v.getData_partenza() %>, </b>
	<b> Ora Partenza:<%=v.getOra_partenza()%>, </b>
	<b> Luogo Arrivo: <%=v.getLuogo_arrivo()%>, </b>
	<b> Data Arrivo:<%=v.getData_arrivo()%>, </b>
	<b> Ora Arrivo <%=v.getOra_arrivo() %> . </b>
	
	<form action="InsertCarrello" method="post">
		<input type="hidden" name="codiceVolo" value="<%=v.getCodice_id()%>" />
		<input id="carrello" type="image" src="immagini/icone/carrello.jpg" width="100" height="30"> 
	</form>
	<%  } %>
<%  }else{ %>
	<% ArrayList<Volo> voloAndata = (ArrayList<Volo>) session.getAttribute("voloAndata"); 
        for(Volo v : voloAndata){
     %>
	<b> Luogo Partenza: <%=v.getLuogo_partenza()%> ,</b>
	<b> Data Partenza:<%=v.getData_partenza() %>, </b>
	<b> Ora Partenza:<%=v.getOra_partenza()%>, </b>
	<b> Luogo Arrivo: <%=v.getLuogo_arrivo()%>, </b>
	<b> Data Arrivo:<%=v.getData_arrivo()%>, </b>
	<b> Ora Arrivo <%=v.getOra_arrivo() %> . </b>
	<br>
<% } %>
     <%  } %>
		 
	<br>
	<br>
	 <% String username1= (String) session.getAttribute("name");
		 if(username1 != null ){
		  %>
	<% ArrayList<Volo> voloRitorno = (ArrayList<Volo>) session.getAttribute("voloRitorno"); 
  			  for(Volo v : voloRitorno){
  				  %>
	<b> Luogo Partenza: <%=v.getLuogo_partenza()%> ,</b>
	<b> Data Partenza:<%=v.getData_partenza() %>, </b>
	<b> Ora Partenza:<%=v.getOra_partenza()%>, </b>
	<b> Luogo Arrivo: <%=v.getLuogo_arrivo()%>, </b>
	<b> Data Arrivo:<%=v.getData_arrivo()%>, </b>
	<b> Ora Arrivo <%=v.getOra_arrivo() %> . </b>
		<br>
		<form action="InsertCarrello" method="post">
		<input type="hidden" name="codiceVoloRitorno" value="<%=v.getCodice_id()%>" />
		<input id="carrello" type="image" src="immagini/icone/carrello.jpg" width="100" height="30"> 
	</form>
	<%  } %>
<%  }else{ %>
	<% ArrayList<Volo> voloAndata = (ArrayList<Volo>) session.getAttribute("voloAndata"); 
        for(Volo v : voloAndata){
     %>
	<b> Luogo Partenza: <%=v.getLuogo_partenza()%> ,</b>
	<b> Data Partenza:<%=v.getData_partenza() %>, </b>
	<b> Ora Partenza:<%=v.getOra_partenza()%>, </b>
	<b> Luogo Arrivo: <%=v.getLuogo_arrivo()%>, </b>
	<b> Data Arrivo:<%=v.getData_arrivo()%>, </b>
	<b> Ora Arrivo <%=v.getOra_arrivo() %> . </b>
	<br>
<% } %>
     <%  } %>

	<%@ include file="footer.jsp"%>
</body>
</html>