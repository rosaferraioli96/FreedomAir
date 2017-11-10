<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*, entita.Volo" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/acquisto.css" type="text/css" media="all">
<link rel="stylesheet" href="css/general.css" type="text/css" media="all">
<link rel="stylesheet" href="css/nav.css" type="text/css" media="all">
<link rel="stylesheet" href="css/login.css" type="text/css" media="all">
<title>Acquisto Biglietto</title>
</head>
<body>

 <%@ include file="header.jsp"%>
 
 
 <% String variabile = (String) session.getAttribute("prova");
    if(variabile == null){ %>
     
    
 
 <h1 class="Titol"> I voli che stai per acquistare</h1>

      <form action="AcquistoBiglietto" method="post">
      
      
       <% ArrayList<Volo> volo = (ArrayList<Volo>) session.getAttribute("carrello"); 
          if(volo !=null){%>
          
          <div class="scr">
    <table id="keywords" cellspacing="0" cellpadding="0">
    <thead>
      <tr>
        <th><span>Codice ID</span></th>
        <th><span>Luogo Partenza</span></th>
        <th><span>Data Partenza</span></th>
        <th><span>Ora Partenza</span></th>
        <th><span>Luogo Arrivo</span></th>
        <th><span>Data Arrivo</span></th>
        <th><span>Ora Arrivo</span></th>
        <th><span>Costo</span></th>
      </tr>
    </thead>
    <tbody>
           <% for(Volo v : volo){%>
      <tr>
        <td class="lalign"> <%=v.getCodice_id()%></td>
        <td><%=v.getLuogo_partenza()%></td>
        <td><%=v.getData_partenza() %></td>
        <td><%=v.getOra_partenza()%></td>
        <td><%=v.getLuogo_arrivo()%></td>
        <td><%=v.getData_arrivo()%></td>
        <td><%=v.getOra_arrivo() %></td>
        <td><%=v.getCosto() %></td>
      </tr>
        
        
        <%} %>   
           </tbody>
  </table>
   </div>
   
   <h1 class="Titol"> Acquista</h1>
   <div class="tb_ins">
   <table class="myTable">
   <tr class="insert">
    <td class="AD_text">Codice id volo:</td>
    <td class="US_input"><input type="text" name="codice_id" /></td>
 </tr>
 
 <tr class="insert">
    <td class="AD_text">Intestatario biglietto:</td>
    <td class="US_input"><input type="text" name="nome_intestatario" /></td>
 </tr>
 
 <tr class="insert">
    <td class="AD_text">Tipo carta:</td>
    <td class="US_input">
     <select name="tipo_carta" id="tipo_carta">
      <option value="MasterCard">Master Card</option>
      <option value="Visa">Visa</option>
      <option value="Postepay">Postepay</option>
      <option value="Paypal">Paypal</option>
     </select>
    </td>
 </tr>
 
 <tr class="insert">
    <td class="AD_text">Numero carta:</td>
    <td class="US_input"><input type="text" name="numero_carta" /></td>
 </tr>
 
 <tr class="insert">
    <td class="AD_text">Nominativo intestatario carta:</td>
    <td class="US_input"><input type="text" name="nominativo" /></td>
 </tr>
 
 <tr class="insert">
    <td class="AD_text">Validità carta:</td>
    <td class="US_input"><input type="date" class="input1" name="DataP" value="2017-11-10"
        onblur="if(this.value=='') this.value='2017-11-10'"
        onFocus="if(this.value =='2017-11-10' ) this.value=''"></td>
    
 </tr>
    
     <tr class="insert">
     <td></td>
    
     <td class="padd"><input id="carrello" type="submit" value="invio" class="but_click"> </td>
       <td></td>
       
       </tr>  
          <% Random r= new Random();
          int posto= r.nextInt(150);%>
          
          <input type="hidden" name="numero_posto" value="<%=posto %>" />
 </table>
 </div>
 </form>
 <%}}else{
	 session.setAttribute("prova", null);%>
 
   <H1 class="Titol">  Il tuo volo è stato acquistato correttamente</H1>
   
<% } %>
   <%@ include file="footer.jsp"%>
</body>
</html>