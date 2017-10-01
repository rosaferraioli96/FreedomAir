<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>FredomAir</title>


<link rel="stylesheet" href="css/general.css" type="text/css"
	media="all">
<link rel="stylesheet" href="css/nav.css" type="text/css" media="all">
<link rel="stylesheet" href="css/login.css" type="text/css" media="all">

</head>
<body>

	<%@ include file="header.jsp"%>

	<section>
		<form action="Registrazione" method="post">
			<label><b>Username</b></label> <input type="text" class="input_log"
				placeholder="Enter Username" name="uname" id="uname"> <label><b>Password</b></label>
			<input type="text" class="input_log" placeholder="Enter Password"
				name="pass" id="pass"> <label><b>Nome</b></label> <input
				type="text" class="input_log" placeholder="Enter Nome" name="nome"
				id="nome"> <label><b>Cognome</b></label> <input type="text"
				class="input_log" placeholder="Enter Cognome" name="cognome"
				id="cognome"> <label><b>Data Di Nascita</b></label> <input
				type="text" class="input_log" placeholder="Enter Data di Nascita"
				name="dataDiNascita" id="dataDiNascita"> <label><b>Paese</b></label>
			<select name="paese">
				<option value="It">Italia (IT)</option>
				<option value="UK">Regno Unito (UK)</option>
				<option value="F">Francia (F)</option>
				<option value="E">Spagna (E)</option>
				<option value="RO ">Romania (RO)</option>
				<option value="GR">Grecia (GR)</option>
				<option value="D">Germania (G)</option>
			</select> <br> <br> <label><b>Indirizzo</b></label> <input
				type="text" class="input_log" placeholder="Enter Address"
				name="indirizzo" id="indirizzo"> <label><b>Codice
					Fiscale</b></label> <input type="text" class="input_log"
				placeholder="Enter Codice Fiscale" name="codiceFiscale"
				id="codiceFiscale"> <label><b>Codice Carta Di
					Identità</b></label> <input type="text" class="input_log"
				placeholder="Enter Codice Carta Di Identità" name="cartaidentita"
				id="cartaidentita"> <label><b>Codice Passaporto</b></label>
			<input type="text" class="input_log"
				placeholder="Enter Codice Passaporto" name="passaporto"
				id="passaporto"> <label><b>Email</b></label> <input
				type="text" class="input_log" placeholder="Enter Email" name="email"
				id="email"> <label><b>Numero Telefono</b></label> <input
				type="text" class="input_log" placeholder="Enter Numero Telefono"
				name="numerotelefono" id="numerotelefono"> <input
				type="submit" value="invio">
		</form>

	</section>

	<%@ include file="footer.jsp"%>

</body>
</html>