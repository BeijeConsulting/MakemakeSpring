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
	<form action="benvenuto" method="POST">
		<input type="radio" name="operazione" value="visualizza_ordini"> 
			<label for="visualizza">Visualizza Ordini</label><br>
		<input type="radio" name="operazione" value="ricerca">
			<label for="ricerca">Ricerca un prodotto</label><br>
		<input type="radio" name="operazione" value="aggiungi"> 
			<label for="aggiungi">Visualizza un ordine</label><br> 
		<input type="submit" value="Submit">
	</form>
</body>
</html>