<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN</title>
</head>
<body>

${errore}

<form action="login" method="post">
  <label for="username">username:</label><br>
  <input type="text" name="username"><br>
  <label for="password">password:</label><br>
  <input type="password" name=pwd><br><br>
  <label for="number">number:</label><br>
  <input type="text" name="number"><br><br>
  <input type="submit" value="Submit">
</form> 

</body>
</html>