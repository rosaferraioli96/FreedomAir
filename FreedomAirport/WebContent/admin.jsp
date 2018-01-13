<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, entita.Volo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/admin.css" type="text/css" media="all">
<link rel="stylesheet" href="css/general.css" type="text/css"
	media="all">
<link rel="stylesheet" href="css/login.css" type="text/css" media="all">



<title>Amministratore</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<section class="menu_admin">

	<!-- Inserimento nuovo volo -->
	<button class="accordion">Inserimento Nuovo Volo</button>

	<!-- Pannello -->
	<div class="panel">
		<table class="myTable tabIns">

			<form action="InsertVolo" method="post" id="InsertVolo">


				<tr class="insert">
					<td class="AD_text col1">Codice ID volo:</td>
					<td class="US_input col2"><input type="text" class="ins_ID"
						placeholder="Codice ID" name="codice_id" id="cod_id" required maxlength="10"></td>
				</tr>

				<tr class="insert">
					<td class="AD_text col1">Luogo partenza:</td>
					<td class="US_input col2"><input type="text" class="ins_LP"
						placeholder="Luogo partenza" name="luogo_partenza" id="luogo_p" required maxlength="30"></td>
				</tr>

				<tr class="insert">
					<td class="AD_text col1" >Data partenza:</td>
					<td class="US_input col2"><input type="date" class="ins_ID  inputCalendar"
						placeholder="2017-09-30" name="data_partenza" id="data_p" value="2017-11-10"
								onblur="if(this.value=='') this.value='2017-11-10'"
								onFocus="if(this.value =='2017-11-10' ) this.value=''" required></td>
				</tr>


				<tr class="insert">
					<td class="AD_text col1">Ora partenza:</td>
					<td class="US_input col2"><input type="text" class="ins_ID"
						placeholder="10:20:00" name="ora_partenza" id="ora_p" required maxlength="30"></td>
				</tr>

				<tr class="insert">
					<td class="AD_text col1">Luogo arrivo:</td>
					<td class="US_input col2"><input type="text" class="ins_LA"
						placeholder="Luogo arrivo" name="luogo_arrivo" id="luogo_a" required maxlength="30">
					</td>
				</tr>

				<tr class="insert">
					<td class="AD_text col1">Data arrivo:</td>
					<td class="US_input col2"><input type="date" class="ins_ID inputCalendar"
						placeholder="2017-09-30" name="data_arrivo" id="data_a" value="2017-11-10"
								onblur="if(this.value=='') this.value='2017-11-10'"
								onFocus="if(this.value =='2017-11-10' ) this.value=''" required></td>
				</tr>

				<tr class="insert">
					<td class="AD_text col1">Ora arrivo:</td>
					<td class="US_input col2"><input type="text" class="ins_ID"
						placeholder="10:20:00" name="ora_arrivo" id="ora_a" required maxlength="30"> </td>
				</tr>

				<tr class="insert">
					<td class="AD_text col1">Costo:</td>
					<td class="US_input col2"><input type="text" class="ins_costo"
						name="costo" id="costo"></td>
					<td class="col3 basso_dest"><input type="submit" value="invio"
						id="submit_insVolo" class="US_sub basso_dest" required maxlength="10"></td>
				</tr>
			</form>

</table>
	</div><!-- end div panel-->
	
<%-- 
	 <!-- VISUALIZZA VOLO -->
	<button class="accordion">Voli Disponibili</button>


	<!-- Pannello -->
	<div class="panel">
		
	
		<form action="viewVolo" method="post">


			<h3>Premi invio per visualizzare i voli</h3>

			<input type="submit" value="invio" class="US_sub">

			<%
				ArrayList<Volo> volo = (ArrayList<Volo>) session.getAttribute("volo");
				if (volo != null) {
					for (Volo v : volo) {
			%>

			<b> Codice Identificativo del volo: <%=v.getCodice_id()%></b> <b>
				Luogo Partenza: <%=v.getLuogo_partenza()%> ,
			</b> <b> Data Partenza:<%=v.getData_partenza()%>,
			</b> <b> Ora Partenza:<%=v.getOra_partenza()%>,
			</b> <b> Luogo Arrivo: <%=v.getLuogo_arrivo()%>,
			</b> <b> Data Arrivo:<%=v.getData_arrivo()%>,
			</b> <b> Ora Arrivo <%=v.getOra_arrivo()%> .
			</b> <b> Costo: <%=v.getCosto()%> .
			</b> <br>
			<%
				}
				}
			%>

		</form>
	</div>
 --%>

	<!-- Pannello -->
	 <!-- VISUALIZZA VOLO -->
	<button class="accordion">Voli Disponibili</button>


	<!-- Pannello -->
	<div class="panel vedi">
	
	<div style="overflow-x:auto;">	
	<table class="VediV"> 
		<form action="viewVolo" method="post">


				<tr>
					<th>Codice ID</th>
					<th>Luogo partenza</th>
					<th>Data partenza</th>
					<th>Ora partenza</th>
					<th>Luogo arrivo</th>
					<th>Data arrivo</th>
					<th>Ora arrivo</th>
					<th>Costo arrivo</th>
				</tr>
				<h3 class="tit_mod">Premi invio per visualizzare i voli</h3>

			<input type="submit" value="invio" class="US_sub">

			<%
				ArrayList<Volo> volo = (ArrayList<Volo>) session.getAttribute("volo");
				if (volo != null) {
					for (Volo v : volo) {
			%>

				<tr>
					<td id="codID"><%=v.getCodice_id()%></td>
					<td><%=v.getLuogo_partenza()%></td>
					<td><%=v.getData_partenza()%></td>
					<td><%=v.getOra_partenza()%></td>
					<td><%=v.getLuogo_arrivo()%></td>
					<td><%=v.getData_arrivo()%></td>
					<td><%=v.getOra_arrivo()%></td>
					<td><%=v.getCosto()%></td>
				</tr>
			
			<%
				}
				}
			%>

		</form>
		</table>
		</div>
	</div>

 

	<%@include file="ModificaVolo.jsp"%> 
	
	




	</section>



	<%@ include file="footer.jsp"%>
 <%String error= (String) session.getAttribute("error1");
     if(error== "false"){
 %>
    <H1 class="Titol">  L'inserimento non è andato a buon fine</H1>
		
<%} %>

       <% String variabileCostoVolo = (String) session.getAttribute("variabileCostoVolo"); 
         if(variabileCostoVolo == "false"){ %>
         <script>  alert("Carattere non valido per il costo");
         </script>
         
<%   session.setAttribute("variabileCostoVolo", "true");} %>

       <% String variabilePerCodiceVolo = (String) session.getAttribute("variabilePerCodiceVolo"); 
         if(variabilePerCodiceVolo == "false"){ %>
         <script>  alert("Codice Identificativo già utilizzato");
         </script>
         
<%   session.setAttribute("variabilePerCodiceVolo", "true");} %>

       <% String variabileCostoModifica = (String) session.getAttribute("variabileCostoModifica"); 
         if(variabileCostoModifica == "false"){ %>
         <script>  alert("Carattere non valido per il costo");
         </script>
         
<%   session.setAttribute("variabileCostoModifica", "true");} %>

  <% String variabilePerModificaVolo = (String) session.getAttribute("variabilePerModificaVolo"); 
         if(variabilePerModificaVolo == "false"){ %>
         <script>  alert("Codice Identificativo non presente nel nostro database");
         </script>
         
<%   session.setAttribute("variabilePerModificaVolo", "true");} %>

</body>

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
