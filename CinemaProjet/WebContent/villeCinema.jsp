<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
  .hide { position:absolute; top:-1px; left:-1px; width:1px; height:1px; }
</style>
<title>Cin� par ville</title>
</head>
<body>

 <h1>Cinema par ville</h1>
 <form action="MaServlet" method="post" target ="hiddenFrame">
 Ville :  
<select  name="ville" size="4">
  <option value="Villejuif">Villejuif</option>
  <option value="Toulouse">Toulouse</option>
  <option value="Marseille">Marseille</option>
  <option value="Serris">Serris</option>
</select> <br>
 
 <input type="submit" value="submit">
 </form><br>
 <iframe name="hiddenFrame" ></iframe>
</body>
</html>