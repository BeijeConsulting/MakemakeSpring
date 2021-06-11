<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>I nostri prodotti</title>
</head>
<body>
	<c:forEach items="${products}" var="prodotto">
		<!-- TODO aggiungere id nel href dopo dettaglio prodotto -->
		<form action="dettaglio_prodotto" method="get">
			<button type="submit" name="id" value="${prodotto.id}"
				class="btn-link">${prodotto.brand} ${prodotto.name}</button>
		</form>
	Prezzo: ${prodotto.price}€<br>
	Quantità disponibile: ${prodotto.quantity}<br>
	</c:forEach>
</body>
</html>