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
		
		<%@ include file="infoUtenti.jsp"%>
	
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
        	  for(Volo v : volo){
          
            out.print(v + "<br>");
        } }%>
		</form>
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