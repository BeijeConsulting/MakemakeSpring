<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DELETE</title>
</head>
<body>

<form action="delete_contatto" method="post">
  <label for="name">name:</label><br>
  <input type="text" name="name"><br>
  <label for="surname">surname:</label><br>
  <input type="text" name="surname"><br><br>
  <label for="telephone">telephone:</label><br>
  <input type="text" name="telephone"><br><br>
  <label for="email">email:</label><br>
  <input type="text" name="email"><br><br>
  
  <input type="submit" value="Submit">
</form> 
</body>
</html>