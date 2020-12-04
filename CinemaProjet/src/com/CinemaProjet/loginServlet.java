package com.CinemaProjet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		System.out.println(user);
		System.out.println(password);
		String succes = "0";
		String url = "jdbc:mysql://localhost:3306/cinema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		try {
			// 1 Connection
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection(url,"root","admin");
			// 2 Statement
			PreparedStatement myStm= myConn.prepareStatement("SELECT * FROM user where Login=? AND mdp=?;");
			myStm.setString(1, user);
			myStm.setString(2, password);
			ResultSet myRes = myStm.executeQuery();
			// Process
			System.out.println(myRes);
			String dbPassword=null;
			String dbUser=null;
			while(myRes.next()) {
				dbUser = myRes.getString("Login");
				dbPassword = myRes.getString("mdp");
				System.out.println(dbUser);
				System.out.println(dbPassword);

			}
			if(user.equals(dbUser) && password.equals(dbPassword)) {
				succes="1";
				out.println("Connection réussi");
				
			}
			System.out.println(succes);
			if (succes == "1") {
				out.print("<a href='http://localhost:8080/CinemaProjet/addFilm.jsp'> Acceder à l'interface d'ajout</a><br>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(succes);
		doGet(request, response);

	}
	}
