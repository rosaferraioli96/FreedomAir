

import java.io.IOException;
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
import entita.Carrello;
import entita.Volo;

/**
 * Servlet implementation class EliminaCarrello
 */
@WebServlet("/EliminaCarrello")
public class EliminaCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaCarrello() {
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
		  HttpSession session=request.getSession(true);  
		String codice_id = request.getParameter("codice_id");
		String username= (String) session.getAttribute("name");
		
		  try {
			String variabile=""; 
			QueryBuilder nuova = new QueryBuilder();
			Carrello carrello = new Carrello(codice_id);
			nuova.cancellaCarrello(carrello);
          	ArrayList<Volo> var = nuova.getCarrello(username);
	        
	        session.setAttribute("carrello", var);
			variabile= "true";
			session.setAttribute("cancellaCarr", variabile);
			response.sendRedirect("carrello.jsp");
			
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
