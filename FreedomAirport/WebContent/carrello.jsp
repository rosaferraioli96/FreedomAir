<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, entita.Volo" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/carrello.css" type="text/css" media="all">
<link rel="stylesheet" href="css/general.css" type="text/css" media="all">
<link rel="stylesheet" href="css/nav.css" type="text/css" media="all">
<link rel="stylesheet" href="css/login.css" type="text/css" media="all">

<title>Carrello</title>
</head>
<body>

 <%@ include file="header.jsp"%>
 
 
 
  <%String variabileCarr= (String) session.getAttribute("cancellaCarr"); %>
       <%if(variabileCarr == null){%>

 <form action="ViewCarrello" method="post">
 <div class="carr">
  <h2 class="tit"> I voli aggiunti al carrello sono: </h2>
  <input type="submit" name="Vedi" class="invio" value="Vedi">
  </div>
  
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
        </form>
                
        
           <form action="EliminaCarrello" method="post">
   <input type="hidden" value="<%=v.getCodice_id() %>" name="codice_id">
      <tr>
   <td><a href="acquistoBiglietto.jsp" class="tit"><strong>Acquista</strong></a></td>
         <td> <input type="submit" value="Elimina" class="elc"> </td>
      </tr>
   </form>

       <%  }} %>
       
       </tbody>
  </table>
   </div>
      <%}else{ 
   
   variabileCarr="true"; 
   
   if(variabileCarr.equals("true")){ %>
   
   
    <form action="ViewCarrello" method="post">
 <div class="carr">
  <h2 class="tit"> I voli aggiunti al carrello sono: </h2>
  <input type="submit" name="Vedi" class="invio" value="Vedi">
  </div>
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
            <%for(Volo v : volo){%>
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
        </form>  
        
        
   <form action="EliminaCarrello" method="post">
   <input type="hidden" value="<%=v.getCodice_id()
 %>" name="codice_id">
      <tr>
   <td><a href="acquistoBiglietto.jsp" class="tit"><strong>Acquista</strong></a></td>
         <td> <input type="submit" value="Elimina" class="elc"> </td>
      </tr>
   </form>
 <% }}} %>
 
 </tbody>
  </table>
   </div>
   
  <%}%>
  
 
 
  <%@ include file="footer.jsp"%>

</body>


<script src="//production-assets.codepen.io/assets/common/stopExecutionOnTimeout-b2a7b3fe212eaa732349046d8416e00a9dec26eb7fd347590fbced3ab38af52e.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.28.14/js/jquery.tablesorter.min.js"></script>

<script type="text/javascript">

$(function(){
   $('#keywords').tablesorter(); 
 });

</script>

</html>