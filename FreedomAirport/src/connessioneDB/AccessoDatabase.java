package connessioneDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AccessoDatabase {

	public AccessoDatabase() throws ConnessioneException {
		try{  
			Class.forName("com.mysql.jdbc.Driver");		
			String urlConnessione = ConstantsDB.ConfigurazioneDB.SERVER.getValue() + ":" + ConstantsDB.ConfigurazioneDB.PORT.getValue() + "/" + ConstantsDB.ConfigurazioneDB.NOMEDB.getValue();
			connessione = DriverManager.getConnection(urlConnessione,ConstantsDB.ConfigurazioneDB.USERNAME.getValue(),ConstantsDB.ConfigurazioneDB.PASSWORD.getValue());
		}catch(ClassNotFoundException e){
			throw new ConnessioneException(" - AccessoDatabase: Errore Impossibile Trovare i Driver!! ");
		}catch(SQLException e){
			throw new ConnessioneException(" - AccessoDatabase: Impossibile Creare La Connessione!! ");
		}
	}
	public static Connection getConnessione(){
		return connessione;
	}
	private static Connection connessione;	
}
