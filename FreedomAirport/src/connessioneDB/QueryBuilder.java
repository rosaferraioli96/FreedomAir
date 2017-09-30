package connessioneDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import connessioneDB.exc.LoginFailedException;
import connessioneDB.exc.RicercaVoloFailedException;
import entita.Client;
import entita.Client1;
import entita.Volo;
import sun.util.calendar.BaseCalendar.Date;



public class QueryBuilder {

	private static final Client NULL = null;
	private AccessoDatabase db;


	public QueryBuilder() throws ConnessioneException {
		db = new AccessoDatabase();
	}


	public ArrayList<Client> getAllClient() throws SQLException{
		ArrayList<Client> allClienti = new ArrayList<>();
		//Connection connection = null;
		PreparedStatement preparedStatement ;

		String selectSQL="SELECT * FROM cliente;" ;

		//try {
		//connection = AccessoDatabase.getConnessione();
		preparedStatement = db.getConnessione().prepareStatement(selectSQL);

		ResultSet rs = preparedStatement.executeQuery(selectSQL);

		while (rs.next()) {
			allClienti.add(new Client(rs.getString("username"), 
					rs.getString("password"), 
					rs.getString("nome"), 
					rs.getString("cognome"),
					rs.getString("data_nascita"),
					rs.getString("paese"),
					rs.getString("indirizzo"),
					rs.getString("codice_fiscale"),
					rs.getString("carta_identità"),
					rs.getString("passaporto"),
					rs.getString("email"),
					rs.getString("numero_telefono"))); 
			/*}

			}finally {

					if (preparedStatement != null)
						preparedStatement.close();
				} */
		}
		preparedStatement.close();
		return allClienti;
	}
	public Client getClienti(String nome) throws SQLException{
		PreparedStatement preparedStatement ;


		String query="SELECT * FROM cliente WHERE username='"+ nome + "';";
		preparedStatement = db.getConnessione().prepareStatement(query);

		ResultSet rs = preparedStatement.executeQuery(query);
		rs.next();
		Client cli = new Client( rs.getString("username"), 
				rs.getString("password"), 
				rs.getString("nome"), 
				rs.getString("cognome"),
				rs.getString("data_nascita"),
				rs.getString("paese"),
				rs.getString("indirizzo"),
				rs.getString("codice_fiscale"),
				rs.getString("carta_identità"),
				rs.getString("passaporto"),
				rs.getString("email"),
				rs.getString("numero_telefono"));

		preparedStatement.close();
		return cli;
	}

	public Client getLogin(String nome, String pass) throws SQLException, LoginFailedException{
		PreparedStatement preparedStatement ;


		String query="SELECT nome FROM cliente WHERE username='"+ nome + "' AND password ='"+pass+"';";
		preparedStatement = db.getConnessione().prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery(query);

		if (!rs.next()) { 		
			throw new LoginFailedException("Login Failed");
		}
		Client cli = new Client(rs.getString("nome"));
		
		preparedStatement.close();
		return cli;
	}

	public void getPassword(String email, String password) throws SQLException, LoginFailedException{
		PreparedStatement preparedStatement ;

		String query= "update cliente set password= '"+password+"' WHERE email ='"+email+"';";
		preparedStatement = db.getConnessione().prepareStatement(query);
		preparedStatement.executeUpdate(query);
		preparedStatement.close();
	}

	public Volo getRicercaVoloAndata(String LuogoP, String LuogoA, String DataP) throws SQLException, LoginFailedException{
		PreparedStatement preparedStatement ;
		ArrayList<Volo> allVolo = new ArrayList<>();

		String query="SELECT * FROM volo WHERE luogo_partenza='"+ LuogoP + "' AND luogo_arrivo ='"+ LuogoA + "'  AND data_partenza ='"+ DataP + "';";
		preparedStatement = db.getConnessione().prepareStatement(query);

		ResultSet rs = preparedStatement.executeQuery(query);
	

		if (!rs.next()) { 		
			throw new RicercaVoloFailedException("Ricerca Fallita");
		}
		Volo volo= new Volo(rs.getString("luogo_partenza"), 
				rs.getString("data_partenza"), 
				rs.getString("ora_partenza"),
				rs.getString("luogo_arrivo"),
				rs.getString("data_arrivo"),
				rs.getString("ora_arrivo"));
		
		preparedStatement.close();
		System.out.println(volo);
		return volo;
	}
	public Volo getRicercaVoloRitorno(String LuogoP, String LuogoA, String DataR) throws SQLException, LoginFailedException{
		PreparedStatement preparedStatement ;
		ArrayList<Volo> allVolo = new ArrayList<>();

		String query="SELECT * FROM volo WHERE luogo_partenza='"+ LuogoP + "' AND luogo_arrivo ='"+ LuogoA + "'  AND data_partenza ='"+ DataR + "';";
		preparedStatement = db.getConnessione().prepareStatement(query);

		ResultSet rs = preparedStatement.executeQuery(query);
	

		if (!rs.next()) { 		
			throw new RicercaVoloFailedException("Ricerca Fallita");
		}
		Volo volo= new Volo(rs.getString("luogo_partenza"), 
				rs.getString("data_partenza"), 
				rs.getString("ora_partenza"),
				rs.getString("luogo_arrivo"),
				rs.getString("data_arrivo"),
				rs.getString("ora_arrivo"));
		
		preparedStatement.close();
		
		return volo;
	}

	public ArrayList<Volo> getAllVolo() throws SQLException{
		ArrayList<Volo> allVolo= new ArrayList<>();
		PreparedStatement preparedStatement ;
		String query="SELECT * FROM volo;" ;
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
		System.out.println(allVolo);
		preparedStatement.close();
		return allVolo;
	}
	// ho confrontato l'username dato da input se è uguale a qualcuno gia esistente nel db mi faccio restituire
	//true se il valore è presente nel db 
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
		//System.out.println("ciao");
		ArrayList<String> all= new ArrayList<>();
		all.add(username);
     System.out.println(username);
        for(Client1 i : allClient){
            if(i.getUsername().equals(username)){
            	 nuova = true;
            	 System.out.println(nuova);
            	throw new RicercaVoloFailedException("Username Gia Utilizzato");
        }
        }
        System.out.println(nuova);
        return nuova;
	}
	//inserimento cliente

	public void insertClient(Client1 cliente) throws SQLException {
		PreparedStatement preparedStatement ;
		ArrayList<Volo> allVolo = new ArrayList<>();

		String query = "INSERT INTO cliente(username, password, nome, cognome, data_nascita, paese, indirizzo, codice_fiscale, carta_identità, passaporto, email, numero_telefono) VALUES ( '"+cliente.getUsername()+"',"
				+ " '"+cliente.getPassword()+"', '"+cliente.getNome()+"', '"+cliente.getCognome()+"', '"+cliente.getDataNascita()+"', '"+cliente.getPaese()+"', '"+cliente.getInd()+"', '"+cliente.getCF()+"' , '"+cliente.getCI()+"', '"+cliente.getPassaporto()+"', '"+cliente.getMail()+"', '"+cliente.getTel()+"');";
		preparedStatement = db.getConnessione().prepareStatement(query);

	    preparedStatement.executeUpdate(query);
		System.out.print("CIAO");

	}
	public static void main(String[] args) throws ConnessioneException, SQLException {
		QueryBuilder nuova= new QueryBuilder();
		Scanner in = new Scanner(System.in);
		//Scanner in2 = new Scanner(System.in);
		System.out.println("Inserisci:: ");
	
		String numeri1=in.next();
		//String numeri2=in2.next();*/
   nuova.getAllUsername(numeri1);
	
	}
}

