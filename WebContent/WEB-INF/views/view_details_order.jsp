<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualizza dettaglio ordine</title>
</head>
<body>
	${errore}
	<c:if test="${errore ==null }">
		<table>
			<tr>
				<th>Item id</th>
				<th>Order id</th>
				<th>Product id</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>		
		<c:forEach items="${items}" var="item">
			<tr>	
				<td>${item.id}</td>
				<td>${item.orderId}</td>
				<td>${item.productId}</td>
				<td>${item.quantity}</td>
				<td>${item.price}</td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
</body>
</html>