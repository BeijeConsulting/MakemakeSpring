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

<form action="aggiungi_al_carrello" method="POST">
<c:forEach items="${prodotti}" var="prodotto">
id: ${prodotto.id}<br>
name: ${prodotto.name}<br>
price: ${prodotto.price}<br>
description: ${prodotto.description}<br>
image: ${prodotto.image}<br>
quantity: ${prodotto.quantity}<br>
brand: ${prodotto.brand}<br>
  <input type="radio" name="idProdotto" value=${prodotto.id}> 
  <br><br><br>
</c:forEach>
<label for="quantity">Quantità:</label><br>
  <input type="text" name="quantity"><br><br>
<input type="submit" value="Submit">
	</form>



	

</body>
</html>