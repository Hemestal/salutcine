<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.Date" %>
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
            <li class="nav-item active">
                <a class="nav-link" href="login.jsp">Login</a>
            </li>
        </ul>
    </div>
    </nav>
	 <h1 class="mt-5 pt-5">Login</h1>
	 <form action="loginServlet" method="post">
		<label for="user">User :</label>
		<input class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="user" />
		<br/>
		<label for="password">Password : </label>
		<input type="password" class="form-control" id="exampleInputPassword1" name="password">
		<br />
	 <input type="submit" value="Connection" class="btn btn-taupe">
	 </form><br>
	 
</body>
</html>