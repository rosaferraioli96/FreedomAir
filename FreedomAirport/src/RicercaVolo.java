

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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

		try {
			QueryBuilder queryBuilder = new QueryBuilder();
			out.println(queryBuilder.getRicercaVoloAndata(LuogoP, LuogoA, DataP));
			out.println("\n" + queryBuilder.getRicercaVoloAndata(LuogoA, LuogoP, DataR));
		} catch (RicercaVoloFailedException e) {
			out.println("Ricerca Fallita!!!!");
		} catch (SQLException e) {
			out.println("Ricerca Fallita!!!!");
		} catch (ConnessioneException e) {
			out.println("Ricerca Fallita!!!!");
		}
	}
	}


