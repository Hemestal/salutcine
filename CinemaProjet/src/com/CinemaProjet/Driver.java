package com.CinemaProjet;

import java.sql.*;
public class Driver {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3308/salutcine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		try {
			// 1 Connection
			Connection myConn = DriverManager.getConnection(url,"root","");
			// 2 Statement
			Statement myStm= myConn.createStatement();
			// Query 
			ResultSet myRes = myStm.executeQuery("SELECT * FROM cinema;");
			// Process
			System.out.println(myRes);
			while(myRes.next()) {
				System.out.println(myRes.getString("Ville"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
