<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica volo</title>
</head>
<body>

<!--   <form action="ModVolo" method="post"> -->
  <h1>Modifica Volo</h1>
   
   <h3>Inviare prima il codice ID e poi inserire il dato da modificare</h3>
    	

    <form action="ModVolo" method="post">
     <% String codice_id = (String) session.getAttribute("codice_id"); 
     if(codice_id != null){
   %>
           il codice che hai inserito è <%=codice_id %><br><br>
          Inserisci  codice id per cambiare<input type="text" class="ins_ID" placeholder="codice_ID" name="codice_id" id="codice_id	">  
        <input type="submit" value="invio">
	 <%}else{ %> 
	  Inserisci  codice id<input type="text" class="ins_ID" placeholder="codice_ID" name="codice_id" id="codice_id	">  
        <input type="submit" value="invio">
        <%} %>
       </form>
	 
	 <%String errore= (String) session.getAttribute("errore"); 
       if(errore == "false"){
        %>
   <h1> Codice Id non valido</h1>
     
       <%}else{ %>
      <br>
      <br>
       <!-- Visualizza Luogo partenza-->
       
        <form action="ModVolo" method="post">
  
       	  <input type="hidden" value="<%=codice_id %>" name="codice_id">
          Nuovo luogo partenza <input type="text" class="ins_LP" placeholder="Luogo partenza" name="luogo_partenza" id="luogo_partenza"> 
   
          <input type="submit" value="invio">
 
       </form>
	  	   <br>
	  	   <br>
     <!-- Visualizza Data partenza-->
     <form action="ModVolo" method="post">

	  <input type="hidden" value="<%=codice_id %>" name="codice_id">
   Nuova data partenza  <input type="text" class="ins_ID" placeholder="2017-09-30" name="data_partenza" id="data_p">
		
      <input type="submit" value="invio">
       <br>
	  	   
      </form> 
	  	   
	  	   <br>
     <!-- Visualizza Ora partenza-->
     <form action="ModVolo" method="post">
       
	 <input type="hidden" value="<%=codice_id %>" name="codice_id">
   Nuovo orario partenza  <input type="text" class="ins_ID" placeholder="10:20:00" name="ora_partenza" id="ora_p">
		
      <input type="submit" value="invio">
    
       </form>
	  	   
     <!-- Visualizza Luogo arrivo-->
     <br>
        <br>
	  	  
     <form action="ModVolo" method="post">
       
	  <input type="hidden" value="<%=codice_id %>" name="codice_id">
   Nuovo luogo arrivo <input type="text" class="ins_LA" placeholder="Luogo arrivo" name="luogo_arrivo" id="luogo_a"> 
		
      <input type="submit" value="invio">

       
     </form>
	  	 <br>
	  	     <br>
       <!-- Visualizza Data arrivo-->
       <form action="ModVolo" method="post">
    
	 <input type="hidden" value="<%=codice_id %>" name="codice_id">
   Nuova data arrivo  <input type="text" class="ins_ID" placeholder="2017-09-30" name="data_arrivo" id="data_a">
		
      <input type="submit" value="invio">
       <br>
	  	   
       </form>
	  	   <br>
	  	     <br>
       <!-- Visualizza Ora arrivo-->
       <form action="ModVolo" method="post">
       
	 <input type="hidden" value="<%=codice_id %>" name="codice_id">
   Nuovo orario arrivo <input type="text" class="ins_ID" placeholder="10:20:00" name="ora_arrivo" id="ora_a">
		
      <input type="submit" value="invio">
       <br>
		
   </form>
     <br>
   <br>
    <!-- Visualizza costo-->
       <form action="ModVolo" method="post">
      
 <input type="hidden" value="<%=codice_id %>" name="codice_id">
   Nuovo costo <input type="text"  name="costo" id="costo" >
	
	
      <input type="submit" value="invio">
       <br>
		
   </form>
   <br> 
   <br>
   
   

   
	<h1>Modifica tutti i parametri del volo</h1>
       
	  	   

     <form action="ModVolo" method="post">
     	<h1> se desideri cambiare tutti i campi inserisci tutte le informazioni</h1>
      <input type="hidden" value="<%=codice_id %>" name="codice_id">
      <input type="hidden" value="true" name="variabile">
   Nuovo luogo partenza <input type="text" class="ins_LP" placeholder="Luogo partenza" name="luogo_partenza" id="luogo_p"> 
		
   Nuova data partenza  <input type="text" class="ins_ID" placeholder="2017-09-30" name="data_partenza" id="data_p">
	
   Nuovo orario partenza  <input type="text" class="ins_ID" placeholder="10:20:00" name="ora_partenza" id="ora_p">

   Nuovo luogo arrivo <input type="text" class="ins_LA" placeholder="Luogo arrivo" name="luogo_arrivo" id="luogo_a"> 

   Nuova data arrivo  <input type="text" class="ins_ID" placeholder="2017-09-30" name="data_arrivo" id="data_a">

   Nuovo orario arrivo <input type="text" class="ins_ID" placeholder="10:20:00" name="ora_arrivo" id="ora_a">

   Nuovo costo <input type="text" class="ins_ID" placeholder="105.2" name="costo" id="costo">
		
      <input type="submit" value="invio">
       <br>
		
	
   
   </form>
<%} %>
 
</body>
</html>
