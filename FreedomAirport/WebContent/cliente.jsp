<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@ page import="java.util.*, entita.Biglietto" %> 
                <%@ page import="java.util.*, entita.Volo" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/general.css" type="text/css"
	media="all">
<link rel="stylesheet" href="css/nav.css" type="text/css" media="all">
<link rel="stylesheet" href="css/login.css" type="text/css" media="all">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Cliente </title>
</head>
<body>
 		<%@ include file="header.jsp"%>	
		  <h1>Info Utente</h1>
	   <!-- Visualizza nome-->
	    <% String nomeAdmin = (String) session.getAttribute("nomeUtente"); %>   
   Nome: <%= nomeAdmin %>      
	  <br>
	    <!-- Form che serve alla modifica dei dati utenti-->
		  <form action="ModificaDatiUtenti" method="post">
			Nuovo Nome <input type="text" name="nomeUtente"> 
		
						<input type="submit" value="invio">
		 </form>
		 <br> 
		 <br>

  	<!-- Visualizza Cognome-->
 	 <% String cognomeAdmin = (String) session.getAttribute("cognomeUtente");%>
   	 Cognome:   <%= cognomeAdmin %>
  			<br>
  	 	  	<form action="ModificaDatiUtenti" method="post">
			Nuovo Cognome: <input type="text" name="cognomeUtente"> 
							<input type="submit" value="invio">
			</form>
		 	<br> 
		 	<br>
  
    <!--  Visualizza Password-->
    <% String passwordUtente = (String) session.getAttribute("passwordUtente");%>
  	Password:	 <%= passwordUtente %> 
	 <br>
	 <form action="ModificaDatiUtenti" method="post">
			Nuova Password: <input type="text" name="password"> 
							<input type="submit" value="invio">
			</form>
		 	<br> 
		 	<br>
	 
	 <!--  Visualizza Codice Fiscale-->
    <% String codiceFiscale = (String) session.getAttribute("codiceFiscale");%>
  	Codice Fiscale: <%= codiceFiscale %> 
	 
	 	 <br>
	 	  <form action="ModificaDatiUtenti" method="post">
			Nuovo Codice Fiscale: <input type="text" name="codiceFiscale"> 
							<input type="submit" value="invio">
			</form>
		 	<br> 
		 	<br>
	 
	 <!--  Visualizza Carta Identita-->
    <% String cartaIdentita = (String) session.getAttribute("cartaIdentita");%>
  	Carta Identita: <%= cartaIdentita %> 
	 	 	 
	 	 <br>
	 	  <form action="ModificaDatiUtenti" method="post">
			Nuova Carta Identità: <input type="text" name="cartaIdentita"> 
							<input type="submit" value="invio">
			</form>
		 	<br> 
		 	<br>
	 	 
	 <!--  Visualizza passaporto-->
    <% String passaporto = (String) session.getAttribute("passaporto");%>
 		 Passaporto: <%= passaporto %> 
  	
  		 <br>
	 	  <form action="ModificaDatiUtenti" method="post">
			Nuovo Passaporto: <input type="text" name="passaporto"> 
							<input type="submit" value="invio">
			</form>
		 	<br> 
		 	<br>
  	 	 
	 <!--  Visualizza Email-->
    <% String email = (String) session.getAttribute("email");%>
 		 Email: <%= email %> 
 		  	 <br>
 		  <form action="ModificaDatiUtenti" method="post">
			Nuova Email: <input type="text" name="email"> 
							<input type="submit" value="invio">
			</form>
		 	<br> 
		 	<br>
 		  <!--  Visualizza numero_telefono-->
    <% String numero_telefono = (String) session.getAttribute("numero_telefono");%>
 		 Numero Telefono: <%= numero_telefono %> 
 		  <br>
 		  <form action="ModificaDatiUtenti" method="post">
			Nuovo Telefono: <input type="text" name="numero_telefono"> 
							<input type="submit" value="invio">
			</form>
		 	<br> 
		 	<br>
		 
   <% String variabileNulla = (String) session.getAttribute("variabileNulla"); 
   		 if(variabileNulla=="false"){%>
   		 <h2> BIGLIETTI ACQUISTATI</h2>
              <h1>Non ci sono voli da visualizzare </h1>
   		<% } else{%>
		  <form action="viewBiglietto" method="post">
	<h2> BIGLIETTI ACQUISTATI</h2>
   	   <h3> Premi invio per visualizzare i biglietti acquistati</h3>
   	   <input type="submit" value="invio">
   
       <% ArrayList<Biglietto> bigliettoAcquistato = (ArrayList<Biglietto>) session.getAttribute("biglietto");%> 
      <% if(bigliettoAcquistato !=null){
    	   for(Biglietto v : bigliettoAcquistato){%>
            <b> Intestatario: <%=v.getIntestatario()%> ,</b>
	<b> Numero Posto :<%=v.getNumero_posto() %>. </b><br>
    	<%    } } %>
    	<br><br>
     <% ArrayList<Volo> voloAcquistato = (ArrayList<Volo>) session.getAttribute("voloCliente"); 
   		  if(voloAcquistato !=null){    
     		for(Volo v : voloAcquistato){%>
     			<b> Luogo Partenza: <%=v.getLuogo_partenza()%> ,</b>
     			<b> Data Partenza:<%=v.getData_partenza() %>, </b>
     			<b> Ora Partenza:<%=v.getOra_partenza()%>, </b>
     			<b> Luogo Arrivo: <%=v.getLuogo_arrivo()%>, </b>
     			<b> Data Arrivo:<%=v.getData_arrivo()%>, </b>
     			<b> Ora Arrivo <%=v.getOra_arrivo() %> . </b>
     				<b> Costo: <%=v.getCosto() %> .  </b>
     	 <% 	} }%>
     		
     		<!-- in questo caso confronto se la variabile settata in session
     		in viewBiglietto è false, se in questo caso lo è significa che non ci sono voli -->

		</form>
	
<% } %>
		 
	 <%@ include file="footer.jsp"%>
</body>
</html>