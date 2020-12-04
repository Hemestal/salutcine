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
 * Servlet implementation class AjoutSeanceServlet
 */
@WebServlet("/AjoutSeanceServlet")
public class AjoutSeanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutSeanceServlet() {
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
		String film = request.getParameter("film");
		String date = request.getParameter("date");
		String heure = request.getParameter("heure");
		String salle = request.getParameter("salle");

		
		String url = "jdbc:mysql://localhost:3306/cinema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		try {
			// 1 Connection
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection(url,"root","admin");
			// 2 Statement
			Statement myStm= myConn.createStatement();
			// Query 
			ResultSet myRes = myStm.executeQuery("SELECT * FROM cinema WHERE Ville ='"+ville+"';");
			String cineID="0";
			while(myRes.next()) {
				cineID = myRes.getString("IdCinema");
				System.out.println(cineID);
			}
			
			ResultSet myRes2 = myStm.executeQuery("SELECT * FROM film WHERE Titre ='"+film+"';");
			String filmID="0";
			while (myRes2.next()) {
				filmID = myRes2.getString("IdFilm");
				System.out.println(filmID);
			}
			System.out.println(cineID);
			System.out.println(filmID);

			myStm.executeUpdate("INSERT INTO seance (IdCinema, IdFilm, Date, Heure, Salle) VALUES ('"+cineID+"', '"+filmID+"', '"+date+"', '"+heure+"', '"+salle+"');");
			
			out.print("<p>Séance ajoutée</p>");

		}catch(Exception e){
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
