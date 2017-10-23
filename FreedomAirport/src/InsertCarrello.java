

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
import entita.Volo1;
import entita.Volo2;

/**
 * Servlet implementation class InsertCarrello
 */
@WebServlet("/InsertCarrello")
public class InsertCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCarrello() {
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
		String username= (String) session.getAttribute("name");
		String variabileVoloA= request.getParameter("codiceVolo");
		String variabileVoloR = request.getParameter("codiceVoloRitorno");
		//String variabile2= (String) session.getAttribute("ora_partenza");
		try {
			QueryBuilder nuova= new QueryBuilder();
			if(variabileVoloA != null){
				Carrello variabileCarrello= new Carrello(username, variabileVoloA, null);
				nuova.inserimentoCarrello(variabileCarrello);
				ArrayList<Volo> var = nuova.getCarrello(username);
		        
		        session.setAttribute("carrello", var);
		        
		        response.sendRedirect("carrello.jsp");
				
			}
			if(variabileVoloR !=null){
	        Carrello variabileCarrelloR = new Carrello(username, variabileVoloR, null);
			//nuova.inserimentoCarrello(varaibileCarrelloR);
			nuova.inserimentoCarrello(variabileCarrelloR);
			ArrayList<Volo> var = nuova.getCarrello(username);
	        
	        session.setAttribute("carrello", var);
	        
	        response.sendRedirect("carrello.jsp");
			}
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}
	

}
