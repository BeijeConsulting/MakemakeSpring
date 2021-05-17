<%@page import="it.beije.makemake.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>I TUOI ORDINI</title>
</head>
<body>
<jsp:useBean id="loggedUser" class="it.beije.makemake.User" scope="session"/>

<%
if (loggedUser == null)
	response.sendRedirect("login_ecommerce");
%>
	<h4>RIEPILOGO DEGLI ORDINI EFFETTUATI</h4>
	<br>
numero ordini effettuati : ${numOrdini}<br>
<br>
<form action="visualizza_prodotti" method="POST">
<c:forEach items="${ordini}" var="ordine">
id: ${ordine.id}<br>
date: ${ordine.date}<br>
status: ${ordine.status}<br>
total: ${ordine.total}<br>
<input type="radio" name="idOrdine" value=${ordine.id}> 
<br><br><br>
</c:forEach>
<input type="submit" value="Submit">
	</form>
</body>
</html>