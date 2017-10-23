
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connessioneDB.ConnessioneException;
import connessioneDB.QueryBuilder;
import connessioneDB.exc.LoginFailedException;
import entita.Biglietto;
import entita.Volo;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String uname=request.getParameter("uname");
		String pass= request.getParameter("pass");
		String amministratore= request.getParameter("amministratore");
		try {
			HttpSession session=request.getSession(true);
			QueryBuilder queryBuilder = new QueryBuilder();
			
			queryBuilder.getLogin(uname, pass, TypeUsers.valueOf(amministratore).getValue());
			session.setAttribute("name",uname);

		
			session.setAttribute("amministratore", TypeUsers.valueOf(amministratore).getValue());
			session.setAttribute("uname", uname);
		
			//salvo nella sessione il nome utente
			String nomeUtente = queryBuilder.getNome(uname, pass, TypeUsers.valueOf(amministratore).getValue());
			session.setAttribute("nomeUtente",nomeUtente); 

			//salvo nella sessione il cognome utente
			String cognomeUtente = queryBuilder.getCognome(uname, pass, TypeUsers.valueOf(amministratore).getValue());
			session.setAttribute("cognomeUtente",cognomeUtente); 

			//salvo nella sessione la password utente
			String passwordUtente = queryBuilder.getPassword(uname, pass, TypeUsers.valueOf(amministratore).getValue());
			session.setAttribute("passwordUtente",passwordUtente);
			
			//salvo nella sessione il codice fiscale utente
			String codiceFiscale = queryBuilder.getCodiceFiscale(uname, pass, TypeUsers.valueOf(amministratore).getValue());
			session.setAttribute("codiceFiscale",codiceFiscale);
			
			//salvo nella sessione la carta d'identità utente
			String cartaIdentita = queryBuilder.getCartaIdentità(uname, pass, TypeUsers.valueOf(amministratore).getValue());
			session.setAttribute("cartaIdentita",cartaIdentita);
			

			//salvo nella sessione il passaporto utente
			String passaporto = queryBuilder.getCartaIdentità(uname, pass, TypeUsers.valueOf(amministratore).getValue());
			session.setAttribute("passaporto",passaporto);
			
			//salvo nella sessione l'email utente
			String email = queryBuilder.getEmail(uname, pass, TypeUsers.valueOf(amministratore).getValue());
			session.setAttribute("email",email); 
			
			//salvo nella sessione il numero_telefono utente
			String numero_telefono = queryBuilder.getNumero_telefono(uname, pass, TypeUsers.valueOf(amministratore).getValue());
			session.setAttribute("numero_telefono",numero_telefono); 
			
			session.setMaxInactiveInterval(60*5);
			

			out.println(Response.OK.getValue());
		} catch (LoginFailedException e) {
			out.println(Response.KO.getValue());
		} catch (SQLException e) {
			out.println(Response.KO.getValue());
		} catch (ConnessioneException e) {
			out.println(Response.KO.getValue());
		}
	}
	

	enum Response {
		OK(1),KO(0);
		
		private int value;

		private Response(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
	
	enum TypeUsers {
		Client(0),Admin(1);
		
		private int value;

		private TypeUsers(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
	
}
