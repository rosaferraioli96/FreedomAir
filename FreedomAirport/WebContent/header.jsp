<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>

<header>
	<div class="logo">
		<img src="immagini/logo_pegaso.png" alt="Logo" class="logo_pegaso">
		<p class="title">FreedomAir</p>
	</div>
	<div class="shop-menu">
				
		<ul>
				<li><a href="cart.html"><img class="carrello" src="immagini/icone/cart.png" alt="carrello" />
						Cart</a></li>
			<li>
				<%
					String name = (String) session.getAttribute("name");
					if (name != null) {
				%> Welcome: <%=name%>
				<form action="Logout" method="post">
					<input type="submit" value="logout" />
				</form> <%
 	} else {
 %>
				<div class="login"onclick="document.getElementById('id01').style.display='block'">
			<img class="im_login" src="immagini/icone/user.png" alt="utente" /> <a href="#"> Login </a></div> <%
 	}
 %>
			</li>
		</ul>
	</div>
</header>

<nav>
	<label for="drop" class="toggle-menu"><span>Menu</span></label> <input
		type="checkbox" id="drop" />

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
			<!-- First tier drop down --> <label for="drop-2" class="toggle">Info
				e servizi</label> <a href="javascript:void(0)" class="dropbtn">Info e
				servizi</a> <input type="checkbox" id="drop-2" />

			<ul class="dropdown-content">
				<!-- Dire a maddalena che ho cambiato -->
				<li class="inf"><a href="assistenzaClienti.jsp">Assistenza
						clienti</a></li>
				<li class="inf"><a href="#">Servizi extra</a></li>
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
				class="close" title="Close Modal">&times;</span>
		</div>

		<div class="container">
			<label><b>Username</b></label> <input type="text" class="input_log"
				required placeholder="Enter Username" name="uname" id="username">
			<label><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="pass" required id="password">
			<input type="submit" value="login" id="submitLogin">

			<!--  <button type="submit">Login</button> -->
			<input type="checkbox" checked="checked"> Remember me
		</div>
		<a href="registrazione.jsp"> Non sei iscritto? Registrati!</a>
		<div class="container-log">
			<button type="button"
				onclick="document.getElementById('id01').style.display='none'"
				class="butt-log cancelbtn">Cancel</button>
			<span class="psw">Forgot <a href="#">password?</a></span>
		</div>
	</form>
</div>

<script src="http://code.jquery.com/jquery-1.6.4.min.js"
	type="text/javascript"> </script>
	
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

			$.ajax({
				url : '/FreedomAirport/Login',
				type : 'POST',
				data : {
					uname : username,
					pass : password
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
