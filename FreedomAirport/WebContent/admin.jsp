<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ page import="java.util.*, entita.Volo" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link rel="stylesheet" href="css/general.css" type="text/css"
	media="all">
<link rel="stylesheet" href="css/nav.css" type="text/css" media="all">
<link rel="stylesheet" href="css/login.css" type="text/css" media="all">

<title>Amministratore</title>
</head>
<body>
		<%@ include file="header.jsp"%>
	
 <h1>Info Utente</h1>

	   <!-- Visualizza nome-->
	    <% String nomeAdmin = (String) session.getAttribute("nomeUtente"); %>   
   Nome: <%= nomeAdmin %>    
	 
	    <!-- Form che serve alla modifica dei dati utenti-->
		  <form action="ModificaDatiAdmin" method="post">
			 Nuovo Nome <input type="text" name="nomeUtente"> 
		
						<input type="submit" value="invio">
		 </form>
		
  	<!-- Visualizza Cognome-->
 	 <% String cognomeAdmin = (String) session.getAttribute("cognomeUtente");%>
      Cognome:   <%= cognomeAdmin %>
  		
  	 	  	<form action="ModificaDatiAdmin" method="post">
			Nuovo Cognome: <input type="text" name="cognomeUtente"> 
							<input type="submit" value="invio">
			</form>
		 	

    <!--  Visualizza Password-->
    <% String passwordUtente = (String) session.getAttribute("passwordUtente");%>
  	Password:	 <%= passwordUtente %> 
	 <br>
	 <form action="ModificaDatiAdmin" method="post">
			Nuova Password: <input type="text" name="password"> 
							<input type="submit" value="invio">
			</form>
		 	<br> 
		 	<br>
	 
	 <!--  Visualizza Codice Fiscale-->
    <% String codiceFiscale = (String) session.getAttribute("codiceFiscale");%>
  	Codice Fiscale: <%= codiceFiscale %> 
	 
	 	 <br>
	 	  <form action="ModificaDatiAdmin" method="post">
			Nuovo Codice Fiscale: <input type="text" name="codiceFiscale"> 
							<input type="submit" value="invio">
			</form>
		 	<br> 
		 	<br>
	 
	 <!--  Visualizza Carta Identita-->
    <% String cartaIdentita = (String) session.getAttribute("cartaIdentita");%>
  	Carta Identita: <%= cartaIdentita %> 
	 	 	 
	 	 <br>
	 	  <form action="ModificaDatiAdmin" method="post">
			Nuova Carta Identità: <input type="text" name="cartaIdentita"> 
							<input type="submit" value="invio">
			</form>
		 	<br> 
		 	<br>
	 	 
	 <!--  Visualizza passaporto-->
    <% String passaporto = (String) session.getAttribute("passaporto");%>
 		 Passaporto: <%= passaporto %> 
  	
  		 <br>
	 	  <form action="ModificaDatiAdmin" method="post">
			Nuovo Passaporto: <input type="text" name="passaporto"> 
							<input type="submit" value="invio">
			</form>
		 	<br> 
		 	<br>
  	 	 
	 <!--  Visualizza Email-->
    <% String email = (String) session.getAttribute("email");%>
 		 Email: <%= email %> 
 		  	 <br>
 		  <form action="ModificaDatiAdmin" method="post">
			Nuova Email: <input type="text" name="email"> 
							<input type="submit" value="invio">
			</form>
		 	<br> 
		 	<br>
 		  <!--  Visualizza numero_telefono-->
    <% String numero_telefono = (String) session.getAttribute("numero_telefono");%>
 		 Numero Telefono: <%= numero_telefono %> 
 		  <br>
 		  <form action="ModificaDatiAdmin" method="post">
			Nuovo Telefono: <input type="text" name="numero_telefono"> 
							<input type="submit" value="invio">
			</form>
		 	<br> 
		 	<br>
	
  <form action="InsertVolo" method="post">
  <h1>Inserimento Nuovo Volo</h1>
   
   <label><b>Codice ID volo</b></label> 
   <input type="text" class="ins_ID" placeholder="Codice ID" name="codice_id" id="cod_id">
   <br>
   <label><b>Luogo partenza</b></label> 
   <input type="text" class="ins_LP" placeholder="Luogo partenza" name="luogo_partenza" id="luogo_p"> 
   <br>
   <label><b>Data partenza</b></label> 
   <input type="text" class="ins_ID" placeholder="2017-09-30" name="data_partenza" id="data_p">
   <br>
   <label><b>Ora partenza</b></label> 
   <input type="text" class="ins_ID" placeholder="10:20:00" name="ora_partenza" id="ora_p">
   <br>
   <label><b>Luogo arrivo</b></label>
   <input type="text" class="ins_LA" placeholder="Luogo arrivo" name="luogo_arrivo" id="luogo_a"> 
   <br>
   <label><b>Data arrivo</b></label> 
   <input type="text" class="ins_ID" placeholder="2017-09-30" name="data_arrivo" id="data_a">
   <br>
   <label><b>Ora arrivo</b></label> 
   <input type="text" class="ins_ID" placeholder="10:20:00" name="ora_arrivo" id="ora_a">
   <br>
   <label><b>Costo</b></label> 
   <input type="text" class="ins_costo"  name="costo" id="costo">
    
    <input type="submit" value="invio" id="submit_insVolo">
  </form>
  
  </section>

   <!-- VISUALIZZA VOLO -->
   <form action="viewVolo" method="post">
	 <h1>Voli Disponibili</h1>
   	   <h3> Premi invio per visualizzare i voli</h3>
   
        <input type="submit" value="invio">

	    <% ArrayList<Volo> volo = (ArrayList<Volo>) session.getAttribute("volo"); 
          if(volo !=null){
        	  for(Volo v : volo){ %>
          
        		  <b> Codice Identificativo del volo: <%=v.getCodice_id()%></b>
        			<b> Luogo Partenza: <%=v.getLuogo_partenza()%> ,</b>
        			<b> Data Partenza:<%=v.getData_partenza() %>, </b>
        			<b> Ora Partenza:<%=v.getOra_partenza()%>, </b>
        			<b> Luogo Arrivo: <%=v.getLuogo_arrivo()%>, </b>
        			<b> Data Arrivo:<%=v.getData_arrivo()%>, </b>
        			<b> Ora Arrivo <%=v.getOra_arrivo() %> . </b>
        				<b> Costo: <%=v.getCosto() %> .  </b>
        				<br>
      <%  } }%>
		</form>
		
		  
 <%@include file="ModificaVolo.jsp" %>
	 <section>  
	 
	 
	  <!-- CANCELLAZIONE VOLO -->
  <form action="CancVolo" method="post">
 <h1> Cancellazione Volo</h1>
   
   <label><b>Codice ID volo</b></label> 
   <input type="text" class="ins_ID" placeholder="Codice ID" name="codice_id" id="cod_id">
   <br>
    <input type="submit" value="invio" id="submit_insVolo">
  </form>
  
  </section>

	 
	 
	 <%@ include file="footer.jsp"%>


</body>
</html>