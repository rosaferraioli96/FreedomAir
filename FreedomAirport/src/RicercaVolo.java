

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
import connessioneDB.exc.LoginFailedException;
import connessioneDB.exc.RicercaVoloFailedException;
import entita.Volo;

/**
 * Servlet implementation class RicervaVolo
 */
@WebServlet("/RicercaVolo")
public class RicercaVolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RicercaVolo() {
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
		String LuogoP=request.getParameter("LuogoP");
		String LuogoA= request.getParameter("LuogoA");
		String DataP= request.getParameter("DataP");
		String DataR= request.getParameter("DataR");
	
		HttpSession session=request.getSession(true);   
	
		try {
			QueryBuilder queryBuilder = new QueryBuilder();
			String variabileProvaA = queryBuilder.verificaVoloAndata(LuogoP, LuogoA, DataP);
		
			if(variabileProvaA.equals("true")){
			
			ArrayList<Volo> variabile = queryBuilder.getRicercaVoloAndata(LuogoP, LuogoA, DataP);
			ArrayList<Volo> variabile2 =  queryBuilder.getRicercaVoloAndata(LuogoA, LuogoP, DataR);
			session.setAttribute("voloRitorno", variabile2);
			
			//setto il codice id perchè mi serve per il carello
			String variabile3= queryBuilder.getRicercaVoloAndataById(LuogoP, LuogoA, DataP);
			
		
			//ArrayList<Volo2> variabile4= queryBuilder.getOra_PartenzaById(LuogoP, LuogoA, DataP);
			//session.setAttribute("ora_partenza", variabile4);
			session.setAttribute("codice_id", variabile3);
			session.setAttribute("voloAndata",variabile);
			
			String stringa1  = "true";
			session.setAttribute("erroreVolo", stringa1);
			response.sendRedirect("visualizzaVolo.jsp");
			}else{
				//setto una variabile erroreVolo in modo tale da avere un errore quando non ci sono voli
       			 String stringa  = "false";
			    session.setAttribute("erroreVolo", stringa); 
			    response.sendRedirect("visualizzaVolo.jsp");
			}
			
	
			session.setMaxInactiveInterval(60*5);

		} catch (RicercaVoloFailedException e) {
			out.println("Ricerca Fallita!!!!");
		} catch (SQLException e) {
			out.println("Ricerca Fallita!!!!");
		} catch (ConnessioneException e) {
			out.println("Ricerca Fallita!!!!");
		}
	}
	}


