<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
<h1>${product.name}</h1>
<h2>${product.brand}</h2>
<p>${product.desc}</p>
<h3>Price : ${product.price} </h3>
<h4>Quantity available : ${product.quantity}</h4>
<form action="${pageContext.request.contextPath}/ecommerce/addToCart" method="post">
    <input type="number" name="amount">
    <input type="hidden" name="productId" value="${product.id}">
    <input type="submit" value="Add to cart">
</form>
</body>
</html>