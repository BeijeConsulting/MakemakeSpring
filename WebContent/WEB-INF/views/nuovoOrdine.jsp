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
<form action="createorder" method="post">

  <table>
  <tr>
	<th>Product id</th>
	<th>Name</th>
	<th>Brand</th>
	<th>Description</th>
	<th>Price</th>
	<th>Available quantity</th>
	<th> </th>
</tr>
<c:forEach items="${prodotti}" var="prodotto">
  <tr>
    <td>${prodotto.id}</td>
    <td>${prodotto.name}</td>
    <td>${prodotto.brand}</td>
    <td>${prodotto.desc}</td>
    <td>${prodotto.price}</td>
    <td>${prodotto.quantity}</td>
    <td></td></tr>
    </c:forEach>
       
</table>
<input type="submit" value="BUY">
</form> 


<a href="home">torna alla Home</a><br><br>
<a href="logOut"> LOGOUT</a>
</body>
</html>