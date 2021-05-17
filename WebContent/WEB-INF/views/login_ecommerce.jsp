<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina di login</title>
</head>
<body>

<a>Beije-Shop: inserisci le credenziali</a>
${errore}
<form action="login" method="POST">
  <label for="username">username:</label><br>
  <input type="text" name="username"><br>
  <label for="password">password:</label><br>
  <input type="password" name="password"><br><br>
  <input type="submit" value="Submit"><br><br>
  
   <a href="registrazione">se non hai un account, registrati</a>
</form> 
</body>
</html>