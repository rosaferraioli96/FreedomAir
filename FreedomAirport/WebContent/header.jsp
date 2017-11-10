<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">

<link rel="stylesheet" href="css/login.css" type="text/css" media="all">
<link rel="stylesheet" href="css/nav.css" type="text/css" media="all">


</head>

<header>
<div class="logo">
	<a href="index.jsp"><img src="immagini/logo_pegaso.png" alt="Logo"
		class="logo_pegaso"> </a>
</div>

<div class="shop-menu">


	<%
      String name = (String) session.getAttribute("name");
     Integer amministratore = (Integer) session.getAttribute("amministratore"); 
     if (name != null) {
    %>
	<%-- Welcome: <%=name%> --%>

	<!-- <form action="Logout" method="post" class="Login">

     <input type="submit" value="logout" onclick="myFunction()">
     </form>  -->

	<%
      if (amministratore == 0) {
     %>

	<ul class="ul_nav">

		<li><a href="carrello.jsp"> <img class="carrello"
				src="immagini/icone/cart.png" alt="carrello" />
		</a></li>


		<li>
			<div class="down">
				<button onclick="myFunct()" class="btn">
					<!--  <img class="im_login" src="immagini/icone/user.png" alt="utente" /> -->
				</button>
				<div id="mydown" class="down-cont">
				<a href="#" class="welcome">Welcome : <%=name%> </a>
					<a href="cliente.jsp">Opzioni</a>
					<form action="Logout" method="post" class="Login">
						<a href="#"><input type="submit" class="logout" value="Logout" onclick="myFunction()"></a>
					</form>
				</div>
			</div>
		</li>
	</ul>

	<%
      } else {
     %>
	<ul class="ul_nav">

		<li>
			<div class="down">
				<button onclick="myFunct()" class="btn">
					<!-- <img class="im_login"src="immagini/icone/user.png" alt="utente" /> -->
				</button>

				<div id="mydown" class="down-cont">
				<a href="#" class="welcome">Welcome : <%=name%> </a>
					<a href="admin.jsp">Opzioni</a>
					<form action="Logout" method="post" class="Login">
					 <a href="#"><input type="submit" class="logout" value="Logout" onclick="myFunction()"></a>
					</form>
				</div>
			</div>
		</li>
	</ul>
	<!--  <a href="admin.jsp">Amministratore</a> -->
	<%
      }
     %>




	<%	} else { %>
	<div class="login"
		onclick="document.getElementById('id01').style.display='block'">
		<a href="#"> <img class="im_login" src="immagini/icone/user.png"
			alt="utente" />
		</a>

	</div>
	<%
  }
 %>


</div>
</header>

<nav> <label for="drop" class="toggle-menu"><span>Menu</span></label>
<input type="checkbox" id="drop" />

<ul class="menu">
	<li><a href="index.jsp">Home</a></li>

	<li class="dropdown">
		<!-- First tier drop down --> <label for="drop-1" class="toggle">In
			partenza</label> <a href="javascript:void(0)" class="dropbtn">In partenza</a>
		<input type="checkbox" id="drop-1" />

		<ul class="dropdown-content">
			<li class="inf"><a href="voli.jsp">Voli</a></li>
			<li class="inf"><a href="checkIn.jsp">Check-in</a></li>
			<li class="inf"><a href="bagaglio.jsp">Bagagli</a></li>
		</ul>
	</li>

	<li class="dropdown">
		<!-- First tier drop down --> <label for="drop-2" class="toggle">Info
			e servizi</label> <a href="javascript:void(0)" class="dropbtn">Info e
			servizi</a> <input type="checkbox" id="drop-2" />

		<ul class="dropdown-content">

			<li class="inf"><a href="assistenzaClienti.jsp">Assistenza
					clienti</a></li>
			<li class="inf"><a href="serviziExtra.jsp">Servizi extra</a></li>
		</ul>
	</li>

	<li><a href="faq.jsp">FAQ</a></li>
	<li><a href="contatti.jsp">Contattaci</a></li>
</ul>
</nav>




<!-- appare la schermata per il login -->
<div id="id01" class="modal">
	<form class="modal-content animate" action="Login" method="post"
		autocomplete="off">
		<div class="imgcontainer">

			<span onclick="document.getElementById('id01').style.display='none'"
				class="close" title="Close Login">&times;</span>

			<div class="avatar">
				<img src="immagini/icone/avatar.png" alt="avatar" id="img_avatar" />
			</div>


		</div>

		<div class="container">

			<div id="name">
				<b>Username</b>
			</div>

			<div id="input">
				<input type="text" class="input_log" required
					placeholder="Enter Username" name="uname" id="username">
			</div>

			<div id="name">
				<b>Password</b>
			</div>

			<div id="input">
				<input type="password" placeholder="Enter Password" name="pass"
					required id="password">
				<h5 id="text_pax">
					<a href="PasswordDimenticata.jsp">Password Dimenticata?</a>
				</h5>
			</div>



			<input type="checkbox" name="amministratore" id="amministratore"
				value="true"> <label for="amministratore" class="text_check">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;amministratore
			</label> <input type="submit" value="Login" id="submitLogin">

			<div id="text">
				<h4 id="text_h4">
					Non sei registrato? <a href="registrazione.jsp"> Registrati!</a>
				</h4>
			</div>


		</div>




	</form>

</div>

<script>
/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunct() {
    document.getElementById("mydown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.btn')) {

    var dropdowns = document.getElementsByClassName("down-cont");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>

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
						location.reload();
					} else {
						alert("Username o Password Errati!");
					}
				},
				error : function() {
					alert("Username o Password Errati!");
				}
			});
			return false;
		});

	});
</script>
</html>