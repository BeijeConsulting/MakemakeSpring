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
<c:forEach items="${ordini}" var="ordine">
date: ${ordine.date}<br>
userId: ${ordine.userId}<br>
status: ${ordine.status}<br>
total: ${ordine.total}<br><br>
</c:forEach>



<a href="home">torna alla Home</a><br><br>
<a href="logOut"> LOGOUT</a>
</body>
</html>