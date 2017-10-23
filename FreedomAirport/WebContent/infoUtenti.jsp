<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
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

</body>
</html>