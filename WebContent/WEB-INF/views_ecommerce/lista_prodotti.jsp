<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Makemake Prodotto</title>
</head>
<body>

<br>
numero prodotti : ${numProdotti}<br>
<br>
<c:forEach items="${prodotti}" var="prodotto">
id: ${prodotto.id}<br>
name: ${prodotto.name}<br>
brand: ${prodotto.brand}<br>
description : ${prodotto.descr}<br>
price : ${prodotto.price}<br>
quantity : ${prodotto.quantity}<br>
<br><br><br>
</c:forEach>

</body>
</html>