
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

	 
<table class="myTable">



     <form action="ModVolo" method="post">
     	<h1 class="tit_mod"> se desideri cambiare tutti i campi inserisci tutte le informazioni</h1>
     	
      <tr class="insert">
	  <td class="AD_text col1">Inserisci  codice id:</td>
	  <td class="US_input col2"><input type="text" class="ins_ID" placeholder="codice_ID" name="codice_id" id="codice_id" required maxlength="10"></td>  
      </tr>
      

    <tr class="insert">
	  <td class="AD_text col1">Nuovo luogo partenza</td>
	  <td class="US_input col2"><input type="text" class="ins_LP" placeholder="Luogo partenza" name="luogo_partenza" id="luogo_p" required maxlength="30"></td> 
	</tr>
	
	 <tr class="insert">	
   <td class="AD_text col1">Nuova data partenza:</td>
   <td class="US_input col2"><input type="date" class="ins_ID" placeholder="2017-09-30" name="data_partenza" id="data_p" value="2017-11-10"
								onblur="if(this.value=='') this.value='2017-11-10'"
								onFocus="if(this.value =='2017-11-10' ) this.value=''" required ></td>
	</tr>
	
	 <tr class="insert">
   <td class="AD_text col1">Nuovo orario partenza:</td>
   <td class="US_input col2"><input type="text" class="ins_ID" placeholder="10:20:00" name="ora_partenza" id="ora_p" required></td>
</tr>

 <tr class="insert">
   <td class="AD_text col1">Nuovo luogo arrivo:</td>
   <td class="US_input col2"><input type="text" class="ins_LA" placeholder="Luogo arrivo" name="luogo_arrivo" id="luogo_a" required maxlength="30"></td> 
</tr>

 <tr class="insert">
   <td class="AD_text col1">Nuova data arrivo:</td>
   <td class="US_input col2"><input type="date" class="ins_ID" placeholder="2017-09-30" name="data_arrivo" id="data_a" value="2017-11-10"
								onblur="if(this.value=='') this.value='2017-11-10'"
								onFocus="if(this.value =='2017-11-10' ) this.value=''" required></td>
</tr>

 <tr class="insert">
   <td class="AD_text col1">Nuovo orario arrivo:</td>
    <td class="US_input col2"><input type="text" class="ins_ID" placeholder="10:20:00" name="ora_arrivo" id="ora_a" required></td>
</tr>

 <tr class="insert">
   <td class="AD_text col1">Nuovo costo: </td>
    <td class="US_input col2"><input type="text" class="ins_ID" placeholder="105.2" name="costo" id="costo" required  maxlength="10"></td>
      <td class="col3 basso_dest"><input type="submit" value="invio" class="US_sub"></td>
     </tr>
		
         </form>

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
