package connessioneDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import connessioneDB.exc.LoginFailedException;
import connessioneDB.exc.RicercaVoloFailedException;
import entita.Biglietto;
import entita.Carrello;
import entita.Client;
import entita.Client1;
import entita.Volo;
import entita.Volo1;
import entita.Volo2;
import sun.util.calendar.BaseCalendar.Date;



public class QueryBuilder {

	private AccessoDatabase db;


	public QueryBuilder() throws ConnessioneException {
		db = new AccessoDatabase();
	}


	public Client getLogin(String nome, String pass, int type) throws SQLException, LoginFailedException{
		PreparedStatement preparedStatement ;

		String query="SELECT * FROM cliente WHERE username='"+ nome + "' AND password ='"+pass+"' AND tipo ="+type+";";

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
			
			System.out.println(nuova);
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
			
			System.out.println(nuova);
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
					
					System.out.println(nuova);
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
					
					System.out.println(nuova);
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
					
					System.out.println(nuova);
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
					
					System.out.println(nuova);
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
					
					System.out.println(nuova);
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
			System.out.println(query2);
			if (!rs.next()) { 		
				throw new LoginFailedException("Login Failed");  
			}
			nuova= rs.getString("cognome");

		}
		if(password !=null ){

			String query= "update cliente set password= '"+password+"' WHERE username ='"+uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query);
			preparedStatement.executeUpdate(query);
			System.out.println(query);
			String query2="SELECT password FROM cliente WHERE username='"+ uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query2);
			ResultSet rs = preparedStatement.executeQuery(query2);
			System.out.println(query2);
			if (!rs.next()) { 		
				throw new LoginFailedException("Login Failed");  
			}
			nuova= rs.getString("password");

		}

		if(codiceFiscale !=null ){

			String query= "update cliente set codice_fiscale  = '"+codiceFiscale+"' WHERE username ='"+uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query);
			preparedStatement.executeUpdate(query);
			System.out.println(query);
			String query2="SELECT codice_fiscale FROM cliente WHERE username='"+ uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query2);
			ResultSet rs = preparedStatement.executeQuery(query2);
			System.out.println(query2);
			if (!rs.next()) { 		
				throw new LoginFailedException("Login Failed");  
			}
			nuova= rs.getString("codice_fiscale");

		}

		if(CartaIdentit� !=null){

			String query= "update cliente set carta_identit�  = '"+CartaIdentit�+"' WHERE username ='"+uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query);
			preparedStatement.executeUpdate(query);
			System.out.println(query);
			String query2="SELECT   carta_identit� FROM cliente WHERE username='"+ uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query2);
			ResultSet rs = preparedStatement.executeQuery(query2);
			System.out.println(query2);
			if (!rs.next()) { 		
				throw new LoginFailedException("Login Failed");  
			}
			nuova= rs.getString("carta_identit�");
		}

		if(passaporto !=null){

			String query= "update cliente set passaporto  = '"+passaporto+"' WHERE username ='"+uname+"';";
			preparedStatement = db.getConnessione().prepareStatement(query);
			preparedStatement.executeUpdate(query);
			System.out.println(query);
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
		String query="SELECT * FROM volo WHERE luogo_partenza='"+ LuogoP + "' AND luogo_arrivo ='"+ LuogoA + "'  AND data_partenza ='"+ DataP + "';";
		preparedStatement = db.getConnessione().prepareStatement(query);

		ResultSet rs = preparedStatement.executeQuery(query);
	
		while(rs.next()){
			allVolo.add(new Volo(rs.getString("codice_id"),
					rs.getString("luogo_partenza"), 
					rs.getString("data_partenza"), 
					rs.getString("ora_partenza"),
					rs.getString("luogo_arrivo"),
					rs.getString("data_arrivo"),
					rs.getString("ora_arrivo")));
		}
		
		//System.out.println(allVolo);
		preparedStatement.close();
		
		return allVolo;
	}
	//****************************** Ricerca volo Andata con codice id*********************************
//in questa query prendo il codice id del volo che voglio inserire nel carrello
	public 	String getRicercaVoloAndataById(String LuogoP, String LuogoA, String DataP) throws SQLException, LoginFailedException{
		PreparedStatement preparedStatement ;
		ArrayList<Volo1> allVolo= new ArrayList<>();
		String nuova="";
		String query="SELECT codice_id FROM volo WHERE luogo_partenza='"+ LuogoP + "' AND luogo_arrivo ='"+ LuogoA + "'  AND data_partenza ='"+ DataP + "';";
		preparedStatement = db.getConnessione().prepareStatement(query);

		ResultSet rs = preparedStatement.executeQuery(query);
	
		while(rs.next()){
			nuova= rs.getString("codice_id");
		}
		//System.out.println(allVolo);
		preparedStatement.close();
		
		return nuova;
	}
	
	/*public 	ArrayList<Volo2> getOra_PartenzaById(String LuogoP, String LuogoA, String DataP) throws SQLException, LoginFailedException{
		PreparedStatement preparedStatement ;
		ArrayList<Volo2> allVolo= new ArrayList<>();
		String query="SELECT ora_partenza FROM volo WHERE luogo_partenza='"+ LuogoP + "' AND luogo_arrivo ='"+ LuogoA + "'  AND data_partenza ='"+ DataP + "';";
		preparedStatement = db.getConnessione().prepareStatement(query);

		ResultSet rs = preparedStatement.executeQuery(query);
	
		while(rs.next()){
			allVolo.add(new Volo2(rs.getString("ora_partenza")));
		}
		//System.out.println(allVolo);
		preparedStatement.close();
		
		return allVolo;
	}
	
		public 	Volo getVoloByIdAndOra(String codice_id,String ora_partenza) throws SQLException, LoginFailedException{
		PreparedStatement preparedStatement ;
	 Volo all = null;
		String query="SELECT * FROM volo WHERE codice_id='"+ codice_id + "'  AND ora_partenza ='"+ ora_partenza + "';";
		preparedStatement = db.getConnessione().prepareStatement(query);

		ResultSet rs = preparedStatement.executeQuery(query);
	
		while(rs.next()){
		all = new Volo(rs.getString("luogo_partenza"), 
					rs.getString("data_partenza"), 
					rs.getString("ora_partenza"),
					rs.getString("luogo_arrivo"),
					rs.getString("data_arrivo"),
					rs.getString("ora_arrivo"));
		}
		
		//System.out.println(allVolo);
		preparedStatement.close();
		
		return all;
	}
	
	public Biglietto getBiglietto(String uname) throws SQLException, LoginFailedException{
		PreparedStatement preparedStatement ;
		ArrayList<Biglietto> allBiglietto = new ArrayList<>();

		String query="SELECT * FROM biglietto WHERE rif_cliente='"+ uname + "';";
		preparedStatement = db.getConnessione().prepareStatement(query);

		ResultSet rs = preparedStatement.executeQuery(query);
	

		if (!rs.next()) { 		
			throw new RicercaVoloFailedException("Ricerca Fallita");
		}
		Biglietto biglietto= new Biglietto(rs.getString("compagnia_aerea"), 
				rs.getString("classe"), 
				rs.getInt("numero_posto"),
				rs.getFloat("costo"));
		
		preparedStatement.close();
		
		return biglietto;
	}**/
	//****************************** Ricerca volo Ritorno*********************************

	public ArrayList<Volo> getRicercaVoloRitorno(String LuogoP, String LuogoA, String DataR) throws SQLException, LoginFailedException{
		PreparedStatement preparedStatement ;
		ArrayList<Volo> allVolo = new ArrayList<>();

		String query="SELECT * FROM volo WHERE luogo_partenza='"+ LuogoP + "' AND luogo_arrivo ='"+ LuogoA + "'  AND data_partenza ='"+ DataR + "';";
		preparedStatement = db.getConnessione().prepareStatement(query);

		ResultSet rs = preparedStatement.executeQuery(query);
	
		while(rs.next()){
			allVolo.add(new Volo(rs.getString("luogo_partenza"), 
					rs.getString("data_partenza"), 
					rs.getString("ora_partenza"),
					rs.getString("luogo_arrivo"),
					rs.getString("data_arrivo"),
					rs.getString("ora_arrivo")));
		}
		preparedStatement.close();
		
		return allVolo;
	}
	//****************************** getAllVolo*********************************
		public ArrayList<Volo> getAllVolo() throws SQLException{
			ArrayList<Volo> allVolo= new ArrayList<>();
			PreparedStatement preparedStatement ;
			String query="SELECT * FROM volo;" ;
			preparedStatement = db.getConnessione().prepareStatement(query);


			ResultSet rs = preparedStatement.executeQuery(query);
		
			while(rs.next()){
				allVolo.add(new Volo(rs.getString("codice_id"),
						rs.getString("luogo_partenza"), 
						rs.getString("data_partenza"), 
						rs.getString("ora_partenza"),
						rs.getString("luogo_arrivo"),
						rs.getString("data_arrivo"),
						rs.getString("ora_arrivo")));
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
								rs.getString("ora_arrivo")));
					}
				      preparedStatement.close();
				  	return allVolo;
		
			}
			
	//****************************** getUsername*********************************	 
	// ho confrontato l'username dato da input se � uguale a qualcuno gia esistente nel db mi faccio restituire
	//true se il valore � presente nel db 
	public boolean getAllUsername(String username) throws SQLException{
		ArrayList<Client1> allClient= new ArrayList<>();
		PreparedStatement preparedStatement ;
		String query="SELECT username FROM cliente WHERE username ='"+ username + "';";
		preparedStatement = db.getConnessione().prepareStatement(query);
	
		boolean nuova = false;
		ResultSet rs = preparedStatement.executeQuery(query);
		while(rs.next()){
			allClient.add(new Client1(rs.getString("username")));
		} 
		preparedStatement.close();
	
		ArrayList<String> all= new ArrayList<>();
		all.add(username);
  
        for(Client1 i : allClient){
            if(i.getUsername().equals(username)){
            	 nuova = true;
            	 System.out.println(nuova);
            	throw new RicercaVoloFailedException("Username Gia Utilizzato");
        }
        }
    
        return nuova;
	}
	//****************************** Inserimento cliente*********************************	 

	public void insertClient(Client1 cliente) throws SQLException {
		PreparedStatement preparedStatement ;
	
		String query = "INSERT INTO cliente(username, password, nome, cognome, data_nascita, paese, indirizzo, codice_fiscale, carta_identit�, passaporto, email, numero_telefono) VALUES ( '"+cliente.getUsername()+"',"
				+ " '"+cliente.getPassword()+"', '"+cliente.getNome()+"', '"+cliente.getCognome()+"', '"+cliente.getDataNascita()+"', '"+cliente.getPaese()+"', '"+cliente.getInd()+"', '"+cliente.getCF()+"' , '"+cliente.getCI()+"', '"+cliente.getPassaporto()+"', '"+cliente.getMail()+"', '"+cliente.getTel()+"');";
		preparedStatement = db.getConnessione().prepareStatement(query);

	    preparedStatement.executeUpdate(query);


	}
	
	//****************************** Inserimento volo*********************************	 
	 public void inserimentoVolo(Volo volo) throws SQLException {
	   PreparedStatement preparedStatement ;
	   //ArrayList<Volo> allVolo = new ArrayList<>();

	   String query = "INSERT INTO volo(codice_id, luogo_partenza, data_partenza, ora_partenza, luogo_arrivo, data_arrivo, ora_arrivo) VALUES ( '"+volo.getCodice_id()+"','"+volo.getLuogo_partenza()+"', '"+volo.getData_partenza()+"', '"+volo.getOra_partenza()+"', '"+volo.getLuogo_arrivo()+"', '"+volo.getData_arrivo()+"', '"+volo.getOra_arrivo()+"');";
	   preparedStatement = db.getConnessione().prepareStatement(query);

	      preparedStatement.executeUpdate(query);
	      
	  }
	 
	//****************************** Ricerca Biglietto*********************************	 
		 public ArrayList<Biglietto> ricercaBiglietto(String uname) throws SQLException {
		   PreparedStatement preparedStatement ;

		   ArrayList<Biglietto> allBiglietto = new ArrayList<>();
          
			String query="SELECT intestatario, compagnia_aerea, classe, numero_posto,  costo FROM biglietto WHERE  rif_cliente='"+ uname + "';";
			
			preparedStatement = db.getConnessione().prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery(query);


			  
			while(rs.next() ){
		  		allBiglietto.add(new Biglietto(
						rs.getString("intestatario"), 
						rs.getString("compagnia_aerea"), 
						rs.getString("classe"),
						rs.getInt("numero_posto"),
						rs.getFloat("costo")));
			}
			
			  
			
		  	return allBiglietto;
		  }
		 
		
		 //****************************** getVoloByUname*********************************
			public ArrayList<Volo> getVoloByUname(String uname) throws SQLException{
				ArrayList<Volo> allVolo= new ArrayList<>();
				
				PreparedStatement preparedStatement ;
				String query= "Select rif_volo from biglietto where rif_cliente='"+ uname + "';";
				preparedStatement = db.getConnessione().prepareStatement(query);

				ResultSet rs = preparedStatement.executeQuery(query);
  
				if (!rs.next()) { 		
					return null; 
				}
				String nuova= rs.getString("rif_volo");
				
				String query1= "Select * from volo where codice_id='"+ nuova + "';";
				preparedStatement = db.getConnessione().prepareStatement(query1);
			
				ResultSet rs1 = preparedStatement.executeQuery(query1);
								
				while(rs1.next()){
					allVolo.add(new Volo(rs1.getString("codice_id"),
							rs1.getString("luogo_partenza"), 
							rs1.getString("data_partenza"), 
							rs1.getString("ora_partenza"),
							rs1.getString("luogo_arrivo"),
							rs1.getString("data_arrivo"),
							rs1.getString("ora_arrivo")));
				}
				preparedStatement.close();
				return allVolo;
			}
			//****************************** Inserimento carrello*********************************	 
			 public void inserimentoCarrello(Carrello carrello) throws SQLException {
			   PreparedStatement preparedStatement ;
			   //ArrayList<Volo> allVolo = new ArrayList<>();

			   String query = "INSERT INTO carrello(rif_cliente, rif_volo, codice_id) VALUES ( '"+carrello.getrif_cliente()+"', '"+carrello.getrif_volo()+"'," +null+");";
			   preparedStatement = db.getConnessione().prepareStatement(query);
System.out.println(query);
			      preparedStatement.executeUpdate(query);
			      
			  }

			//****************************** Visualizzazione Carrello*********************************	 
			 public ArrayList<Volo> getCarrello(String uname) throws SQLException {
			   PreparedStatement preparedStatement ;

			   ArrayList<Volo> allVolo = new ArrayList<>();
	          
				String query="select v.* from (Carrello c join volo v on v.codice_id=c.rif_volo) where c.rif_cliente='"+ uname + "';"; 

				preparedStatement = db.getConnessione().prepareStatement(query);

				ResultSet rs = preparedStatement.executeQuery(query);

				System.out.println(query);

				while(rs.next()){
					allVolo.add(new Volo(rs.getString("luogo_partenza"), 
							rs.getString("data_partenza"), 
							rs.getString("ora_partenza"),
							rs.getString("luogo_arrivo"),
							rs.getString("data_arrivo"),
							rs.getString("ora_arrivo")));
				}
				  
				
			  	return allVolo;
			  }
			 
	public static void main(String[] args) throws ConnessioneException, SQLException {
		QueryBuilder nuova= new QueryBuilder();
		Scanner in = new Scanner(System.in);
	   Scanner in2 = new Scanner(System.in);
		Scanner in3 = new Scanner(System.in);
		System.out.println("Inserisci:: ");

		String numeri1=in.next();
		String numeri2=in2.next();
	String numeri3=in3.next();
		//Carrello nuova2= new Carrello(numeri1,numeri2, null);
		
		//System.out.println(nuova.getOra_PartenzaById(numeri1, numeri2, numeri3));
	
	}
}

