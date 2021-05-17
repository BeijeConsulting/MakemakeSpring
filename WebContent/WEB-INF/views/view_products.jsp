<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products list</title>
</head>
<body>
	
	${errore}
	<c:if test="${errore ==null }">
		<table>
			<tr>
				<th>Product id</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Description</th>
				<th>Image</th>
				<th>Quantity</th>
			</tr>		
		<c:forEach items="${products}" var="product">
			<tr>	
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.brand}</td>
				<td>${product.description}</td>
				<td>${product.image}</td>
				<td>${product.quantity}</td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
	
</body>
</html>