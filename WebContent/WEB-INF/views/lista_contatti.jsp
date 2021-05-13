<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Makemake Contatto</title>
</head>
<body>

<br>
numero contatti : ${numContatti}<br>
<br>
<c:forEach items="${contatti}" var="contatto">
id: ${contatto.id}<br>
name: ${contatto.name}<br>
surname: ${contatto.surname}<br>
telephone: ${contatto.telephone}<br>
email: ${contatto.email}<br>
full name: ${contatto.fullName}
<br><br><br>
</c:forEach>
</body>
</html>