<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@ page import="java.util.*, entita.Biglietto" %> 
                <%@ page import="java.util.*, entita.Volo" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/cliente.css" type="text/css" media="all">
<link rel="stylesheet" href="css/general.css" type="text/css" media="all">
<link rel="stylesheet" href="css/login.css" type="text/css" media="all">
<link rel="stylesheet" href="css/nav.css" type="text/css" media="all">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title> Cliente </title>
</head>
<body>
 		<%@ include file="header.jsp"%>	
 		
 		
 		<section class="menu_cliente">



	<button class="accordion">Info Utente</button>

	<!-- Pannello -->
	<div class="panel">
		<table class="myTable tabIns">

			<!-- Visualizza nome-->
			<%
				String nomeAdmin = (String) session.getAttribute("nomeUtente");
			%>
			<tr>
				<td></td>
				<td class="AD_text top">Nome: <%=nomeAdmin%></td>
			</tr>

			<!-- Form che serve alla modifica dei dati utenti-->
			<form action="ModificaDatiUtenti" method="post">
				<tr class="insert">
					<td class="AD_text">Nuovo Nome:</td>
					<td class="US_input"><input type="text" name="nomeUtente"></td>
					<td class="padd"><input type="submit" value="invio"
						class="but_click"></td>
				</tr>
			</form>

			<!-- Visualizza Cognome-->
			<%
				String cognomeAdmin = (String) session.getAttribute("cognomeUtente");
			%>
			<tr>
				<td></td>
				<td class="AD_text top">Cognome: <%=cognomeAdmin%>
				</td>
			</tr>

			<!-- Form che serve alla modifica dei dati utenti-->
			<form action="ModificaDatiUtenti" method="post">
				<tr class="insert">
					<td class="AD_text">Nuovo Cognome:</td>
					<td class="US_input"><input type="text" name="cognomeUtente">
					</td>
					<td class="padd"><input type="submit" value="invio"
						class="but_click"></td>
				</tr>
			</form>

			<!--  Visualizza Password-->
			<%
				String passwordUtente = (String) session.getAttribute("passwordUtente");
			%>
			<tr>
				<td></td>
				<td class="AD_text top">Password: ***********</td>
				<%-- <%= passwordUtente %> --%>
			</tr>

			<!-- Form che serve alla modifica dei dati utenti-->
			<form action="ModificaDatiUtenti" method="post">
				<tr class="insert">
					<td class="AD_text">Nuova Password:</td>
					<td class="US_input"><input type="text" name="password">
					</td>
					<td class="padd"><input type="submit" value="invio"
						class="but_click"></td>
				</tr>
			</form>


			<!--  Visualizza Codice Fiscale
			
				String codiceFiscale = (String) session.getAttribute("codiceFiscale");
			
			<tr>
				<td></td>
				<td class="AD_text top">Codice Fiscale: codiceFiscale%></td>
			</tr>

			<!-- Form che serve alla modifica dei dati utenti
			<form action="ModificaDatiUtenti" method="post">
				<tr class="insert">
					<td class="AD_text">Nuovo Codice Fiscale:</td>
					<td class="US_input"><input type="text" name="codiceFiscale"></td>
					<td class="padd"><input type="submit" value="invio"
						class="but_click"></td>
				</tr>
			</form>



			<!--  Visualizza Carta Identita
			<%
				String cartaIdentita = (String) session.getAttribute("cartaIdentita");
			%>
			<tr>
				<td></td>
				<td class="AD_text top">Carta Identita: <%=cartaIdentita%></td>
			</tr>

			<!-- Form che serve alla modifica dei dati utenti
			<form action="ModificaDatiUtenti" method="post">
				<tr class="insert">
					<td class="AD_text">Nuova Carta Identità:</td>
					<td class="US_input"><input type="text" name="cartaIdentita">
					</td>
					<td class="padd"><input type="submit" value="invio"
						class="but_click"></td>
				</tr>
			</form>



			<!--  Visualizza passaporto
			<%
				String passaporto = (String) session.getAttribute("passaporto");
			%>
			<tr>
				<td></td>
				<td class="AD_text top">Passaporto: <%=passaporto%></td>
			</tr>

			<!-- Form che serve alla modifica dei dati utenti
			<form action="ModificaDatiUtenti" method="post">
				<tr class="insert">
					<td class="AD_text">Nuovo Passaporto:</td>
					<td class="US_input"><input type="text" name="passaporto">
					</td>
					<td class="padd"><input type="submit" value="invio"
						class="but_click"></td>
				</tr>
			</form>


-->
			<!--  Visualizza Email-->
			<%
				String email = (String) session.getAttribute("email");
			%>
			<tr>
				<td></td>
				<td class="AD_text top">Email: <%=email%></td>
			</tr>

			<!-- Form che serve alla modifica dei dati utenti-->
			<form action="ModificaDatiUtenti" method="post">
				<tr class="insert">
					<td class="AD_text">Nuova Email:</td>
					<td class="US_input"><input type="text" name="email">
					</td>
					<td class="padd"><input type="submit" value="invio" class="but_click"></td>
				</tr>
			</form>


			<!--  Visualizza numero_telefono
			<%
				String numero_telefono = (String) session.getAttribute("numero_telefono");
			%>
			<tr>
				<td></td>
				<td class="AD_text top">Numero Telefono: <%=numero_telefono%></td>
			</tr>

			<!-- Form che serve alla modifica dei dati utenti
			<form action="ModificaDatiUtenti" method="post">
				<tr class="insert">
					<td class="AD_text">Nuovo Telefono:</td>
					<td class="US_input"><input type="text" name="numero_telefono">
					</td>
					<td class="padd"><input type="submit" value="invio" class="but_click"></td>
				</tr>
			</form>
-->
		</table>

	</div>	<!-- end div panel--> 



<button class="accordion">Biglietti acquistati</button>

<!-- Pannello -->
	<div class="panel pa_bigl">
	
	<div style="overflow-x:auto;">	
	 
		

			 
   <% String variabileNulla = (String) session.getAttribute("variabileNulla"); 
   		 if(variabileNulla=="false"){%>
               <h1 class="tit_mod red">Non ci sono voli da visualizzare </h1>
   		<% } else{%>
		  <form action="viewBiglietto" method="post">
   	    <h3 class="tit_mod"> Premi invio per visualizzare i biglietti acquistati</h3>
   	   
   	   <input type="submit" value="invio" class="but_click">
   
 
     <% ArrayList<Volo> voloAcquistato = (ArrayList<Volo>) session.getAttribute("voloCliente"); 
   		  if(voloAcquistato !=null){    
     		for(Volo v : voloAcquistato){%>
				<table class="tab_biglietti">
				
				<tr class="intest colore1">
						
						<td class="bi_log"><img src="immagini/logo_pegaso.png" alt="Logo" id="log"></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
							<td></td>
					</tr>
					
					<tr class="intest colore2">
						
						<td></td>
						<td class="inte"><strong> Intestatario:</strong> </td>
						<td><%=v.getIntestatario()%></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
							<td></td>
					</tr>

					<tr class="intest colore3">
						<td> </td>
						<td class="inte"><strong> Numero Posto:</strong> </td>
						<td><%=v.getNumero_posto()%></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>

					<tr>
						<td class="bi_volo"><b>Volo</b></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					
					<tr class="bigl">
					    <td></td>
						<td><strong>Luogo Partenza:</strong></td> 
						<td><strong>Data Partenza:</strong></td>
						<td><strong>Ora Partenza:</strong></td>
						<td><strong>Luogo Arrivo:</strong> </td>
						<td><strong>Data Arrivo   :</strong></td>
						<td><strong>Ora Arrivo:</strong></td> 
						<td><strong>Costo:</strong></td>
					</tr>
					
					<tr class="int_valori">	
						<td></td>
						<td><%=v.getLuogo_partenza()%></td>
						<td><%=v.getData_partenza()%></td>
						<td><%=v.getOra_partenza()%></td>
						<td><%=v.getLuogo_arrivo()%></td>
						<td><%=v.getData_arrivo()%></td>
						<td><%=v.getOra_arrivo()%></td>
						<td><%=v.getCosto()%></td>
					</tr>
					
				</table>
				<%
					}
						}
				%>

				<!-- in questo caso confronto se la variabile settata in session
     		in viewBiglietto è false, se in questo caso lo è significa che non ci sono voli -->

		</form>
	
<% } %>
	
	
	  		</div>
	</div>
	


		 </section>
		 
		 
</body>

<%@ include file="footer.jsp"%>	
<script>
	var acc = document.getElementsByClassName("accordion");
	var i;

	for (i = 0; i < acc.length; i++) {
		acc[i].onclick = function() {
			this.classList.toggle("active");
			var panel = this.nextElementSibling;
			if (panel.style.display === "block") {
				panel.style.display = "none";
			} else {
				panel.style.display = "block";
			}
		}
	}
</script>


</html>
