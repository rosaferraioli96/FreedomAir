

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
 * Servlet implementation class cancAnnunci
 */
@WebServlet("/cancAnnunci")
public class cancAnnunci extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cancAnnunci() {
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
		HttpSession session=request.getSession(true);
		PrintWriter out= response.getWriter();
		String codiceIDCanc= request.getParameter("codice_id");
		String variabileCodiceIDAnnunci= "true";
		
		if(!codiceIDCanc.matches("[0-9]+")){
			variabileCodiceIDAnnunci = "false";
		    session.setAttribute("variabileCodiceIDAnnunci", variabileCodiceIDAnnunci);
		    response.sendRedirect("promoter.jsp");
	    }else{
			int codice_id=Integer.parseInt(codiceIDCanc); 
			   String variab= "true";

	    
		try {
			QueryBuilder queryBuilder = new QueryBuilder();
			if(!queryBuilder.CodiceAnnunciExist(codice_id)){
				   variab= "false";
					   session.setAttribute("variabilePerAnnunci", variab);
						response.sendRedirect("promoter.jsp");
			  }else{
			ArrayList<Annunci> variabile= queryBuilder.cancAnnunci(codice_id);
				//session.setAttribute("annunci", variabile);
				session.setMaxInactiveInterval(60*5);
				response.sendRedirect("promoter.jsp");
			  }
		} catch (RicercaVoloFailedException e) {
			out.println("ERRORE");
		} catch (ConnessioneException e) {
			out.println("ERRORE connessione fallita");

		} catch (SQLException e) {
			out.println("ERRORE SQL");

		}	}
	    }
}
