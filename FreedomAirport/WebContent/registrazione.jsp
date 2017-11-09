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
<link rel="stylesheet" href="css/registrazione.css" type="text/css"
	media="all">
</head>
<body>

    
	<%@ include file="header.jsp"%>

	<br>
	<br>
	<br>
		<br>
	<br>
	<br>
		<br>
	
	<form action="Registrazione" method="post" onsubmit="return invio()">

		<div class="form-style-5" align="center">

			<fieldset >
				<legend>
				 <div class="titReg">Candidate Info</div>
				</legend>
			<div id="input"> 
		<input type="text" placeholder="Enter Username (!)" class="input_reg" name="uname" id="usernameReg" required maxlength="6">  </div> 
				<input type="password" class="input_reg" placeholder="Enter Password (!)" name="pass" id="passwordReg" required maxlength="10"> 
				
					<div id="input"><input type="text" class="input_reg" placeholder="Enter Name (!)" name="nome" id="nome" required maxlength="15"> </div>
		
					<div id="input"><input type="text" class="input_reg" placeholder="Enter Surname (!)" name="cognome" id="cognome" required maxlength="10"> </div>
			
			   	<div id="input"> <input type="date" class="input_Data" placeholder="Enter Date Of Birth (Year-Month-Day) (!)"	 required name="dataDiNascita" id="dataDiNascita" value="2017-11-10"
								onblur="if(this.value=='') this.value='2017-11-10'"
								onFocus="if(this.value =='2017-11-10' ) this.value=''"></div> 
               <select name="paese" id="paese">
					<option value="It">Italia (IT)</option>
					<option value="UK">Regno Unito (UK)</option>
					<option value="F">Francia (F)</option>
					<option value="E">Spagna (E)</option>
					<option value="RO ">Romania (RO)</option>
					<option value="GR">Grecia (GR)</option>
					<option value="D">Germania (G)</option>
					<option value="BE">Belgio (BE)</option>
					<option value="HR">Croazia (HR)</option>
					<option value="HU">Ungheria (HU)</option>
					<option value="PT">Portogallo (PT)</option>
				</select></fieldset>
		
	<div id="input">
				<input type="text" class="input_reg" placeholder="Enter Address" name="indirizzo" id="indirizzo" maxlength="20"> </div>
					<div id="input"><input type="text" class="input_reg" placeholder="Enter Fiscal Code" name="codiceFiscale" id="codiceFiscale" maxlength="15"> </div>
					<div id="input"><input type="text" class="input_reg" placeholder="Enter Identity Card Code"	name="cartaidentita" id="cartaidentita" maxlength="8"></div>
					<div id="input"><input type="text" class="input_reg" placeholder="Enter Passport Code" name="passaporto" id="passaporto" maxlength="8"> </div>
					<div id="input"><input type="text" class="input_reg" placeholder="Enter Email (!)" name="email" required id="emailReg" maxlength="20" ></div>
					
					<input type="number" class="input_reg" placeholder="Enter Telephone Number" name="numerotelefono" id="numerotelefono" maxlength="10">
				<br>	<div class="titReg"> I campi contrassegnati con (!) sono obbligatori. </div>
					 <br>  <br> 
					<div id="input" > <input type="submit" class="US_sub" value="Crea Account"	id="submitRegistrazione">	
	</div>
				
			

		</div>
	</form>

<script type="text/javascript">

function invio() {
	$.ajax({
		url : '/FreedomAirport/Registrazione',
		dataType : 'json',
		type : 'POST',
		data : {
			uname : $('#usernameReg').val(),
			pass : $('#passwordReg').val(),
			nome: $('#nome').val(),
			cognome : $('#cognome').val(),
			dataDiNascita: $('#dataDiNascita').val(),
			paese : $('#paese').val(),
			indirizzo : $('#indirizzo').val(),
			codiceFiscale : $('#codiceFiscale').val(),
			cartaidentita : $('#cartaidentita').val(),
			passaporto: $('#passaporto').val(),
			email:  $('#emailReg').val(),
			numerotelefono:  $('#numerotelefono').val()
		},
		success : function(result) {
			if (parseInt(result['result'])) {
				alert("Operazione eseguita con successo!!!");
				 window.location.replace(encodeURIComponent("index.jsp"));
			} else {
				alert("Si è verificato il seguente errore: "+ result['description']);
			}
		},
		error : function() {
			alert("Si è verificato un errore!!");
		}
	});
	return false;
	
}


</script> 

	<%@ include file="footer.jsp"%>

</body>
</html>