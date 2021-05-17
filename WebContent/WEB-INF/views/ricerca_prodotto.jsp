<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca prodotto</title>
</head>
<body>
${errore}
<Div align="right" > <a href="homepage"> torna alla HomePage </a></Div>



<form action="ricerca_prodotto" method="post">
  <label for="name">name:</label><br>
  <input type="text" name="name"><br>
   <input type="submit" value="Submit">
   </form>
   
<c:forEach items="${lista_prodotti}" var="prodotto">
id: ${prodotto.id}<br>
name: ${prodotto.name}<br>
brand: ${prodotto.brand}<br>
description: ${prodotto.desc}<br>
price: ${prodotto.price}<br>
quantity: ${prodotto.quantity}<br>
<br><br><br>
</c:forEach>
   
</body>
</html>