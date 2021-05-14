<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista dei contatti</title>
</head>
<body>
	<h1 style="text-align: center;">Lista dei contatti</h1>
	<c:forEach items="${contatti}" var="contatto">
		name: ${contatto.name}<br>
		surname: ${contatto.surname}<br>
		telephone: ${contatto.telephone}<br>
		email: ${contatto.email}<br>
		<br><br>
	</c:forEach>
</body>
</html>