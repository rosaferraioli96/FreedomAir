

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
import entita.Biglietto;
import entita.Carta;
import entita.Volo;

/**
 * Servlet implementation class AcquistoBiglietto
 */
@WebServlet("/AcquistoBiglietto")
public class AcquistoBiglietto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcquistoBiglietto() {
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
		String intestatario= request.getParameter("nome_intestatario");
		
		int numero_posto =Integer.parseInt(request.getParameter("numero_posto")); 
		String codice_id= request.getParameter("codice_id");
		String username= (String) session.getAttribute("name");
	
	    String tipo_carta = request.getParameter("tipo_carta");
	    int numero_carta= Integer.parseInt(request.getParameter("numero_carta"));
	    String nominativo= request.getParameter("nominativo");
	    String validità= request.getParameter("validità");
	    String prova ="true"; 
	    
		try {
			Carta variabileCarta= new Carta(numero_carta,tipo_carta, nominativo, validità );
		    Biglietto variabileBiglietto= new Biglietto(null, intestatario, numero_posto, username, codice_id );

		    QueryBuilder nuova = new QueryBuilder();
		  
		   if( nuova.insertCarta(variabileCarta).equals(prova)){
		    nuova.insertBiglietto(variabileBiglietto, variabileCarta, username, codice_id);
		    session.setAttribute("prova", prova);
			ArrayList<Volo> var = nuova.getVoloByUname(username);
			session.setAttribute("voloCliente", var);
			String variabileNulla= "true";
	    	session.setAttribute("variabileNulla", variabileNulla);
		   }else{
			   prova="false";
			   session.setAttribute("prova", prova);
		   }
		    response.sendRedirect("acquistoBiglietto.jsp");
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
