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
	private static final String DEBUTDIV="<div class=\"container\"><div class=\"row m-auto\">";
	private static final String FINDIV="</div></div>";
	private static final String DEBUTDIV2="<div class=\"col-sm border-3 rounded p-5 m-5 text-center\" style=\"max-width:450px; min-width:350px\">";
	private static final String FINDIV2="</div>";
	private static final String BOOSTRAP="<link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap.css\">";
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
		String url = "jdbc:mysql://localhost:3308/salutcine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		try {
			// 1 Connection
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection(url,"root","");
			// 2 Statement
			Statement myStm= myConn.createStatement();
			// Query 
			ResultSet myRes = myStm.executeQuery("SELECT Titre, Date, Heure, Durée ,Salle, Langue, MinAge FROM cinema INNER JOIN seance ON cinema.IdCinema = seance.IdCinema INNER JOIN film ON seance.IdFilm = film.IdFilm WHERE cinema.Ville ='"+ville+ "';");
			// Process
			System.out.println(myRes);
			out.print(BOOSTRAP);
			out.print(DEBUTDIV);
			while(myRes.next()) {
				out.print(DEBUTDIV2+"<p>"+ville + "<p></p>" +"titre : "+ myRes.getString("Titre")+"<p></p>" +"date : "+ myRes.getString("Date")+"<p></p>" +"durée : "+ myRes.getString("Durée")+"<p></p>" + "salle : "+ myRes.getString("Salle")+ "<p></p>" +"Langue : "+ myRes.getString("Langue")+ "<p></p>" +"Age minimum : "+ myRes.getString("MinAge")+"</p>"+FINDIV2);
			}
			out.print(FINDIV);
		}catch(Exception e){
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
