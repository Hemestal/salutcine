<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>SalutCiné</title>
    <link rel="stylesheet" type="text/css" href="bootstrap.css">
    <meta charset="utf-8">
    <link rel="shortcut icon" type="image/png" href="logo2.png"/>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top" style="background-color: #C8AD7F;">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
          <!-- Début home -->
            <li class="nav-item">
                  <a class="navbar-brand nav-link" href="index.html">
    <img src="logo2.png" width="30" height="30" alt="" loading="lazy">Home
  </a>
            </li>
            <!-- Fin Home -->
            <!-- Début box office dropdown -->
            <li class="nav-item">
                <a class="nav-link" href="villeCinema.jsp">Cinema</a>
            </li>
      <!-- Fin box office dropdown -->
        </ul>
    </div>
    <div class="mx-auto order-0">
        <a class="navbar-brand mx-auto">SalutCiné</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
    <!-- Début login-->
    <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="login.jsp">Login</a>
            </li>
        </ul>
    </div>
    </nav>
    <main class="container-fluid mt-5">
    <div class="container px-3">
    <h1 class="pt-5 pb-3">Ajouter un film</h1>
	<form action="AjoutFilmServlet" method="POST" target ="frame">
		<label for="title">Title :</label>
		<input name="title" />
		<br/>
		<label for="durée">Durée</label>
		<input type="time" name="durée" step="1">
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
		<input type="submit" value="Submit" class="btn btn-taupe"/>
	</form>
	<h1 class="pt-3 pb-3">Ajouter une Séance</h1>
	<form action="AjoutSeanceServlet" method="POST" target ="frame1">
		<label for="ville">Ville :</label>
		<select class="custom-select" name="ville" size="4">
  			<option value="Villejuif">Villejuif</option>
  			<option value="Toulouse">Toulouse</option>
  			<option value="Marseille">Marseille</option>
  			<option value="Serris">Serris</option>
  		</select>
		<br/>
		<label for="film">Film</label>
		<input name="film" />
		<br />
		<label for="date">Date</label>
		<input name="date" type="date">
		<br/>
		<label for="heure">Heure</label>
		<input type="time" name="heure" step="1">
		<br/>
		<label for="salle">Salle</label>
		<input name="salle" />
		<br/>
		<input type="submit" value="Submit" class="btn btn-taupe"/>
	</form>
	<div class="embed-responsive embed-responsive-21by9">
	<iframe name="frame1"></iframe>
	<iframe name="frame" class="pt-5"></iframe>
	</div>
	</div>
    </main>
</body>
</html>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>