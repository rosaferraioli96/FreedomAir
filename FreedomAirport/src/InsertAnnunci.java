

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
import entita.Annunci;
import entita.Volo;

/**
 * Servlet implementation class InsertAnnunci
 */
@WebServlet("/InsertAnnunci")
public class InsertAnnunci extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAnnunci() {
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
		String  luogo = request.getParameter("luogo"); 
		String tipo = request.getParameter("tipo");

		PrintWriter out= response.getWriter();
		
		try {
			QueryBuilder queryBuilder = new QueryBuilder();

			Annunci annunci = new Annunci (luogo,tipo);
			queryBuilder.inserimentoAnnuncio(annunci);
			ArrayList<Annunci> variabile= queryBuilder.getAllAnnunci();
			HttpSession session=request.getSession(true);  
			session.setAttribute("annunci", variabile);
			session.setMaxInactiveInterval(60*5);
			response.sendRedirect("promoter.jsp");
		} catch (RicercaVoloFailedException e) {
			out.println("ERRORE");
		} catch (ConnessioneException e) {
			out.println("ERRORE connessione fallita");

		} catch (SQLException e) {
			out.println("ERRORE SQL");

		}
	}
		
	}


