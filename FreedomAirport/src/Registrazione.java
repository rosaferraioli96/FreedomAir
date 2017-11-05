

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import entita.Client;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		Client cliente= new Client(	request.getParameter("uname"), 
									request.getParameter("pass"),
									request.getParameter("nome"),
									request.getParameter("cognome"),
									request.getParameter("dataDiNascita"),
									request.getParameter("paese"),
									request.getParameter("indirizzo"),
									request.getParameter("codiceFiscale"),
									request.getParameter("cartaidentita"),
									request.getParameter("passaporto"),
									request.getParameter("email"), 
									request.getParameter("numerotelefono"));
		
		Response result = Response.KO;
		String description = "Username già presente";
        JSONObject json = new JSONObject();
        try {
			QueryBuilder queryBuilder = new QueryBuilder();
			if(!queryBuilder.isClienteExistByUsername(cliente.getUsername())){
				queryBuilder.insertClient(cliente);		
				result = Response.OK;
				description = null;
			}
		} catch (ConnessioneException e) {
			result = Response.KO;
			description = e.getMessage();
		} catch (SQLException e) {
			result = Response.KO;
			description = e.getMessage();
		} 
    	try {
			json.put("result", result.getValue());
			json.put("description", description);
	    	out.print(json.toString());
	    	out.close();
		} catch (JSONException e) {
			throw new ServletException("Fallimento");
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
