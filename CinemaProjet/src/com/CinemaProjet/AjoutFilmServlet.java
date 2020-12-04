package com.CinemaProjet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjoutFilmServlet
 */
@WebServlet("/AjoutFilmServlet")
public class AjoutFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				String title = request.getParameter("title");
				String duree = request.getParameter("durée");
				String langue = request.getParameter("langue");
				String sousTitre = request.getParameter("sousTitre");
				String realisateur = request.getParameter("realisateur");
				String acteur1 = request.getParameter("acteur1");
				String acteur2 = request.getParameter("acteur2");
				String acteur3 = request.getParameter("acteur3");
				String minAge = request.getParameter("minAge");
				
				String url = "jdbc:mysql://localhost:3308/salutcine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				try {
					// 1 Connection
					Class.forName("com.mysql.jdbc.Driver");
					Connection myConn = DriverManager.getConnection(url,"root","");
					// 2 Statement
					Statement myStm= myConn.createStatement();
					// Query 
					myStm.executeUpdate("INSERT INTO Film (Titre, Durée, Langue, SousTitre, Realisateur, Acteur1, Acteur2, Acteur3, MinAge) VALUES ('"+title+"', '"+duree+"', '"+langue+"', '"+sousTitre+"', '"+realisateur+"', '"+acteur1+"', '"+acteur2+"', '"+acteur3+"', '"+minAge+"')");
					
					out.print("<p>Film "+title+" ajouté</p>");

				}catch(Exception e){
					e.printStackTrace();
				}
		doGet(request, response);
	}

}
