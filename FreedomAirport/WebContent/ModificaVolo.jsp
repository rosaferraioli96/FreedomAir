
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
 <button class="accordion">Modifica Volo</button>
	<!-- Pannello -->
		<div class="panel">
	
   <h3 class="descrizione">Inviare prima il codice ID e poi inserire il dato da modificare</h3>
	 
<table class="myTable">


    <form action="ModVolo" method="post">
     <% String codice_id = (String) session.getAttribute("codice_id"); 
     if(codice_id != null){
   %>
           
          <tr class="insert">
           <td></td>
            <td class="AD_text">il codice che hai inserito è <%=codice_id %></td>
           <td></td>
        </tr>
        
           <tr class="insert">
	  <td class="AD_text col1">Inserisci  codice id per cambiare</td>
	  <td class="US_input col2"><input type="text" class="ins_ID" placeholder="codice_ID" name="codice_id" id="codice_id"></td>  
        <td class="col3"><input type="submit" value="invio" class="US_sub"></td>
      </tr>
	 <%}else{ %>
	  
	  <tr class="insert">
           <td class="AD_text col1">Inserisci  codice id:</td>
           <td class="US_input col2"><input type="text" class="ins_ID" placeholder="codice_ID" name="codice_id" id="codice_id"></td>  
        <td class="col3"><input type="submit" value="invio" class="US_sub"></td>
        <%} %>
       </form>
       	    
	 <%String errore= (String) session.getAttribute("errore"); 
       if(errore == "false"){
        %>
        
   <h1 class="tit_mod red"> Codice Id non valido</h1>
   <p class="tit_mod"> Inserire un nuovo codice ID valido.</p>
   
    
      
       <%}else{ %>

			<!-- Visualizza Luogo partenza-->
			<form action="ModVolo" method="post">
				<input type="hidden" value="<%=codice_id %>" name="codice_id">
				<tr class="insert">
					<td class="AD_text col1">Nuovo luogo partenza:</td>
					<td class="US_input col2"><input type="text" class="ins_LP" placeholder="Luogo partenza" name="luogo_partenza" id="luogo_partenza"></td>
					<td class="col3"><input type="submit" value="invio"
						class="US_sub"></td>
				</tr>
			</form>
       
   <!-- Visualizza Data partenza-->
         <form action="ModVolo" method="post">
         <input type="hidden" value="<%=codice_id %>" name="codice_id">
        	<tr class="insert" >
	 		 <td class="AD_text col1">Nuova data partenza: </td>
	 		 <td class="US_input col2"><input type="date" class="ins_ID inputCalendar" placeholder="2017-09-30" name="data_partenza" id="data_p" value="2017-11-10"
								onblur="if(this.value=='') this.value='2017-11-10'"
								onFocus="if(this.value =='2017-11-10' ) this.value=''"></td>
	 		 <td class="col3"> <input type="submit" value="invio" class="US_sub" ></td>
	 		</tr>
         </form>

  <!-- Visualizza Ora partenza-->
         <form action="ModVolo" method="post">
        <input type="hidden" value="<%=codice_id %>" name="codice_id">
        	<tr class="insert" >
	 		 <td class="AD_text col1">Nuovo orario partenza: </td>
	 		 <td class="US_input col2"><input type="text" class="ins_ID" placeholder="10:20:00" name="ora_partenza" id="ora_p"></td>
	 		 <td class="col3"> <input type="submit" value="invio" class="US_sub"></td>
	 		</tr>
         </form>
         

   <!-- Visualizza Luogo arrivo-->
         <form action="ModVolo" method="post">
        <input type="hidden" value="<%=codice_id %>" name="codice_id">
        <tr class="insert" >
	 		 <td class="AD_text col1">Nuovo luogo arrivo: </td>
	 		 <td class="US_input col2"> <input type="text" class="ins_LA" placeholder="Luogo arrivo" name="luogo_arrivo" id="luogo_a"></td>
	 		 <td class="col3"> <input type="submit" value="invio" class="US_sub"></td>
	 		</tr>
         </form>
         	  	  


<!-- Visualizza Data arrivo-->
         <form action="ModVolo" method="post">
        <input type="hidden" value="<%=codice_id %>" name="codice_id">
        	<tr class="insert" >
	 		 <td class="AD_text col1"> Nuova data arrivo: </td>
	 		 <td class="US_input col2"> <input type="date" class="ins_ID inputCalendar" placeholder="2017-09-30" name="data_arrivo" id="data_a" value="2017-11-10"
								onblur="if(this.value=='') this.value='2017-11-10'"
								onFocus="if(this.value =='2017-11-10' ) this.value=''"> </td>
	 		 <td class="col3"> <input type="submit" value="invio" class="US_sub"></td>
	 		</tr>
         </form>
         
  
	 
	  	            
             <!-- Visualizza Ora arrivo-->
         <form action="ModVolo" method="post">
        <input type="hidden" value="<%=codice_id %>" name="codice_id">
        	<tr class="insert" >
	 		 <td class="AD_text col1"> Nuovo orario arrivo: </td>
	 		 <td class="US_input col2"><input type="text" class="ins_ID" placeholder="10:20:00" name="ora_arrivo" id="ora_a"></td>
	 		 <td class="col3"> <input type="submit" value="invio" class="US_sub"></td>
	 		</tr>
         </form>
         
         
         
	 
   
               <!-- Visualizza costo-->
         <form action="ModVolo" method="post">
        <input type="hidden" value="<%=codice_id %>" name="codice_id">
        	<tr class="insert" >
	 		 <td class="AD_text col1"> Nuovo costo: </td>
	 		 <td class="US_input col2"> <input type="text"  name="costo" id="costo" > </td>
	 		 <td class="col3"> <input type="submit" value="invio" class="US_sub"></td>
	 		</tr>
         </form>
  	  	</table>
	  </div><!-- end div panel-->	
  
   
<%} %>


<!--   <form action="ModVolo" method="post"> -->
 <button class="accordion">Modifica tutti i dati di un Volo</button>
	<!-- Pannello -->
		<div class="panel">
	
   <h3 class="descrizione">Inserire tutti i dati.</h3>
	 
<table class="myTable">


    <form action="ModVolo" method="post">
     <% codice_id = (String) session.getAttribute("codice_id"); 
     if(codice_id != null){
   %>
           
          <tr class="insert">
           <td></td>
            <td class="AD_text">il codice che hai inserito è <%=codice_id %></td>
           <td></td>
        </tr>
       <!--  
           <tr class="insert">
	  <td class="AD_text col1">Inserisci  codice id per cambiare</td>
	  <td class="US_input col2"><input type="text" class="ins_ID" placeholder="codice_ID" name="codice_id" id="codice_id"></td>  
      </tr> -->
	 <%}else{ %>
	  
	  <tr class="insert">
           <td class="AD_text col1">Inserisci  codice id:</td>
           <td class="US_input col2"><input type="text" class="ins_ID" placeholder="codice_ID" name="codice_id" id="codice_id"></td>  
        <td class="col3"><input type="submit" value="invio" class="US_sub"></td>
        <%} %>
       </form>
       	    
	 <% errore= (String) session.getAttribute("errore"); 
       if(errore == "false"){
        %>
        
   <h1 class="tit_mod red"> Codice Id non valido</h1>
   <p class="tit_mod"> Inserire un nuovo codice ID valido.</p>
   
    
      
       <%}else{ %>

     <form action="ModVolo" method="post">
     	<h1 class="tit_mod"> se desideri cambiare tutti i campi inserisci tutte le informazioni</h1>
     	
      <tr class="insert">
	  <td class="AD_text col1">Inserisci  codice id:</td>
	  <td class="US_input col2"><input type="text" class="ins_ID" placeholder="codice_ID" name="codice_id" id="codice_id"></td>  
      </tr>
      

    <tr class="insert">
	  <td class="AD_text col1">Nuovo luogo partenza</td>
	  <td class="US_input col2"><input type="text" class="ins_LP" placeholder="Luogo partenza" name="luogo_partenza" id="luogo_p"></td> 
	</tr>
	
	 <tr class="insert">	
   <td class="AD_text col1">Nuova data partenza:</td>
   <td class="US_input col2"><input type="date" class="ins_ID" placeholder="2017-09-30" name="data_partenza" id="data_p" value="2017-11-10"
								onblur="if(this.value=='') this.value='2017-11-10'"
								onFocus="if(this.value =='2017-11-10' ) this.value=''"></td>
	</tr>
	
	 <tr class="insert">
   <td class="AD_text col1">Nuovo orario partenza:</td>
   <td class="US_input col2"><input type="text" class="ins_ID" placeholder="10:20:00" name="ora_partenza" id="ora_p"></td>
</tr>

 <tr class="insert">
   <td class="AD_text col1">Nuovo luogo arrivo:</td>
   <td class="US_input col2"><input type="text" class="ins_LA" placeholder="Luogo arrivo" name="luogo_arrivo" id="luogo_a"></td> 
</tr>

 <tr class="insert">
   <td class="AD_text col1">Nuova data arrivo:</td>
   <td class="US_input col2"><input type="date" class="ins_ID" placeholder="2017-09-30" name="data_arrivo" id="data_a" value="2017-11-10"
								onblur="if(this.value=='') this.value='2017-11-10'"
								onFocus="if(this.value =='2017-11-10' ) this.value=''"></td>
</tr>

 <tr class="insert">
   <td class="AD_text col1">Nuovo orario arrivo:</td>
    <td class="US_input col2"><input type="text" class="ins_ID" placeholder="10:20:00" name="ora_arrivo" id="ora_a"></td>
</tr>

 <tr class="insert">
   <td class="AD_text col1">Nuovo costo: </td>
    <td class="US_input col2"><input type="text" class="ins_ID" placeholder="105.2" name="costo" id="costo"></td>
      <td class="col3 basso_dest"><input type="submit" value="invio" class="US_sub"></td>
     </tr>
		
         </form>
         <%} %>
  	  	</table>
	  </div><!-- end div panel-->	
  
   


</body>

<script>
var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
    acc[i].onclick = function(){
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
