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
<c:forEach items="${prodotti}" var="prodotto">
name: ${prodotto.name}<br>
brand: ${prodotto.brand}<br>
price: ${prodotto.price}<br>
desc: ${prodotto.desc}<br><br>
</c:forEach>



<a href="homePage.jsp">torna alla Home</a>
</body>
</html>