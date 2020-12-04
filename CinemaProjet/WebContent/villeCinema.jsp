<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
  .hide { position:absolute; top:-1px; left:-1px; width:1px; height:1px; }
</style>
<title>Ciné par ville</title>
</head>
<body>
	<header><a href ="http://localhost:8080/CinemaProjet/">Accueil</a></header>
	 <h1>Cinema par ville</h1>
	 <form action="MaServlet" method="post" target ="hiddenFrame">
	 Ville :  
	<select  name="ville" size="4">
	  <option value="Villejuif">Villejuif</option>
	  <option value="Toulouse">Toulouse</option>
	  <option value="Marseille">Marseille</option>
	  <option value="Serris">Serris</option>
	</select> <br>
	 
	 <input type="submit" value="Rechercher">
	 </form><br>
	 <iframe name="hiddenFrame" ></iframe>
</body>
</html>