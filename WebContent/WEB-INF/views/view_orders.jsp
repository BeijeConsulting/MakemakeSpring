<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ordini effettuati</title>
	</head>
	<body>
		<c:forEach items="${orderMap.keySet()} var="order">
		
		</c:forEach>
		
	
	</body>
</html>