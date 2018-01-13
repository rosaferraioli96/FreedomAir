import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connessioneDB.ConnessioneException;
import connessioneDB.QueryBuilder;
import connessioneDB.exc.LoginFailedException;
import entita.Volo;

/**
 * Servlet implementation class ModVolo
 */
@WebServlet("/ModVolo")
public class ModVolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModVolo() {
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
		HttpSession session=request.getSession(true);
	
		String codice_id = request.getParameter("codice_id");
		String  luogo_partenza = request.getParameter("luogo_partenza"); 
		String data_partenza = request.getParameter("data_partenza");
		String ora_partenza = request.getParameter("ora_partenza");
		String luogo_arrivo = request.getParameter("luogo_arrivo");
		String  data_arrivo = request.getParameter("data_arrivo");
		String  ora_arrivo = request.getParameter("ora_arrivo");
		
		String costo1= request.getParameter("costo");
        String variabile = request.getParameter("variabile");
        String variabilModifica= "true";
		session.setAttribute("codice_id", codice_id);
		String variabileCostoModifica= "true";
		if(!costo1.matches("[0-9]+")){
			variabileCostoModifica = "false";
		    session.setAttribute("variabileCostoModifica", variabileCostoModifica);
		    response.sendRedirect("admin.jsp");
	    }else{
				try {

					QueryBuilder nuova = new QueryBuilder();
					  if(!nuova.CodiceidExist(codice_id)){
						  variabilModifica= "false";
						   session.setAttribute("variabilePerModificaVolo", variabilModifica);
					  }else{
					
						   String variabileID= nuova.verificaIDVolo(codice_id);
							
							if(variabileID.equals("true")){
							
							//faccio questi if perchè se i parametri sono null non entrano all'interno degli
							//if e quindi significa che nn vogliamo cambiare i parametri. 

							if(luogo_partenza != null){
								//chiamo la query dove passo null come altri parametri perchè voglio modificare solo il nome
								String varLP= nuova.setVolo(codice_id,luogo_partenza, null, null,null, null, null, null);

								//dato che il nome è stato cambiato modifico l'oggetto session cosi da avere il nuovo nome
								session.setAttribute("luogo_partenza", varLP);
							}


							if(data_partenza != null){
								//chiamo la query dove passo null come altri parametri perchè voglio modificare solo il cognome
								String varDP= nuova.setVolo(codice_id,null, data_partenza, null,null, null, null, null);
								//dato che il cognome è stato cambiato modifico l'oggetto session cosi da avere il nuovo cognome
								session.setAttribute("data_partenza", varDP);
							}

							if(ora_partenza != null){
								//chiamo la query dove passo null come altri parametri perchè voglio modificare solo il cognome
								String varOP= nuova.setVolo(codice_id,null, null, ora_partenza,null, null, null, null);
								//dato che il cognome è stato cambiato modifico l'oggetto session cosi da avere il nuovo cognome
								session.setAttribute("ora_partenza", varOP);
							}

							if(luogo_arrivo != null){
								//chiamo la query dove passo null come altri parametri perchè voglio modificare solo il cognome
								String varLA= nuova.setVolo(codice_id,null, null, null ,luogo_arrivo, null, null, null);
								//dato che il cognome è stato cambiato modifico l'oggetto session cosi da avere il nuovo cognome
								session.setAttribute("luogo_arrivo", varLA);
							}

							if(data_arrivo != null){
								//chiamo la query dove passo null come altri parametri perchè voglio modificare solo il cognome
								String varDA= nuova.setVolo(codice_id,null, null, null,null, data_arrivo, null, null);
								//dato che il cognome è stato cambiato modifico l'oggetto session cosi da avere il nuovo cognome
								session.setAttribute("data_arrivo", varDA);
							}

							if(ora_arrivo != null){
								//chiamo la query dove passo null come altri parametri perchè voglio modificare solo il cognome
								String varOA= nuova.setVolo(codice_id,null, null, null ,null, null, ora_arrivo, null);
								//dato che il cognome è stato cambiato modifico l'oggetto session cosi da avere il nuovo cognome
								session.setAttribute("ora_arrivo", varOA);
							}	

							if(costo1 != null){
								Float costo = Float.parseFloat(request.getParameter("costo"));
								//chiamo la query dove passo null come altri parametri perchè voglio modificare solo il cognome
								String varOA= nuova.setVolo(codice_id,null, null, null ,null, null, null, costo);
								//dato che il cognome è stato cambiato modifico l'oggetto session cosi da avere il nuovo cognome
								session.setAttribute("ora_arrivo", varOA);
							}	
							
							//quando si vogliono modifcare tutte le componenti del volo
							if(variabile != null){
								Float costo = Float.parseFloat(request.getParameter("costo"));
								//chiamo la query dove passo null come altri parametri perchè voglio modificare solo il cognome
								String varDP= nuova.setVolo(codice_id,luogo_partenza, data_partenza, ora_partenza,luogo_arrivo, data_arrivo, ora_arrivo, costo);
								//dato che il cognome è stato cambiato modifico l'oggetto session cosi da avere il nuovo cognome
								//session.setAttribute("data_partenza", varDP);
							}
							
							ArrayList<Volo> viewVolo = nuova.getAllVolo();
							session.setAttribute("volo", viewVolo);
							  String stringa1  = "true";
							session.setAttribute("errore", stringa1);
							}else{
							  String stringa  = "false";
								session.setAttribute("errore", stringa);
							}
					  }
					response.sendRedirect("admin.jsp");
				} catch (ConnessioneException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (LoginFailedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
	    }
	}

}

