<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<CENTER><H1>Ecommerce </H1>

<form action="login_ecommerce" method="post">
  <label for="username">username:</label><br>
  <input type="text" name="username"><br>
  <label for="password">password:</label><br>
  <input type="password" name="password"><br><br>
  <input type="submit" value="Accedi">
</form> 
<form action="registrati.jsp" method="post">
  <input type="submit" value="Registrati">
</form> </CENTER>

</body>
</html>