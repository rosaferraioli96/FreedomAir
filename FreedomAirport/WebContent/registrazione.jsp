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
		<input type="text" placeholder="Enter Username (!)" class="input_reg" name="uname" id="usernameReg" required maxlength="7">  </div> 
				<input type="password" class="input_reg" placeholder="Enter Password (!)" name="pass" id="passwordReg" required  maxlength="11"> 
				
					<div id="input"><input type="text" class="input_reg" placeholder="Enter Name (!)" name="nome" id="nome" required maxlength="10"> </div>
		
					<div id="input"><input type="text" class="input_reg" placeholder="Enter Surname (!)" name="cognome" id="cognome" required maxlength="10"> </div>
			
			   	<div id="input"> <input type="date" class="input_Data" placeholder="Enter Date Of Birth (Year-Month-Day) (!)"	 required name="dataDiNascita" id="dataDiNascita" value="2017-11-10"
								onblur="if(this.value=='') this.value='2017-11-10'"
								onFocus="if(this.value =='2017-11-10' ) this.value=''"></div> 
               
					<div id="input"><input type="text" class="input_reg" placeholder="Enter Email (!)" name="email" required id="emailReg" maxlength="21" ></div>
					
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