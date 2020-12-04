<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<header><a href ="http://localhost:8080/CinemaProjet/">Accueil</a></header>
	 <h1>Login</h1>
	 <form action="http://localhost:8080/CinemaProjet/loginServlet" method="post" target ="hiddenFrame">
		<label for="user">User :</label>
		<input name="user" />
		<br/>
		<label for="password">Password : </label>
		<input name="password" />
		<br />
	 <input type="submit" value="Connection">
	 </form><br>
	 <iframe name="hiddenFrame" ></iframe>
	 
</body>
</html>