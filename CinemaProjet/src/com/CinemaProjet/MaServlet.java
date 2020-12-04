package com.CinemaProjet;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MaServlet
 */
@WebServlet("/MaServlet")
public class MaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaServlet() {
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
		String ville = request.getParameter("ville");
		System.out.println(ville);
		String url = "jdbc:mysql://localhost:3306/cinema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		try {
			// 1 Connection
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection(url,"root","admin");
			// 2 Statement
			Statement myStm= myConn.createStatement();
			// Query 
			ResultSet myRes = myStm.executeQuery("SELECT Titre, Date, Heure, Dur�e ,Salle, Langue, SousTitre,Realisateur, Acteur1,Acteur2,Acteur3, MinAge FROM cinema INNER JOIN seance ON cinema.IdCinema = seance.IdCinema INNER JOIN film ON seance.IdFilm = film.IdFilm WHERE cinema.Ville ='"+ville+ "';");
			// Process
			System.out.println(myRes);
			while(myRes.next()) {
				out.print("<p>"+ville + "<br>" +"Titre : "+ myRes.getString("Titre")+"<br>" +"Date : "+ myRes.getString("Date")+"<br>" +"Dur�e : "+ myRes.getString("Dur�e")+"<br>" + "Salle : "+ myRes.getString("Salle")+ "<br>" +"Langue : "+ myRes.getString("Langue")+ "<br>" +"Sous-titre : "+ myRes.getString("SousTitre")+"<br>" +"R�alisateur: "+ myRes.getString("Realisateur")+"<br>Acteurs :<br> "+myRes.getString("Acteur1")+"<br>" +myRes.getString("Acteur2")+"<br>" +myRes.getString("Acteur3")+"<br>" +"Age minimum : "+ myRes.getString("MinAge")+"</p>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
