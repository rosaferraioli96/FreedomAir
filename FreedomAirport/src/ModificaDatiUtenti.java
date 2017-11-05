

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connessioneDB.ConnessioneException;
import connessioneDB.QueryBuilder;
import connessioneDB.exc.LoginFailedException;
/**
 * Servlet implementation class ModificaDatiUtenti
 */
@WebServlet("/ModificaDatiUtenti")
public class ModificaDatiUtenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaDatiUtenti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String nomeUtente=request.getParameter("nomeUtente");
		String cognomeUtente=request.getParameter("cognomeUtente");
		String passwordUtente=request.getParameter("password");
		String codiceFiscale=request.getParameter("codiceFiscale");
		String cartaIdentita=request.getParameter("cartaIdentita");
		String passaporto=request.getParameter("passaporto");
		String email=request.getParameter("email");
		String numero_telefono=request.getParameter("numero_telefono");
		HttpSession session=request.getSession(true);  
		String uname= (String) session.getAttribute("name");
		
		try {
			QueryBuilder nuova = new QueryBuilder();
			//faccio questi if perchè se i parametri sono null non entrano all'interno degli
			//if e quindi significa che nn vogliamo cambiare i parametri. 
			if(nomeUtente != null){
			//chiamo la query dove passo null come altri parametri perchè voglio modificare solo il nome
			String variabileNome= nuova.setParametri(uname,nomeUtente, null, null,null, null, null, null,null);
			//dato che il nome è stato cambiato modifico l'oggetto session cosi da avere il nuovo nome
			session.setAttribute("nomeUtente", variabileNome);
			}
			
			if(cognomeUtente != null){
			//chiamo la query dove passo null come altri parametri perchè voglio modificare solo il cognome
			String variabileCognome= nuova.setParametri(uname,null, cognomeUtente, null,null, null,null, null,null);
			//dato che il cognome è stato cambiato modifico l'oggetto session cosi da avere il nuovo cognome
			session.setAttribute("cognomeUtente", variabileCognome);
			}
			
			if(passwordUtente !=null){
				//chiamo la query dove passo null come altri parametri  perchè voglio modificare solo la password
				String variabilePassword= nuova.setParametri(uname,null, null, passwordUtente,null, null,null, null, null);
				//dato che il cognome è stato cambiato modifico l'oggetto session cosi da avere la nuova password
				session.setAttribute("passwordUtente", variabilePassword);
			}
			if(codiceFiscale !=null){
				//chiamo la query dove passo null come altri parametri  perchè voglio modificare solo il codice fiscale
				String variabileCodiceFiscale= nuova.setParametri(uname,null, null, null, codiceFiscale, null, null, null, null);
				//dato che il cognome è stato cambiato modifico l'oggetto session cosi da avere il nuovo codice
				session.setAttribute("codiceFiscale", variabileCodiceFiscale);
			}
			if(cartaIdentita!= null){
				//chiamo la query dove passo null come altri parametri  perchè voglio modificare solo la carta d'identità
				String variabileCartaIdentita= nuova.setParametri(uname,null, null, null, null, cartaIdentita, null, null, null);
				//dato che il cognome è stato cambiato modifico l'oggetto session cosi da avere la nuova carta
				session.setAttribute("cartaIdentita", variabileCartaIdentita);

			}
			if(passaporto!= null){
				//chiamo la query dove passo null come altri parametri  perchè voglio modificare solo il passaporto
				String variabilePassaporto= nuova.setParametri(uname,null, null, null, null, null, passaporto, null, null);
				//dato che il cognome è stato cambiato modifico l'oggetto session cosi da avere il nuovo passaporto
				session.setAttribute("passaporto", variabilePassaporto);

			}
			if(email!= null){
				//chiamo la query dove passo null come altri parametri  perchè voglio modificare solo l'email
				String variabileEmail= nuova.setParametri(uname,null, null, null, null, null, null, email, null);
				//dato che il cognome è stato cambiato modifico l'oggetto session cosi da avere la nuova email
				session.setAttribute("email", variabileEmail);
			}
			if(numero_telefono!= null){
				//chiamo la query dove passo null come altri parametri  perchè voglio modificare solo l'email
				String variabileNumero_telefono= nuova.setParametri(uname,null, null, null, null, null, null, email, numero_telefono);
				//dato che il cognome è stato cambiato modifico l'oggetto session cosi da avere la nuova email
				session.setAttribute("numero_telefono", variabileNumero_telefono);

			}
			session.setMaxInactiveInterval(60*5);
			response.sendRedirect("cliente.jsp");
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LoginFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
