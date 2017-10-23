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
		<%@ include file="infoUtenti.jsp"%>
		
		  <form action="viewBiglietto" method="post">
	<h2> BIGLIETTI ACQUISTATI</h2>
   	   <h3> Premi invio per visualizzare i biglietti acquistati</h3><input type="submit" value="invio">
   
       <% ArrayList<Biglietto> bigliettoAcquistato = (ArrayList<Biglietto>) session.getAttribute("biglietto");%> 
      <% if(bigliettoAcquistato !=null){
    	   for(Biglietto v : bigliettoAcquistato){
            out.print(v + "<br>");
    	   } } %>
     <% ArrayList<Volo> voloAcquistato = (ArrayList<Volo>) session.getAttribute("voloCliente"); 
   		  if(voloAcquistato !=null){    
     		for(Volo v : voloAcquistato){
            out.print(v + "<br>");
     		} }%>
     		
     		<!-- in questo caso confronto se la variabile settata in session
     		in viewBiglietto è false, se in questo caso lo è significa che non ci sono voli -->
 
   <% String variabileNulla = (String) session.getAttribute("variabileNulla"); 
   		 if(variabileNulla=="false"){
              out.print(" <br> <br>  Non ci sono voli da visualizzare");
   		 } %>
		</form>
	

		 
	 <%@ include file="footer.jsp"%>
</body>
</html>