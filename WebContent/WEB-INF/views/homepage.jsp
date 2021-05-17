<%@page import="it.beije.makemake.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
	<jsp:useBean id="loggedUser" class="it.beije.makemake.entity.User"
		scope="session" />
	<%
	User user = (User) session.getAttribute("loggedUser");
	%>
	<h3>Benvenuto, ${displayName}</h3>
	<a href=''>Visualizza i prodotti</a><br>
	<a href=''>Il mio carrello</a><br>
	<a href=''>I miei ordini</a><br>
	<a href='modifica_utente'>Modifica profilo</a><br>
	<a href=''>Elimina profilo</a><br><!-- actually "disabilita" il profilo -->
	<a href="logout">Esci</a><br>
</body>
</html>