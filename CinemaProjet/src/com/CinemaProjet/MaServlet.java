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
			ResultSet myRes = myStm.executeQuery("SELECT Titre, Date, Heure, Durée ,Salle, Langue, MinAge FROM cinema INNER JOIN seance ON cinema.IdCinema = seance.IdCinema INNER JOIN film ON seance.IdFilm = film.IdFilm WHERE cinema.Ville ='"+ville+ "';");
			// Process
			System.out.println(myRes);
			while(myRes.next()) {
				out.print("<p>"+ville + "<br>" +"titre : "+ myRes.getString("Titre")+"<br>" +"date : "+ myRes.getString("Date")+"<br>" +"durée : "+ myRes.getString("Durée")+"<br>" + "salle : "+ myRes.getString("Salle")+ "<br>" +"Langue : "+ myRes.getString("Langue")+ "<br>" +"Age minimum : "+ myRes.getString("MinAge")+"</p>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
