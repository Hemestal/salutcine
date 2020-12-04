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
            <li class="nav-item active">
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
 <h1>Cinema par ville</h1>
<main class="container-fluid mt-5">
    <div class="container px-3">
    <div class="raw">
  <form action="MaServlet" method="post" target ="hiddenFrame">
    <div class="input-group-prepend ">
    <label class="input-group-text" for="inputGroupSelect01">Choose a city</label>
     </div>
  <select class="custom-select" name="ville" size="4">
  <option value="Villejuif">Villejuif</option>
  <option value="Toulouse">Toulouse</option>
  <option value="Marseille">Marseille</option>
  <option value="Serris">Serris</option>
  </select>
   <input type="submit" value="submit" class="btn btn-taupe">
 </form>
 <div class="embed-responsive embed-responsive-1by1">
   <iframe name="hiddenFrame" class="embed-responsive-item"></iframe>
   </div>
 </div>
 </div>
 </main>
</body>
</html>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>