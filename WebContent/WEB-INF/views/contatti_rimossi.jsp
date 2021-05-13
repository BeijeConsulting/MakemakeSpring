<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CANCELLAZIONE EFFETTUATA</title>
</head>
<body>
<br>
<c:forEach items="${contattirimossi}" var="contatto">
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