package connessioneDB.exc;
import java.sql.SQLException;

public class RicercaVoloFailedException extends SQLException {
	private static final long serialVersionUID = 1997753363232807009L;

	public RicercaVoloFailedException(String message)
	{
		super(message);
		
	}
	public RicercaVoloFailedException(String message, Throwable cause)
	{
		super(message, cause);
	}
}





