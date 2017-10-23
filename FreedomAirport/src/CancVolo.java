import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connessioneDB.ConnessioneException;
import connessioneDB.QueryBuilder;
import connessioneDB.exc.RicercaVoloFailedException;
import entita.Volo;

/**
 * Servlet implementation class CancVolo
 */
@WebServlet("/CancVolo")
public class CancVolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancVolo() {
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
		
		doGet(request, response);
		
		response.setContentType("text/html");
		
		PrintWriter out= response.getWriter();
		
		
		String codice_id = request.getParameter("codice_id");

		
		try {
			QueryBuilder queryBuilder = new QueryBuilder();
			ArrayList<Volo> variabile= queryBuilder.cancVolo(codice_id);
			HttpSession session=request.getSession(true);  
				session.setAttribute("volo", variabile);
				session.setMaxInactiveInterval(60*5);
				response.sendRedirect("admin.jsp");
				
		} catch (RicercaVoloFailedException e) {
			out.println("ERRORE");
		} catch (ConnessioneException e) {
			out.println("ERRORE connessione fallita");

		} catch (SQLException e) {
			out.println("ERRORE SQL");

		}
		
		
		
		
	}

}
