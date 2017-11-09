<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>FredomAir</title>


<link rel="stylesheet" href="css/general.css" type="text/css" media="all">
<link rel="stylesheet" href="css/homePage.css" type="text/css" media="all">
<link rel="stylesheet" href="css/login.css" type="text/css" media="all">
<link rel="stylesheet" href="css/nav.css" type="text/css" media="all">

</head>
<body>

	<%@ include file="header.jsp"%>





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

							<input id="tags" class="input" name="LuogoP"
								value="Luogo Partenza"
								onblur="if(this.value=='') this.value='Luogo Partenza'"
								onFocus="if(this.value == 'Luogo Partenza' ) this.value=''">
						</div>
						<!-- end div class="row" -->

						<div class="row-content">
							<input id="tags2" class="input" name="LuogoA"
								value="Luogo Arrivo"
								onblur="if(this.value=='') this.value='Luogo Arrivo'"
								onFocus="if(this.value == 'Luogo Arrivo' ) this.value=''">
						</div>

					</div>
					<!-- chiusura div luogo -->
					<div class="data">
						<div class="col-content">
							<div id="name">Partenza</div>
							<input type="date" class="input1" name="DataP" value="2017-11-10"
								onblur="if(this.value=='') this.value='2017-11-10'"
								onFocus="if(this.value =='2017-11-10' ) this.value=''">
						</div>
						<div class="col-content">
							<div id="name">Ritorno</div>
							<input type="date" class="input1" name="DataR" value="2017-11-10"
								onblur="if(this.value=='') this.value='2017-11-10'"
								onFocus="if(this.value =='2017-11-10' ) this.value=''">

						</div>
					</div>

					<!-- chiusura div data -->

					<button class="button_cerca" type="submit" form="ricerca-volo" value="Cerca">Cerca</button>


					<!-- end form_1 -->
				</form>

			</div>

		</article>

	</section>

	<!-- bottone per tornare all'inizio della pagina -->
	<button onclick="topFunction()" id="Btn-Top" class="butt-log" title="Vai sopra"></button>

	<%@ include file="footer.jsp"%>

</body>



<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
  <script>
   $( function() {
    var availableTags = [
     "Alghero-Fertilia (AHO)",
     "Berlino Tegel (TXL)",
     "Bologna International (BLQ)",
     "Monaco Di Baviera (MUC)",
     "Mosca Domodedovo (DME)", 
     "Napoli International(NAP)", 
     "Perugia Sant Egidio (PEG)",
     "Pisa (PSA)",
     "Perugia Sant Egidio (PEG)",
     "Roma Fiumicino (FCO)",
     "Santorini (JRT)"
    ];
    $( "#tags" ).autocomplete({
     source: availableTags
    });
  } );
  </script>
  
  
    <script>
 
  $( function() {
    var availableTags = [
     "Madrid (MAD)",
     "Milano Malpensa (MXP)", 
     "Bruxelles (BRU)", 
     "Torino (TRN)",
     "Palma De Mallorca (PMI)",
     "Genova (GOA",
     "Vienna Schwechat (VIE)",
     "Lamezia Terme (SUF)",
     "Parigi Charles De Gaulle (CDG)",
     "Londra (LON)",
    
    ];
    $( "#tags2" ).autocomplete({
     source: availableTags
    });
  } );
  </script>
  
  
  
  
  
<script type="text/javascript">
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
</html>