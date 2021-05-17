<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>

<h5 style='color:red'>${errore}</h5>

<%
String successfulRegistration = (String) session.getAttribute("registrationResult");

if (successfulRegistration != null) {
	%>
	<h6 style='color:green'><%= successfulRegistration %></h6>
	<%
	session.removeAttribute("registrationResult");
}
%>

<form action="login" method="post">
  <label for="username">username:</label><br>
  <input type="text" name="username"><br>
  <label for="password">password:</label><br>
  <input type="password" name="password"><br><br>
  <input type="submit" value="Submit">
</form> 
<h5>Non sei registrato? Puoi farlo <a href='registrati'>qui</a></h5>

</body>
</html>