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
import connessioneDB.exc.RicercaVoloFailedException;

import entita.Volo;

/**
 * Servlet implementation class InsertVolo
 */
@WebServlet("/InsertVolo")
public class InsertVolo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertVolo() {
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
		String  luogo_partenza = request.getParameter("luogo_partenza"); 
		String data_partenza = request.getParameter("data_partenza");
		String ora_partenza = request.getParameter("ora_partenza");
		String luogo_arrivo = request.getParameter("luogo_arrivo");
		String  data_arrivo = request.getParameter("data_arrivo");
		String  ora_arrivo = request.getParameter("ora_arrivo");
        float costo= Float.parseFloat(request.getParameter("costo")); 
		try {
			QueryBuilder queryBuilder = new QueryBuilder();

			Volo volo = new Volo (codice_id, luogo_partenza, data_partenza, ora_partenza, luogo_arrivo, data_arrivo, ora_arrivo, costo);
			queryBuilder.inserimentoVolo(volo);
			ArrayList<Volo> variabile= queryBuilder.getAllVolo();
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


