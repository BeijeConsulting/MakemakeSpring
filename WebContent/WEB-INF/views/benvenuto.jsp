<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BENVENUTO</title>
</head>
<body>
<jsp:useBean id="loggedUser" class="it.beije.makemake.User" scope="session"/>

<%
if (loggedUser == null) 
	response.sendRedirect("login_ecommerce");
%>
	<h1>BENVENUTO!!!</h1>
	<a href="http://localhost:8080/MakemakeSpring/visualizza_ordini">Visualizza Ordini</a><br><br>
	<a href="http://localhost:8080/MakemakeSpring/visualizza_utente">Visualizza dettagli utente</a><br><br>
	<a href="http://localhost:8080/MakemakeSpring/visualizza_prodotti">Visualizza prodotti</a><br><br>
	
</body>
</html>