<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter film</title>
</head>
<body>
	<header><a href ="http://localhost:8080/CinemaProjet/">Accueil</a></header>
	<h1>Ajouter un film</h1>
	<form action="http://localhost:8080/CinemaProjet/AjoutFilmServlet" method="POST" target ="frame">
		<label for="title">Title :</label>
		<input name="title" />
		<br/>
		<label for="durée">Durée</label>
		<input name="durée" />
		<br />
		<label for="langue">Langue</label>
		<input name="langue" />
		<br/>
		<label for="sousTitre">Sous-titre</label>
		<input name="sousTitre" />
		<br/>
		<label for="realisateur">Réalisateur</label>
		<input name="realisateur" />
		<br/>
		<label for="acteur1">Acteur 1</label>
		<input name="acteur1" />
		<br/>
		<label for="acteur2">Acteur 2</label>
		<input name="acteur2" />
		<br/>
		<label for="acteur3">Acteur 3</label>
		<input name="acteur3" />
		<br/>
		<label for="minAge">Age minimum</label>
		<input name="minAge" />
		<br/>
		<input type="submit" value="Submit" />
	</form>
	<iframe name="frame" ></iframe>
	<form action="http://localhost:8080/CinemaProjet/AjoutSeanceServlet" method="POST" target ="frame1">
		<label for="ville">Ville :</label>
		<input name="ville" />
		<br/>
		<label for="film">Film</label>
		<input name="film" />
		<br />
		<label for="date">Date (YYYY-MM-DD)</label>
		<input name="date" />
		<br/>
		<label for="heure">Heure</label>
		<input name="heure" />
		<br/>
		<label for="salle">Salle</label>
		<input name="salle" />
		<br/>
		<input type="submit" value="Submit" />
	</form>
	<iframe name="frame1" ></iframe>
</body>
</html>