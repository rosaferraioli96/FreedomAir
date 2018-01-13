<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link rel="stylesheet" href="css/cssfooter.css" type="text/css"
	media="all">
<link rel="stylesheet" href="css/general.css" type="text/css"
	media="all">


</head>
<body>

	<!-- bottone per tornare all'inizio della pagina -->
	<button onclick="topFunction()" id="Btn-Top" class="butt-log" title="Vai sopra"></button>
</body>

<footer>

<div class="posizione" id="map" style="width:200px;height:100px;"></div>

	<div class="altoCentro"> <div class="titoloFooter"><font size="5">Azienda </font><br> </div>
		 <a href="index.jsp">Home</a> <br>
 			<a href="contatti.jsp">Contatti </a> <br>
			   <a href="assistenzaClienti.jsp">Assistenza</a> <br>	
 </div> 
		
		<div class="altoDestra"> <div class="titoloFooter"> <font size="5"> Social</font><br> </div>
		   <img class="posizioneDestra"src="immagini/immaginiPagineGenerali/facebook.png" />
			  <img class="posizioneDestra"src="immagini/immaginiPagineGenerali/instagram.png" />
				 <img class="posizioneDestra"src="immagini/immaginiPagineGenerali/twitter.png" />
					<img class="posizioneDestra"src="immagini/immaginiPagineGenerali/whatsapp.png" />
			</div>
<br>
	<div class="copyright" >
		© Copyright 2017 FredoomAir S.p.a. SALERNO - Tutti i diritti riservati. Sede Legale: Via Giovanni Paolo II, 132, 84084 Fisciano SA </div>  
		
	<script>
		function myMap() {
			var mapCanvas = document.getElementById("map");
			var mapOptions = {
				center : new google.maps.LatLng(40.6750676, 14.7559473),
				zoom : 10
			};
			var map = new google.maps.Map(mapCanvas, mapOptions);
		}
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
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCC1__UC2FCADphD34gsZ4mhynsRKVZ-44&callback=myMap"></script>
</footer>
