

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.xmlrpc.Client;


import connessioneDB.ConnessioneException;
import connessioneDB.QueryBuilder;
import connessioneDB.exc.LoginFailedException;
import connessioneDB.exc.RicercaVoloFailedException;
import entita.Client1;

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrazione() {
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
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String uname=request.getParameter("uname");
		String pass= request.getParameter("pass");
		String nome= request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String dataNascita= request.getParameter("dataDiNascita");
		String paese= request.getParameter("paese");
		String indirizzo= request.getParameter("indirizzo");
		String codiceFiscale= request.getParameter("codiceFiscale");
		String cartaIdentita= request.getParameter("cartaidentita");
		String passaporto= request.getParameter("passaporto");
		String email= request.getParameter("email");
		String numero= request.getParameter("numerotelefono");
       //con questo controllo vedo se il valore restituito dalla query � vero, se lo � allora
		//l'username � gia utilizzato se non lo � allora sara false e far� l'inserimento
		try {
			QueryBuilder queryBuilder = new QueryBuilder();
		  //out.println(queryBuilder.getAllUsername(uname));
			if(queryBuilder.getAllUsername(uname) == false){
				Client1 cliente= new Client1(uname, pass,nome,cognome,dataNascita,paese,indirizzo,codiceFiscale,cartaIdentita,passaporto,email,numero);
				queryBuilder.insertClient(cliente);		
				 request.getRequestDispatcher("index.jsp").forward(request, response);
				Response.OK.getValue();
	
			}
		} catch (RicercaVoloFailedException e) {
			out.println(Response.KO.getValue());
		} catch (ConnessioneException e) {
			out.println(Response.KO.getValue());
		} catch (SQLException e) {
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
}
