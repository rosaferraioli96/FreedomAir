<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>FredomAir</title>


<link rel="stylesheet" href="css/general.css" type="text/css"
	media="all">
<link rel="stylesheet" href="css/nav.css" type="text/css" media="all">
<link rel="stylesheet" href="css/homePage.css" type="text/css"
	media="all">
<link rel="stylesheet" href="css/login.css" type="text/css" media="all">

</head>
<body>

	<header>

		<div class="logo">
			<img src="immagini/logo_pegaso.png" alt="Logo" class="logo_pegaso">
			<p class="title">FreedomAir</p>
		</div>
		<div class="shop-menu">
	
			<ul>
				<li><a href="cart.html"><img src="#" alt="carrello" />
						Cart</a></li>
				<li>
					<button	onclick="document.getElementById('id01').style.display='block'">
						Login</button>
				</li>
			</ul>



		</div>
	</header>


	<nav>
		<label for="drop" class="toggle-menu"><span>Menu</span></label> <input
			type="checkbox" id="drop" />

		<ul class="menu">
			<li><a href="#">Home</a></li>

			<li class="dropdown">
				<!-- First tier drop down --> <label for="drop-1" class="toggle">In
					partenza</label> <a href="javascript:void(0)" class="dropbtn">In
					partenza</a> <input type="checkbox" id="drop-1" />

				<ul class="dropdown-content">
					<li class="inf"><a href="#">Voli</a></li>
					<li class="inf"><a href="CheckIN.html">Check-in</a></li>
					<li class="inf"><a href="Bagaglio.html">Bagagli</a></li>
				</ul>
   <!-- Ho inserito i link ai servizi -->
			</li>

			<li class="dropdown">
				<!-- First tier drop down --> <label for="drop-2" class="toggle">Info
					e servizi</label> <a href="javascript:void(0)" class="dropbtn">Info e
					servizi</a> <input type="checkbox" id="drop-2" />

				<ul class="dropdown-content">
				<!-- Dire a maddalena che ho cambiato -->
					<li class="inf"><a href="AssistenzaClienti.html">Assistenza clienti</a></li>
					<li class="inf"><a href="#">Servizi extra</a></li>
				</ul>

			</li>

			<li><a href="FAQ.html">FAQ</a></li>
			<li><a href="Contatti.html">Contattaci</a></li>
		</ul>
	</nav>



	<!--content -->
	<!-- tabella per ricercare il volo -->
	<section id="volo">

		<article class="tab-volo">
			<ul class="bott-volo">
				<li><a> Volo</a></li>
			</ul>
			<div class="content">

				<!--  QUI HO CAMBIATO -->
	<form id="ricerca-volo" action="RicercaVolo" method="post">
					<div class="luogo">

						<div class="row-content">
						
							<input type="text" class="input" name="LuogoP"
								value="Luogo Partenza"
								onblur="if(this.value=='') this.value='Luogo Partenza'"
								onFocus="if(this.value == 'Luogo Partenza' ) this.value=''">
						</div>
						<!-- end div class="row" -->

						<div class="row-content">
							<input type="text" class="input" name="LuogoA"
								value="Luogo Arrivo"
								onblur="if(this.value=='') this.value='Luogo Arrivo'"
								onFocus="if(this.value == 'Luogo Arrivo' ) this.value=''">
						</div>

					</div>
					<!-- chiusura div luogo -->
					<div class="data">
						<div class="col-content">
							<div id="name">Partenza</div>
							<input type="date" class="input1" name="DataP" value="03.05.2011"
								onblur="if(this.value=='') this.value='03.05.2011'"
								onFocus="if(this.value =='03.05.2011' ) this.value=''">
						</div>
						<div class="col-content">
							<div id="name">Ritorno</div>
							<input type="date" class="input1" name="DataR" value="10.05.2011"
								onblur="if(this.value=='') this.value='10.05.2011'"
								onFocus="if(this.value =='10.05.2011' ) this.value=''">
							
						</div>
					</div>
					
					<!-- chiusura div data -->

					<button class="button_cerca" type="submit" form="ricerca-volo"
						value="Cerca">Cerca</button>

				
				<!-- end form_1 -->	</form>

			</div>

		</article>

	</section>

	<!-- bottone per tornare all'inizio della pagina -->
	<button onclick="topFunction()" id="Btn-Top" class="butt-log"
		title="Vai sopra"></button>

	<script>
// When the user scrolls down 40px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
    if (document.body.scrollTop > 40 || document.documentElement.scrollTop > 40) {
        document.getElementById("Btn-Top").style.display = "block";
    } else {
        document.getElementById("Btn-Top").style.display = "none";
    }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}
</script>

	<!-- appare la schermata per il login -->

 <%
	 	String name = (String) session.getAttribute("name");
		if (name != null){
			out.print("<h1> Welcome: "+ name +" </h1>");  %>

	<form action="Logout" method="post">
		<input type="submit" value="logout">
	</form> 
	<% } else {
   	 %>
	<div id="id01" class="modal">

		<form class="modal-content animate" action="Login" method="post">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal">&times;</span> <img
					src="img_avatar2.png" alt="Avatar" class="avatar">
			</div>

			<div class="container">
				<label><b>Username</b></label> 
				<input type="text" class="input_log"
					required placeholder="Enter Username" name="uname" id="username"> <label><b>Password</b></label>
				<input type="password" placeholder="Enter Password" name="pass"
					required id="password"> <input type="submit" value="login" id="submitLogin">

				<!--  <button type="submit">Login</button> -->
				<input type="checkbox" checked="checked"> Remember me
			</div>
            <a href="Registrazione.html"> Non sei iscritto? Registrati!</a>
			<div class="container-log">
				<button type="button"
					onclick="document.getElementById('id01').style.display='none'"
					class="butt-log cancelbtn">Cancel</button>
				<span class="psw">Forgot <a href="#">password?</a></span>
			</div>
		</form>
	</div>
<% }
	 %>
 <script src="http://code.jquery.com/jquery-1.6.4.min.js" type="text/javascript"></script>
 <script type="text/javascript">
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

$(function(){
	 $('#submitLogin').click(function(){
		 
		 var username= $('#username').val();
		 var password= $('#password').val();
		 
		   $.ajax({
			   url:'/FreedomAirport/Login',
	           type: 'POST',
	           data: {
	        	   uname: username,
	        	   pass : password
	           },
	           success: function(result) {
	        	   alert(result);
	           },
	           error: function() {
	               alert("Si è verificato un errore!!");
	           }
	       });
		 return false;
	 });
	 
	
});
</script>


	<!-- fine login -->
	<footer>
		<div class="footer">
			<div class="foot-logo">
				<section>
					<img alt="logo footer" src="">
				</section>
			</div>

			<div class="element">
				<p>Azienza</p>
			</div>

			<div class="element">
				<p>Contatti</p>
			</div>


		</div>
		<div class="copyright">
			<p>© Copyright 2017 GE.S.A.C. S.p.a. NAPOLI - Tutti i diritti
				riservati</p>
		</div>
	</footer>

</body>
</html>