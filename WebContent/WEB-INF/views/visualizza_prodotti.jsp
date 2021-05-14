<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${prodotti}" var="prodotto">
id: ${prodotti.id}<br>
name: ${prodotti.name}<br>
brand: ${prodotti.brand}<br>
description: ${prodotti.description}<br>
price: ${prodotti.price}<br>
quantity: ${contatto.quantity}<br>
<br><br><br>
</c:forEach>
</body>
</html>