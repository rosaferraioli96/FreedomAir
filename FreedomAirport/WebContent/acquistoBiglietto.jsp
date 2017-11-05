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
<title>Acquisto Biglietto</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<% String variabile = (String) session.getAttribute("prova");
	   if(variabile == null){ %>
		   
	   
	
<h1> I voli che stai per acquistare</h1>

      <form action="AcquistoBiglietto" method="post">
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
           <%  }} %>
           <br>
           <br>
       Inserisci il codice id del volo : <input type="text" name="codice_id" /> <br> <br>
       Inserisci l'intestatario del biglietto   <input type="text" name="nome_intestatario" />  <br> <br>
         
       Inserisci il tipo della carta:  <select name="tipo_carta" id="tipo_carta"> <br> <br>
				<option value="MasterCard">Master Card</option>
				<option value="Visa">Visa</option>
				<option value="Postepay">Postepay </option>
				<option value="Paypal">Paypal</option>
			
			</select> <br><br>
		Inserisci il numero della carta  <input type="text" name="numero_carta" /><br><br>
		Inserisci il nominativo dell'intestatario della carta  <input type="text" name="nominativo" /> <br><br>
		Inserisci la validità della carta  <input type="text" name="validità" /><br><br>
         
          <% Random r= new Random();
          int posto= r.nextInt(150);%><br><br>
          <input type="hidden" name="numero_posto" value="<%=posto %>" />

		
		<input id="carrello" type="submit" value="invio"> 

	</form>
	<%}else{ %>
	
	  <H1> il tuo volo è stato acquistato correttamente</H1>
	<%} %>
		 <%@ include file="footer.jsp"%>
</body>
</html>