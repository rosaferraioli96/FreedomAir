

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
import entita.Biglietto;
import entita.Volo;
/**
 * Servlet implementation class viewBiglietto
 */
@WebServlet("/viewBiglietto")
public class viewBiglietto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewBiglietto() {
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
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		HttpSession session=request.getSession(true);
    	String variabileNulla= "true";
       String variabile= (String) session.getAttribute("name");
		try {
			QueryBuilder queryBuilder = new QueryBuilder();

			ArrayList<Biglietto> variabileBiglietto= queryBuilder.ricercaBiglietto(variabile);
			ArrayList<Volo> var2 = queryBuilder.getVoloByUname(variabile);
             //confronto se la variabile che ho dal metodo getVoloByUname
			//il quale dato che mi restituisce null significa che non ci sono voli
			// quindi entra nel if setta la variabile nulla a false e la passo in cliente
			//cosi da avere "non ci sono voli da visualizzare"
		    if(var2 == null  ){
		    	//setto la variabile nulla a false cosi da passarlo nella sessione
		    	variabileNulla= "false";
		    	session.setAttribute("variabileNulla", variabileNulla);
				response.sendRedirect("cliente.jsp");
			
			}else{
		  //setto gli attributi nel caso in cui ci sono i voli da visualizzare
				
					session.setAttribute("biglietto", variabileBiglietto);
				    session.setAttribute("voloCliente", var2);
					response.sendRedirect("cliente.jsp");
			}
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
