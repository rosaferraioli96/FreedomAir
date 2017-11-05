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
	 <%String variabileCarr= (String) session.getAttribute("cancellaCarr"); %>
       <%if(variabileCarr == null){%>

	<form action="ViewCarrello" method="post">
	<h2> I voli aggiunti al carrello sono: </h2>
	 <input type="submit" name="invio">
	  <% ArrayList<Volo> volo = (ArrayList<Volo>) session.getAttribute("carrello"); 
          if(volo !=null){
        	  for(Volo v : volo){%>
     <b> Codice Identificativo del volo: <%=v.getCodice_id()%> , </b>
   	<b> Luogo Partenza: <%=v.getLuogo_partenza()%> ,</b>
	<b> Data Partenza:<%=v.getData_partenza() %>, </b>
	<b> Ora Partenza:<%=v.getOra_partenza()%>, </b>
	<b> Luogo Arrivo: <%=v.getLuogo_arrivo()%>, </b>
	<b> Data Arrivo:<%=v.getData_arrivo()%>, </b>
	<b> Ora Arrivo <%=v.getOra_arrivo() %> .</b>
	<b> Costo: <%=v.getCosto() %> .  </b>
          <br>
       </form>     
   <a href="acquistoBiglietto.jsp"> Clicca qui per acquistare il biglietto</a>
   <form action="EliminaCarrello" method="post">
   <input type="hidden" value="<%=v.getCodice_id() %>" name="codice_id">
   <input type="image" src="immagini/icone/carrello.jpg"  value="eliminaCarrello" width="100" height="30"> 
   </form>

       <%  }} %>
      <%}else{ 
	  
	  variabileCarr="true"; 
	  if(variabileCarr.equals("true")){ %>
		  <form action="ViewCarrello" method="post">
		  <input type="submit" name="invio">
		  <% ArrayList<Volo> volo = (ArrayList<Volo>) session.getAttribute("carrello"); 
	          if(volo !=null){
	        	  for(Volo v : volo){%>
	     <b> Codice Identificativo del volo: <%=v.getCodice_id()%> , </b>
	   	<b> Luogo Partenza: <%=v.getLuogo_partenza()%> ,</b>
		<b> Data Partenza:<%=v.getData_partenza() %>, </b>
		<b> Ora Partenza:<%=v.getOra_partenza()%>, </b>
		<b> Luogo Arrivo: <%=v.getLuogo_arrivo()%>, </b>
		<b> Data Arrivo:<%=v.getData_arrivo()%>, </b>
		<b> Ora Arrivo <%=v.getOra_arrivo() %> .</b>
		<b> Costo: <%=v.getCosto() %> .  </b>
	          <br>
	       </form>  
	 <a href="acquistoBiglietto.jsp"> Clicca qui per acquistare il biglietto</a>
   <form action="EliminaCarrello" method="post">
   <input type="hidden" value="<%=v.getCodice_id() %>" name="codice_id">
   <input type="image" src="immagini/icone/carrello.jpg"  value="eliminaCarrello" width="100" height="30"> 
   </form> 
	<% }}} %>
	 <%}%>


	
	 <%@ include file="footer.jsp"%>

</body>
</html>