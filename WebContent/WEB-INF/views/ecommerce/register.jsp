<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style type="text/css">
    .error{
    	color:red;
    }
     .notice{
    	color:yellow;
    }
    </style>
</head>
<body>
<h1 class = "error">${error}</h1>
<h1 class = "notice">${notice}</h1>

<form action="${pageContext.request.contextPath}/ecommerce/register" method="post">
 <label for="nome">Nome:</label><br>
  <input type="text" name="name"><br>
   <label for="cognome">Cognome:</label><br>
  <input type="text" name="surname"><br>
  <label for="username">Username:</label><br>
  <input type="text" name="username"><br>
  <label for="password">Password:</label><br>
  <input type="password" name="password"><br><br>
  <input type="submit" value="Submit">
</form> 
</body>
</html>