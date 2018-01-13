<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, entita.Annunci"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/admin.css" type="text/css" media="all">
<link rel="stylesheet" href="css/general.css" type="text/css"
	media="all">
<link rel="stylesheet" href="css/login.css" type="text/css" media="all">

<title>Insert title here</title>
</head>
<body>
 <%@ include file="header.jsp"%>
<section class="menu_admin">
<button class="accordion">Visualizzazione Annunci</button>
<div class="panel vedi">
	
	<div style="overflow-x:auto;">	
	<table class="VediV"> 
		<form action="viewAnnunci" method="post">


				<tr>
					<th>Codice ID</th>
					<th>Luogo </th>
					<th>Tipo</th>
			
				</tr>
				<h3 class="tit_mod">Premi invio per visualizzare i voli</h3>

			<input type="submit" value="invio" class="US_sub">

			<%
				ArrayList<Annunci> annunci = (ArrayList<Annunci>) session.getAttribute("annunci");
				if (annunci != null) {
					for (Annunci v : annunci) {
			%>

				<tr>
					<td id="codID"><%=v.getCodice_id()%></td>
					<td><%=v.getluogo()%></td>
					<td><%=v.getTipo()%></td>
				
				</tr>
			
			<%
				}
				}
			%>

		</form>
		</table>
		</div>
	</div>
	
	<!-- CANCELLAZIONE VOLO -->

	<button class="accordion">Cancellazione Volo</button>

	<!-- Pannello -->
	<div class="panel">
		<table class="myTable tabIns">
		
		<form action="cancAnnunci" method="post">

           <tr class="insert">
					<td class="AD_text col1">Codice ID annunci:</td>
					<td class="US_input col2"><input type="text"
				class="ins_ID" placeholder="Codice ID" name="codice_id" id="cod_id"></td>
					<td class="col3 basso_dest"><input type="submit" value="invio"
						id="submit_insVolo" class="US_sub"></td>
				</tr>
		
		</form>
	</table>
	</div>
	<button class="accordion">Inserimento Nuovo Annuncio</button>

	<!-- Pannello -->
	<div class="panel">
		<table class="myTable tabIns">

			<form action="InsertAnnunci" method="post" id="InsertVolo">

				<tr class="insert">
					<td class="AD_text col1">Luogo :</td>
					<td class="US_input col2"><input type="text" class="ins_LP"
						placeholder="Luogo " name="luogo" id="luogo" maxlength="30" required></td>
				</tr>

				<tr class="insert">
					<td class="AD_text col1" >Tipo:</td>
					<td class="US_input col2"><input type="text" class="ins_LP"
						placeholder="Tipo" name="tipo" id="tipo"></td>
						<td class="col3 basso_dest"><input type="submit" value="invio"
						id="submit_insVolo" class="US_sub basso_dest" maxlength="30" required></td>	
				</tr>


			</form>

		</table>

	</div>
</section>
 <% String variabileCodiceIDAnnunci = (String) session.getAttribute("variabileCodiceIDAnnunci"); 
         if(variabileCodiceIDAnnunci == "false"){ %>
         <script>  alert("Carattere non validi per codice identificativo");
         
         </script>
         
<%   session.setAttribute("variabileCodiceIDAnnunci", "true");} %>
      
       <% String variabilePerAnnunci = (String) session.getAttribute("variabilePerAnnunci"); 
         if(variabilePerAnnunci == "false"){ %>
         <script>  alert("Codice Identificativo non presente nei nostri database");
         </script>
         
<% session.setAttribute("variabilePerAnnunci", "true");} %>

<%@ include file="footer.jsp"%>
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