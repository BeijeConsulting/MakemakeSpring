<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="loggedUser" class="it.beije.makemake.User" scope="session"/>

<%
if (loggedUser == null) 
	response.sendRedirect("login_ecommerce");
%>

<c:forEach items="${prodotti}" var="prodotto">
id: ${prodotto.id}<br>
name: ${prodotto.name}<br>
price: ${prodotto.price}<br>
description: ${prodotto.description}<br>
image: ${prodotto.image}<br>
quantity: ${prodotto.quantity}<br>
brand: ${prodotto.brand}<br>

<br><br><br>
</c:forEach>
</body>
</html>