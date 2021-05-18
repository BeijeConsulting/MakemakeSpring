<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MODIFICA UTENTE</title>
</head>
<body>

<h5 style='color:red'>${errore}</h5>

<form action="modifica_utente" method="post">
  <label for="name">Nome:</label><br>
  <input type="text" name="name"><br>
  <label for="surname">Cognome:</label><br>
  <input type="text" name="surname"><br>
  <label for="username">Username:</label><br>
  <input type="text" name="username"><br>
  <label for="password">Password:</label><br>
  <input type="password" name="password"><br><br>
  <input type="submit" value="Submit">
</form> 

</body>
</html>