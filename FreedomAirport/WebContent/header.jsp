<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>

<header>
	<div class="logo">
		<a href="index.jsp"><img src="immagini/logo_pegaso.png" alt="Logo" class="logo_pegaso"> </a>
	</div>
	
	<div class="shop-menu">

		<ul>

			<li>
				<%
					 String name = (String) session.getAttribute("name");
					Integer amministratore = (Integer) session.getAttribute("amministratore"); 
					if (name != null) {
				%> <%-- Welcome: <%=name%> --%>

				<form action="Logout" method="post" class="Login">
					
					<input type="submit" value="logout" /> 
					<a href="carrello.jsp"> <img class="carrello" src="immagini/icone/cart.png" alt="carrello"/> </a>
					<%
						if (amministratore == 0) {
					%>
					<div class="login" onclick="document.getElementById('id01').style.display='block'">
						 <a href="cliente.jsp" > <img class="im_login" src="immagini/icone/user.png" alt="utente" /></a>
					</div>

					<%
						} else {
					%>
					<a href="admin.jsp" > <img class="im_login" src="immagini/icone/user.png" alt="utente" /></a>
					<!--  <a href="admin.jsp">Amministratore</a> -->
					<%
						}
					%>
					
				</form> 
				
 <%	} else { %>
				<div class="login" onclick="document.getElementById('id01').style.display='block'">
					 <a href="#" > <img class="im_login" src="immagini/icone/user.png" alt="utente" /> </a>
					 
				</div> <%
 	}
 %>
			</li>
		</ul>
	</div>
</header>

<nav>
	<label for="drop" class="toggle-menu"><span>Menu</span></label> 
	<input	type="checkbox" id="drop" />

	<ul class="menu">
		<li><a href="index.jsp">Home</a></li>

		<li class="dropdown">
			<!-- First tier drop down --> <label for="drop-1" class="toggle">In
				partenza</label> <a href="javascript:void(0)" class="dropbtn">In
				partenza</a> <input type="checkbox" id="drop-1" />

			<ul class="dropdown-content">
				<li class="inf"><a href="#">Voli</a></li>
				<li class="inf"><a href="checkIn.jsp">Check-in</a></li>
				<li class="inf"><a href="bagaglio.jsp">Bagagli</a></li>
			</ul>
		</li>

		<li class="dropdown">
			<!-- First tier drop down --> 
			<label for="drop-2" class="toggle">Info e servizi</label> 
			<a href="javascript:void(0)" class="dropbtn">Info e
				servizi</a> <input type="checkbox" id="drop-2" />

			<ul class="dropdown-content">

				<li class="inf"><a href="assistenzaClienti.jsp">Assistenza clienti</a></li>
				<li class="inf"><a href="serviziExtra.jsp">Servizi extra</a></li>
			</ul>
		</li>

		<li><a href="faq.jsp">FAQ</a></li>
		<li><a href="contatti.jsp">Contattaci</a></li>
	</ul>
</nav>




<!-- appare la schermata per il login -->
<div id="id01" class="modal">
<form class="modal-content animate" action="Login" method="post">
  <div class="imgcontainer">
 
  <span onclick="document.getElementById('id01').style.display='none'"
    class="close" title="Close Login">&times;</span>
 
   <div class="avatar">
    <img src="immagini/icone/avatar.png" alt="avatar" id="img_avatar"/>
     </div>
    
   
  </div>
 
  <div class="container">
  
   <div id="name"><b>Username</b></div>
   
   <div id="input">
   <input type="text" class="input_log" required placeholder="Enter Username" name="uname" id="username">
   </div>
  
   <div id="name"> <b>Password</b> </div>
   
   <div id="input">
   <input type="password" placeholder="Enter Password" name="pass" required id="password">
   <h5 id="text_pax"><a href="PasswordDimenticata.jsp">Password Dimenticata?</a></h5>
   </div>
 
 
 
 <input type="checkbox" name="amministratore" id="amministratore" value="true">
  
   
   <label for="amministratore" class="text_check">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;amministratore </label>
 
         
    <input type="submit" value="Login" id="submitLogin">
    
  <div id="text"> 
			<h4 id="text_h4"> Non sei registrato? <a href="registrazione.jsp">  Registrati!</a></h4>
		</div>	
		
		
  </div>
 
 	
 
 
</form>
 
</div>
 
<script src="http://code.jquery.com/jquery-1.6.4.min.js" type="text/javascript"> </script>
               
<script type="text/javascript">
                
  // Get the modal

	var modal = document.getElementById('id01');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}

	$(function() {
		$('#submitLogin').click(function() {

			var username = $('#username').val();
			var password = $('#password').val();

			var amministratore = "Admin";
			if ($("#amministratore").is(":not(:checked)")) {
				amministratore = "Client";
			}

			$.ajax({
				url : '/FreedomAirport/Login',
				type : 'POST',
				data : {
					uname : username,
					pass : password,
					amministratore : amministratore
				},
				success : function(result) {
					if (parseInt(result)) {
						alert("Operazione eseguita con successo!!!");
						location.reload();
					} else {
						alert("Si è verificato un errore!!");
					}
				},
				error : function() {
					alert("Si è verificato un errore!!");
				}
			});
			return false;
		});

	});
</script>