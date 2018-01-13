package connessioneDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import connessioneDB.exc.LoginFailedException;
import connessioneDB.exc.RicercaVoloFailedException;
import entita.Annunci;
import entita.Biglietto;
import entita.Carrello;
import entita.Carta;
import entita.Client;
import entita.Client1;
import entita.Volo;


import sun.util.calendar.BaseCalendar.Date;



public class QueryBuilder {

	private AccessoDatabase db;


	public QueryBuilder() throws ConnessioneException {
		db = new AccessoDatabase();
	}


	public Client getLogin(String nome, String pass, int type,int tipo) throws SQLException, LoginFailedException{
		PreparedStatement preparedStatement ;

		String query="SELECT * FROM cliente WHERE username='"+ nome + "' AND password ='"+pass+"' AND tipo ='"+type+"' AND tipo_promoter ='"+tipo+"';";

		preparedStatement = db.getConnessione().prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery(query);
		if (!rs.next()) { 		
			throw new LoginFailedException("Login Failed");
		}
		Client cli = new Client(rs.getString("nome"));
		
		preparedStatement.close();
		return cli;
	}
	
 //prendo solo il nome dell'utente che si logga
	public  String getNome(String nome, String pass, int type) throws SQLException, LoginFailedException{
		PreparedStatement preparedStatement ;


		String query="SELECT nome FROM cliente WHERE username='"+ nome + "' AND password ='"+pass+"' AND tipo ="+type+";";
		preparedStatement = db.getConnessione().prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery(query);


		if (!rs.next()) { 		
			throw new LoginFailedException("Login Failed");
		}
		String nuova= rs.getString("nome");
		
		
		preparedStatement.close();
		return nuova;

		
	}
	
	//prendo solo il cognome dell'utente che si logga
		public  String getCognome(String nome, String pass, int type) throws SQLException, LoginFailedException{
			PreparedStatement preparedStatement ;


			String query="SELECT cognome FROM cliente WHERE username='"+ nome + "' AND password ='"+pass+"' AND tipo ="+type+";";
			preparedStatement = db.getConnessione().prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery(query);


			if (!rs.next()) { 		
				throw new LoginFailedException("Login Failed");
			}
			String nuova= rs.getString("cognome");
			
			
			preparedStatement.close();
			return nuova;
		}
	
		//prendo solo la password dell'utente che si logga
		public String getPassword(String nome, String pass, int type) throws SQLException, LoginFailedException{
			PreparedStatement preparedStatement ;


			String query="SELECT password FROM cliente WHERE username='"+ nome + "' AND password ='"+pass+"' AND tipo ="+type+";";
			preparedStatement = db.getConnessione().prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery(query);


			if (!rs.next()) { 		
				throw new LoginFailedException("Login Failed");
			}
			String nuova= rs.getString("password");
		
			preparedStatement.close();
			return nuova;
		}
	
		//prendo solo il codice fiscale dell'utente che si logga
				public  String getCodiceFiscale(String nome, String pass, int type) throws SQLException, LoginFailedException{
					PreparedStatement preparedStatement ;


					String query="SELECT codice_fiscale FROM cliente WHERE username='"+ nome + "' AND password ='"+pass+"' AND tipo ="+type+";";
					preparedStatement = db.getConnessione().prepareStatement(query);
					ResultSet rs = preparedStatement.executeQuery(query);


					if (!rs.next()) { 		
						throw new LoginFailedException("Login Failed");
					}
					String nuova= rs.getString("codice_fiscale");
				
					preparedStatement.close();
					return nuova;
				}
				
				
				//prendo solo la carta di identit� dell'utente che si logga
				public  String getCartaIdentit�(String nome, String pass, int type) throws SQLException, LoginFailedException{
					PreparedStatement preparedStatement ;


					String query="SELECT carta_identit� FROM cliente WHERE username='"+ nome + "' AND password ='"+pass+"' AND tipo ="+type+";";
					preparedStatement = db.getConnessione().prepareStatement(query);
					ResultSet rs = preparedStatement.executeQuery(query);


					if (!rs.next()) { 		
						throw new LoginFailedException("Login Failed");
					}
					String nuova= rs.getString("carta_identit�");
					
					
					preparedStatement.close();
					return nuova;
				}
				
				//prendo solo il passaporto dell'utente che si logga
				public  String getPassaporto(String nome, String pass, int type) throws SQLException, LoginFailedException{
					PreparedStatement preparedStatement ;


					String query="SELECT passaporto FROM cliente WHERE username='"+ nome + "' AND password ='"+pass+"' AND tipo ="+type+";";
					preparedStatement = db.getConnessione().prepareStatement(query);
					ResultSet rs = preparedStatement.executeQuery(query);


					if (!rs.next()) { 		
						throw new LoginFailedException("Login Failed");
					}
					String nuova= rs.getString("passaporto");
					
					preparedStatement.close();
					return nuova;
				}
				
				//prendo solo il passaporto dell'utente che si logga
				public  String getEmail(String nome, String pass, int type) throws SQLException, LoginFailedException{
					PreparedStatement preparedStatement ;


					String query="SELECT email FROM cliente WHERE username='"+ nome + "' AND password ='"+pass+"' AND tipo ="+type+";";
					preparedStatement = db.getConnessione().prepareStatement(query);
					ResultSet rs = preparedStatement.executeQuery(query);


					if (!rs.next()) { 		
						throw new LoginFailedException("Login Failed");
					}
					String nuova= rs.getString("email");
					
					preparedStatement.close();
					return nuova;
				}
				
				//prendo solo il passaporto dell'utente che si logga
				public  String getNumero_telefono(String nome, String pass, int type) throws SQLException, LoginFailedException{
					PreparedStatement preparedStatement ;


					String query="SELECT numero_telefono FROM cliente WHERE username='"+ nome + "' AND password ='"+pass+"' AND tipo ="+type+";";
					preparedStatement = db.getConnessione().prepareStatement(query);
					ResultSet rs = preparedStatement.executeQuery(query);


					if (!rs.next()) { 		
						throw new LoginFailedException("Login Failed");
					}
					String nuova= rs.getString("numero_telefono");
					
					preparedStatement.close();
					return nuova;
				}
	
	public void setPassword(String email, String password) throws SQLException, LoginFailedException{
		PreparedStatement preparedStatement ;

		String query= "update cliente set password= '"+password+"' WHERE email ='"+email+"';";
		preparedStatement = db.getConnessione().prepareStatement(query);
		preparedStatement.executeUpdate(query);
		preparedStatement.close();
	}

	//modifico i parametri dell'utente
	//verifico se ognuno dei parametri � null, se lo � significa che nn devono essere modificati
	public String setParametri(String uname, String nome, String cognome, String password, String codiceFiscale, String CartaIdentit�, String passaporto, String email, String numero_telefono) throws SQLException, LoginFailedException{
		PreparedStatement preparedStatement ;
		String nuova = "";

		if(uname != null){
			String query= "update cliente set nome= '"+nome+"' WHERE username ='"+uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query);
			preparedStatement.executeUpdate(query);

			String query2="SELECT nome FROM cliente WHERE username='"+ uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query2);
			ResultSet rs = preparedStatement.executeQuery(query2);
			if (!rs.next()) { 		
				throw new LoginFailedException("Login Failed");  
			}
			nuova= rs.getString("nome");
		}	

		if(cognome !=null ){

			String query= "update cliente set cognome= '"+cognome+"' WHERE username ='"+uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query);
			preparedStatement.executeUpdate(query);

			String query2="SELECT cognome FROM cliente WHERE username='"+ uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query2);
			ResultSet rs = preparedStatement.executeQuery(query2);
			if (!rs.next()) { 		
				throw new LoginFailedException("Login Failed");  
			}
			nuova= rs.getString("cognome");

		}
		if(password !=null ){

			String query= "update cliente set password= '"+password+"' WHERE username ='"+uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query);
			preparedStatement.executeUpdate(query);
			String query2="SELECT password FROM cliente WHERE username='"+ uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query2);
			ResultSet rs = preparedStatement.executeQuery(query2);
			if (!rs.next()) { 		
				throw new LoginFailedException("Login Failed");  
			}
			nuova= rs.getString("password");

		}

		if(codiceFiscale !=null ){

			String query= "update cliente set codice_fiscale  = '"+codiceFiscale+"' WHERE username ='"+uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query);
			preparedStatement.executeUpdate(query);
			String query2="SELECT codice_fiscale FROM cliente WHERE username='"+ uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query2);
			ResultSet rs = preparedStatement.executeQuery(query2);
			if (!rs.next()) { 		
				throw new LoginFailedException("Login Failed");  
			}
			nuova= rs.getString("codice_fiscale");

		}

		if(CartaIdentit� !=null){

			String query= "update cliente set carta_identit�  = '"+CartaIdentit�+"' WHERE username ='"+uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query);
			preparedStatement.executeUpdate(query);
			String query2="SELECT   carta_identit� FROM cliente WHERE username='"+ uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query2);
			ResultSet rs = preparedStatement.executeQuery(query2);
			if (!rs.next()) { 		
				throw new LoginFailedException("Login Failed");  
			}
			nuova= rs.getString("carta_identit�");
		}

		if(passaporto !=null){

			String query= "update cliente set passaporto  = '"+passaporto+"' WHERE username ='"+uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query);
			preparedStatement.executeUpdate(query);
			String query2="SELECT passaporto FROM cliente WHERE username='"+ uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query2);
			ResultSet rs = preparedStatement.executeQuery(query2);
			
			if (!rs.next()) { 		
				throw new LoginFailedException("Login Failed");  
			}
			nuova= rs.getString("passaporto");
		}

		if(email !=null){

			String query= "update cliente set email  = '"+email+"' WHERE username ='"+uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query);
			preparedStatement.executeUpdate(query);
			String query2="SELECT email FROM cliente WHERE username='"+ uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query2);
			ResultSet rs = preparedStatement.executeQuery(query2);
			if (!rs.next()) { 		
				throw new LoginFailedException("Login Failed");  
			}
			nuova= rs.getString("email");
		}
		

		if(numero_telefono !=null){

			String query= "update cliente set numero_telefono  = '"+numero_telefono+"' WHERE username ='"+uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query);
			preparedStatement.executeUpdate(query);
			String query2="SELECT numero_telefono FROM cliente WHERE username='"+ uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query2);
			ResultSet rs = preparedStatement.executeQuery(query2);
			if (!rs.next()) { 		
				throw new LoginFailedException("Login Failed");  
			}
			nuova= rs.getString("numero_telefono");
		}
		return nuova;
	}
	//****************************** Ricerca volo Andata*********************************

	public ArrayList<Volo> getRicercaVoloAndata(String LuogoP, String LuogoA, String DataP) throws SQLException, LoginFailedException{
		PreparedStatement preparedStatement ;
		ArrayList<Volo> allVolo= new ArrayList<>();
		ArrayList<Volo> volo= new ArrayList<>();
		String query="SELECT * FROM volo WHERE luogo_partenza='"+ LuogoP + "' AND luogo_arrivo ='"+ LuogoA + "'  AND data_partenza ='"+ DataP + "'ORDER BY codice_id ASC;" ;
		preparedStatement = db.getConnessione().prepareStatement(query);

		ResultSet rs = preparedStatement.executeQuery(query);
	
		while(rs.next()){
			allVolo.add(new Volo(rs.getString("codice_id"),
					rs.getString("luogo_partenza"), 
					rs.getString("data_partenza"), 
					rs.getString("ora_partenza"),
					rs.getString("luogo_arrivo"),
					rs.getString("data_arrivo"),
					rs.getString("ora_arrivo"),
					rs.getFloat("costo")));
		}
		
	

		preparedStatement.close();
		
		return allVolo;
	
		}
	
	//****************************** Verifica Volo andata*********************************	 

	 public String verificaVoloAndata(String LuogoP, String LuogoA, String DataP) throws ConnessioneException, SQLException {
			PreparedStatement preparedStatement ;
			String verifica= "";
			String query="SELECT codice_id FROM volo WHERE luogo_partenza='"+ LuogoP + "' AND luogo_arrivo ='"+ LuogoA + "'  AND data_partenza ='"+ DataP + "';";
			preparedStatement = db.getConnessione().prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery(query);
			
			while(rs.next()) {
			verifica = rs.getString("codice_id");
			}

			preparedStatement.close();
			
			//se il codice id non esiste, allora viene restituito false
			if(verifica.equals("")) {
				return "false";
			} else {
				return "true";
			}
			
		}
	//****************************** Ricerca volo Andata con codice id*********************************
//in questa query prendo il codice id del volo che voglio inserire nel carrello
	public 	String getRicercaVoloAndataById(String LuogoP, String LuogoA, String DataP) throws SQLException, LoginFailedException{
		PreparedStatement preparedStatement ;
		
		String nuova="";
		String query="SELECT codice_id FROM volo WHERE luogo_partenza='"+ LuogoP + "' AND luogo_arrivo ='"+ LuogoA + "'  AND data_partenza ='"+ DataP + "';";
		preparedStatement = db.getConnessione().prepareStatement(query);

		ResultSet rs = preparedStatement.executeQuery(query);
	
		while(rs.next()){
			nuova= rs.getString("codice_id");
		}
		preparedStatement.close();
		
		return nuova;
	}
	
	
	//****************************** Ricerca volo Ritorno*********************************

	public ArrayList<Volo> getRicercaVoloRitorno(String LuogoP, String LuogoA, String DataR) throws SQLException, LoginFailedException{
		PreparedStatement preparedStatement ;
		ArrayList<Volo> allVolo = new ArrayList<>();

		String query="SELECT * FROM volo WHERE luogo_partenza='"+ LuogoP + "' AND luogo_arrivo ='"+ LuogoA + "'  AND data_partenza ='"+ DataR + "';";
		preparedStatement = db.getConnessione().prepareStatement(query);

		ResultSet rs = preparedStatement.executeQuery(query);
	
		while(rs.next()){
			allVolo.add(new Volo(rs.getString("codice_id"),
					rs.getString("luogo_partenza"), 
					rs.getString("data_partenza"), 
					rs.getString("ora_partenza"),
					rs.getString("luogo_arrivo"),
					rs.getString("data_arrivo"),
					rs.getString("ora_arrivo"),
					rs.getFloat("costo")));
		}
		
		preparedStatement.close();
		
		return allVolo;
	}
	//****************************** Verifica Volo RITORNO*********************************	 

		 public String verificaVoloR(String LuogoP, String LuogoA, String DataP) throws ConnessioneException, SQLException {
				PreparedStatement preparedStatement ;
				String verifica= "";
				String query="SELECT codice_id FROM volo WHERE luogo_partenza='"+ LuogoP + "' AND luogo_arrivo ='"+ LuogoA + "'  AND data_partenza ='"+ DataP + "';";
				preparedStatement = db.getConnessione().prepareStatement(query);
				ResultSet rs = preparedStatement.executeQuery(query);
				
				while(rs.next()) {
				verifica = rs.getString("codice_id");
				}

				preparedStatement.close();
				
				//se il codice id non esiste, allora viene restituito false
				if(verifica.equals("")) {
					return "false";
				} else {
					return "true";
				}
				
			}
	//****************************** getAllVolo*********************************
		public ArrayList<Volo> getAllVolo() throws SQLException{
			ArrayList<Volo> allVolo= new ArrayList<>();
			PreparedStatement preparedStatement ;
			String query="SELECT * FROM volo ORDER BY codice_id ASC;" ;
			preparedStatement = db.getConnessione().prepareStatement(query);


			ResultSet rs = preparedStatement.executeQuery(query);
		
			while(rs.next()){
				allVolo.add(new Volo(rs.getString("codice_id"),
						rs.getString("luogo_partenza"), 
						rs.getString("data_partenza"), 
						rs.getString("ora_partenza"),
						rs.getString("luogo_arrivo"),
						rs.getString("data_arrivo"),
						rs.getString("ora_arrivo"),
						rs.getFloat("costo")));
			}
			
			preparedStatement.close();
			return allVolo;
		}
		//****************************** getAllAnnunci*********************************
				public ArrayList<Annunci> getAllAnnunci() throws SQLException{
					ArrayList<Annunci> allVolo= new ArrayList<>();
					PreparedStatement preparedStatement ;
					String query="SELECT * FROM annunci; " ;
					preparedStatement = db.getConnessione().prepareStatement(query);


					ResultSet rs = preparedStatement.executeQuery(query);
				
					while(rs.next()){
						allVolo.add(new Annunci(rs.getInt("codice_id"),
								rs.getString("luogo"), 
								rs.getString("tipo")));
					}
					
					preparedStatement.close();
					return allVolo;
				}
		
		//****************************** cancVolo*********************************	 
		//14-10-17 QUERY CHE PRENDE IL CODICE ID DEL VOLO E POI LO CANCELLA
			public  ArrayList<Volo> cancVolo(String codID) throws SQLException {
				   PreparedStatement preparedStatement ;
					ArrayList<Volo> allVolo= new ArrayList<>();
				   String query = "DELETE FROM volo WHERE codice_id ='"+ codID+"';";
				   preparedStatement = db.getConnessione().prepareStatement(query);  
				      preparedStatement.executeUpdate(query);
				      String query1="SELECT * FROM volo;" ;
						preparedStatement = db.getConnessione().prepareStatement(query1);


						ResultSet rs = preparedStatement.executeQuery(query1);
					
				      
						while(rs.next()){
							allVolo.add(new Volo(rs.getString("codice_id"),
									rs.getString("luogo_partenza"), 
									rs.getString("data_partenza"), 
									rs.getString("ora_partenza"),
									rs.getString("luogo_arrivo"),
									rs.getString("data_arrivo"),
									rs.getString("ora_arrivo"),
									rs.getFloat("costo")));
						}
						
				      preparedStatement.close();
				  	return allVolo;
		
			}
			

			//****************************** cancannunci*********************************	 
			//14-10-17 QUERY CHE PRENDE IL CODICE ID DEL VOLO E POI LO CANCELLA
				public  ArrayList<Annunci> cancAnnunci(int codID) throws SQLException {
					   PreparedStatement preparedStatement ;
						ArrayList<Annunci> allannunci= new ArrayList<>();
					   String query = "DELETE FROM annunci WHERE codice_id ='"+ codID+"';";
					   preparedStatement = db.getConnessione().prepareStatement(query);  
					      preparedStatement.executeUpdate(query);
					      String query1="SELECT * FROM annunci;" ;
							preparedStatement = db.getConnessione().prepareStatement(query1);


							ResultSet rs = preparedStatement.executeQuery(query1);
						
					      
							while(rs.next()){
								allannunci.add(new Annunci(rs.getInt("codice_id"),
										rs.getString("luogo"), 
										rs.getString("tipo")));
							}
							
					      preparedStatement.close();
					  	return allannunci;
			
				}
				
	//****************************** getUsername*********************************	 
	// ho confrontato l'username dato da input se � uguale a qualcuno gia esistente nel db mi faccio restituire
	//true se il valore � presente nel db 
	public boolean isClienteExistByUsername(String username) throws SQLException{
		String query="SELECT username FROM cliente WHERE username ='"+ username + "';";
		PreparedStatement preparedStatement = db.getConnessione().prepareStatement(query);
	
		ResultSet rs = preparedStatement.executeQuery(query);
		boolean exist = rs.next();
		rs.close();
		preparedStatement.close();
		return exist;
	}
	public boolean CodiceidExist(String codice_id) throws SQLException{
		String query="SELECT codice_id FROM volo WHERE codice_id ='"+ codice_id + "';";
		PreparedStatement preparedStatement = db.getConnessione().prepareStatement(query);
	
		ResultSet rs = preparedStatement.executeQuery(query);
		boolean exist = rs.next();
		rs.close();
		preparedStatement.close();
		return exist;
	}
	public boolean CodiceAnnunciExist(int codice_id) throws SQLException{
		String query="SELECT codice_id FROM annunci WHERE codice_id ='"+ codice_id + "';";
		PreparedStatement preparedStatement = db.getConnessione().prepareStatement(query);
	
		ResultSet rs = preparedStatement.executeQuery(query);
		boolean exist = rs.next();
		rs.close();
		preparedStatement.close();
		return exist;
	}
	//****************************** Inserimento cliente*********************************	 

	public void insertClient(Client cliente) throws SQLException {
		PreparedStatement preparedStatement ;
	
		String query = "INSERT INTO cliente(username, password, nome, cognome, data_nascita, paese, indirizzo, codice_fiscale, carta_identit�, passaporto, email, numero_telefono) VALUES ( '"+cliente.getUsername()+"',"
				+ " '"+cliente.getPassword()+"', '"+cliente.getNome()+"', '"+cliente.getCognome()+"', '"+cliente.getDataNascita()+"', '"+cliente.getPaese()+"', '"+cliente.getInd()+"', '"+cliente.getCF()+"' , '"+cliente.getCI()+"', '"+cliente.getPassaporto()+"', '"+cliente.getMail()+"', '"+cliente.getTel()+"');";
		preparedStatement = db.getConnessione().prepareStatement(query);

	    preparedStatement.executeUpdate(query);
	    preparedStatement.close();


	}
	
	//****************************** Inserimento volo*********************************	 
	 public void inserimentoVolo(Volo volo) throws SQLException {
	   PreparedStatement preparedStatement ;
	   //ArrayList<Volo> allVolo = new ArrayList<>();

	   String query = "INSERT INTO volo(codice_id, luogo_partenza, data_partenza, ora_partenza, luogo_arrivo, data_arrivo, ora_arrivo, costo) VALUES ( '"+volo.getCodice_id()+"','"+volo.getLuogo_partenza()+"', '"+volo.getData_partenza()+"', '"+volo.getOra_partenza()+"', '"+volo.getLuogo_arrivo()+"', '"+volo.getData_arrivo()+"', '"+volo.getOra_arrivo()+"', '"+volo.getCosto()+"');";
	   preparedStatement = db.getConnessione().prepareStatement(query);

	      preparedStatement.executeUpdate(query);
	    
	  }
	//****************************** Inserimento annunci*********************************	 
		 public void inserimentoAnnuncio(Annunci annunci) throws SQLException {
		   PreparedStatement preparedStatement ;
		   //ArrayList<Volo> allVolo = new ArrayList<>();

		   String query = "INSERT INTO Annunci( luogo, tipo) VALUES ('"+annunci.getluogo()+"',  '"+annunci.getTipo()+"');";
		   preparedStatement = db.getConnessione().prepareStatement(query);

		      preparedStatement.executeUpdate(query);
		      
		  }
	//****************************** Ricerca Biglietto*********************************	 
		 public ArrayList<Biglietto> ricercaBiglietto(String uname) throws SQLException {
		   PreparedStatement preparedStatement ;

		   ArrayList<Biglietto> allBiglietto = new ArrayList<>();
          
			String query="SELECT intestatario, numero_posto FROM biglietto WHERE  rif_cliente='"+ uname + "';";
			
			preparedStatement = db.getConnessione().prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery(query);


			  
			while(rs.next() ){
		  		allBiglietto.add(new Biglietto(rs.getString("intestatario"), 
						rs.getInt("numero_posto")));
			}
			
			  
			
		  	return allBiglietto;
		  }
		 
		
		 //****************************** getVoloByUname*********************************
			public ArrayList<Volo> getVoloByUname(String uname) throws SQLException{
				ArrayList<Volo> allVolo= new ArrayList<>();
				
				PreparedStatement preparedStatement ;
				String query= " select v.*, b.* from (biglietto b join volo v on v.codice_id=b.rif_volo) where b.rif_cliente='"+ uname + "';";
				preparedStatement = db.getConnessione().prepareStatement(query);

				ResultSet rs = preparedStatement.executeQuery(query);
  
				while(rs.next()){
					allVolo.add(new Volo(rs.getString("codice_id"),
							rs.getString("luogo_partenza"), 
							rs.getString("data_partenza"), 
							rs.getString("ora_partenza"),
							rs.getString("luogo_arrivo"),
							rs.getString("data_arrivo"),
							rs.getString("ora_arrivo"),
							rs.getFloat("costo"),
							rs.getString("intestatario"),
							rs.getInt("costo")
							));
					
				}
				  
				
			
				return allVolo;
			}
			//****************************** Inserimento carrello*********************************	 
			 public void inserimentoCarrello(Carrello carrello) throws SQLException {
			   PreparedStatement preparedStatement ;
			   //ArrayList<Volo> allVolo = new ArrayList<>();

			   String query = "INSERT INTO carrello(rif_cliente, rif_volo, codice_id) VALUES ( '"+carrello.getrif_cliente()+"', '"+carrello.getrif_volo()+"'," +null+");";
			   preparedStatement = db.getConnessione().prepareStatement(query);

			      preparedStatement.executeUpdate(query);
			      
			  }

			//****************************** Visualizzazione Carrello*********************************	 
			 public ArrayList<Volo> getCarrello(String uname) throws SQLException {
			   PreparedStatement preparedStatement ;

			   ArrayList<Volo> allVolo = new ArrayList<>();
	          
				String query="select v.* from (Carrello c join volo v on v.codice_id=c.rif_volo) where c.rif_cliente='"+ uname + "';"; 

				preparedStatement = db.getConnessione().prepareStatement(query);

				ResultSet rs = preparedStatement.executeQuery(query);

				
				while(rs.next()){
					allVolo.add(new Volo(rs.getString("codice_id"),
							rs.getString("luogo_partenza"), 
							rs.getString("data_partenza"), 
							rs.getString("ora_partenza"),
							rs.getString("luogo_arrivo"),
							rs.getString("data_arrivo"),
							rs.getString("ora_arrivo"),
							rs.getFloat("costo")));
				}
				  
				
			  	return allVolo;
			  }
			 
			//****************************** Aggiunta Carta*********************************	 
			 public  String insertCarta(Carta carta) throws SQLException {
			   PreparedStatement preparedStatement ;
			String variabile = "true";
		
			   ArrayList<Biglietto> allBiglietto = new ArrayList<>();
	           String query="Insert into carta (numero_carta, tipo, nominativo, validit�)  VALUES ( "+carta.getNumero_carta()+", '"+carta.getTipo()+"','" +carta.getNominativo()+"','" +carta.getValidit�()+"');";
			   if(query == "null"){
				   variabile="false";
			   }
	     
			   preparedStatement = db.getConnessione().prepareStatement(query);
			    preparedStatement.executeUpdate(query);
                   return variabile;
			
			  }
				//****************************** Aggiunta Biglietto*********************************	
			 public  void insertBiglietto(Biglietto biglietto, Carta carta, String username, String codice_id) throws SQLException {
				   PreparedStatement preparedStatement ;
				
				   
				   String query1 = "INSERT INTO biglietto(codice_id, intestatario, numero_posto, rif_cliente, rif_carta, rif_volo ) VALUES ("+null+", '"+biglietto.getIntestatario()+"','"+biglietto.getNumero_posto()+"','" + username+"'," + carta.getNumero_carta()+",'" + codice_id+"');";
				 
				   preparedStatement = db.getConnessione().prepareStatement(query1);

				   preparedStatement.executeUpdate(query1);
	    
	    
				
				  }
				//****************************** Set Volo*********************************	
			 public String setVolo(String codice_id, String luogo_partenza, String data_partenza, String ora_partenza,  String luogo_arrivo, String  data_arrivo, String ora_arrivo, Float costo) 
						throws ConnessioneException, SQLException {
					PreparedStatement preparedStatement ;
					String nuova = "";
					
				
					if(luogo_partenza != null){
						String query= "update volo set luogo_partenza = '"+luogo_partenza+"' WHERE codice_id  ='"+codice_id +"';";
						preparedStatement = db.getConnessione().prepareStatement(query);
						preparedStatement.executeUpdate(query);
				
						String query2="SELECT luogo_partenza FROM volo WHERE codice_id ='"+ codice_id +"';";
						preparedStatement = db.getConnessione().prepareStatement(query2);
					ResultSet rs = preparedStatement.executeQuery(query2);
						
						if (!rs.next()) { 		
							throw new LoginFailedException("Login Failed");  
						}
						nuova= rs.getString("luogo_partenza");
;
					}	

					if(data_partenza != null){
						String query= "update volo set data_partenza = '"+data_partenza+"' WHERE codice_id  ='"+codice_id +"';";
						preparedStatement = db.getConnessione().prepareStatement(query);
						preparedStatement.executeUpdate(query);

						String query2="SELECT data_partenza FROM volo WHERE codice_id ='"+ codice_id +"';";
						preparedStatement = db.getConnessione().prepareStatement(query2);
						ResultSet rs = preparedStatement.executeQuery(query2);
						if (!rs.next()) { 		
							throw new LoginFailedException("Login Failed");  
						}
						nuova= rs.getString("data_partenza");
					}	
					
					if(ora_partenza != null){
						String query= "update volo set ora_partenza = '"+ora_partenza+"' WHERE codice_id  ='"+codice_id +"';";
						preparedStatement = db.getConnessione().prepareStatement(query);
						preparedStatement.executeUpdate(query);

						String query2="SELECT ora_partenza FROM volo WHERE codice_id ='"+ codice_id +"';";
						preparedStatement = db.getConnessione().prepareStatement(query2);
						ResultSet rs = preparedStatement.executeQuery(query2);
						if (!rs.next()) { 		
							throw new LoginFailedException("Login Failed");  
						}
						nuova= rs.getString("ora_partenza");
					}	
					
					
					if(luogo_arrivo != null){
						String query= "update volo set luogo_arrivo = '"+luogo_arrivo+"' WHERE codice_id  ='"+codice_id +"';";
						preparedStatement = db.getConnessione().prepareStatement(query);
						preparedStatement.executeUpdate(query);

						String query2="SELECT luogo_arrivo FROM volo WHERE codice_id ='"+ codice_id +"';";
						preparedStatement = db.getConnessione().prepareStatement(query2);
						ResultSet rs = preparedStatement.executeQuery(query2);
						if (!rs.next()) { 		
							throw new LoginFailedException("Login Failed");  
						}
						nuova= rs.getString("luogo_arrivo");
					}	

					if(data_arrivo != null){
						String query= "update volo set data_arrivo = '"+data_arrivo+"' WHERE codice_id  ='"+codice_id +"';";
						preparedStatement = db.getConnessione().prepareStatement(query);
						preparedStatement.executeUpdate(query);

						String query2="SELECT data_arrivo FROM volo WHERE codice_id ='"+ codice_id +"';";
						preparedStatement = db.getConnessione().prepareStatement(query2);
						ResultSet rs = preparedStatement.executeQuery(query2);
						if (!rs.next()) { 		
							throw new LoginFailedException("Login Failed");  
						}
						nuova= rs.getString("data_arrivo");
					}	
					
					if(ora_arrivo != null){
						String query= "update volo set ora_arrivo = '"+ora_arrivo+"' WHERE codice_id  ='"+codice_id +"';";
						preparedStatement = db.getConnessione().prepareStatement(query);
						preparedStatement.executeUpdate(query);

						String query2="SELECT ora_arrivo FROM volo WHERE codice_id ='"+ codice_id +"';";
						preparedStatement = db.getConnessione().prepareStatement(query2);
						ResultSet rs = preparedStatement.executeQuery(query2);
						if (!rs.next()) { 		
							throw new LoginFailedException("Login Failed");  
						}
						nuova= rs.getString("ora_arrivo");
					}
					
					if(costo != null){
						String query= "update volo set costo = '"+costo+"' WHERE codice_id  ='"+codice_id +"';";
						preparedStatement = db.getConnessione().prepareStatement(query);
						preparedStatement.executeUpdate(query);

						String query2="SELECT costo FROM volo WHERE codice_id ='"+ codice_id +"';";
						preparedStatement = db.getConnessione().prepareStatement(query2);
						ResultSet rs = preparedStatement.executeQuery(query2);
						if (!rs.next()) { 		
							throw new LoginFailedException("Login Failed");  
						}
						nuova= rs.getString("costo");
					}
					return nuova;
				}
				
				//****************************** Verifica ID*********************************	 

			 public String verificaIDVolo (String codice_id) throws ConnessioneException, SQLException {
					PreparedStatement preparedStatement ;
					String verifica= "";
					String query="SELECT luogo_partenza FROM volo WHERE codice_id ='"+ codice_id +"';";
					preparedStatement = db.getConnessione().prepareStatement(query);
					ResultSet rs = preparedStatement.executeQuery(query);
					
					while(rs.next()) {
					verifica = rs.getString("luogo_partenza");
					}

					preparedStatement.close();
					
					//se il codice id non esiste, allora viene restituito false
					if(verifica.equals("")) {
						return "false";
					} else {
						return "true";
					}
					
					
				}
			//****************************** Cancella Volo Dal carrello*********************************	 
				public void cancellaCarrello(Carrello carrello) throws SQLException{
					PreparedStatement preparedStatement ;
					
					String strQuery1 = "delete from carrello where rif_volo = "+ carrello.getrif_volo()+ ";" ;
					preparedStatement = db.getConnessione().prepareStatement(strQuery1);
					preparedStatement.executeUpdate(strQuery1);
                 
					preparedStatement.close();
				}


	public static void main(String[] args) throws ConnessioneException, SQLException {
		QueryBuilder nuova= new QueryBuilder();
		Scanner in = new Scanner(System.in);
	   //Scanner in2 = new Scanner(System.in);
		//Scanner in3 = new Scanner(System.in);
		System.out.println("Inserisci:: ");

		String numeri1=in.next();
		
	System.out.println(nuova.CodiceidExist(numeri1));
	 //System.out.println(nuova.getVoloByUname(numeri1));
	
	}
}

