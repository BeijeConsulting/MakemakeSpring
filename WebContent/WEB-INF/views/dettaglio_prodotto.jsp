<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettagli del prodotto: Prodotto</title>
</head>
<body>

<br>
numero prodotti : ${prodotto.name} ${prodotto.brand}<br>
<br>
name: ${prodotto.name}<br>
brand: ${prodotto.brand}<br>
description : ${prodotto.descr}<br>
price : ${prodotto.price}<br>
quantity : ${prodotto.quantity}<br>
<br><br><br>

<form action="add_to_car" method="post">
 <label for="quantity">quantity:</label><br>
 <input type="number" name="quantity" min="1" max="${prodotto.quantity}"><br>
 <input type="submit" value="Aggiungi al Carrello">
</form>
</body>
</html>