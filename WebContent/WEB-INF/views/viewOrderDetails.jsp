<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettaglio Ordine</title>
</head>
<body>

	<table>
			<tr>
				<td style="width:10%;font-weight:bold ">Name</td>
				<td style="width:10%;font-weight:bold ">Brand</td>
				<td style="width:10%;font-weight:bold ">Quantity</td>
				<td style="width:10%;font-weight:bold ">Price</td>
				
			</tr>
			<c:forEach items="${orderDetails}" var="ord">
			<tr>
					<td>${ord.name}</td>
					<td>${ord.brand}</td>
					<td>${ord.orderItemQuantity}</td>
					<td>${ord.price}</td>
			</tr>
			</c:forEach>
		</table>
			<Div align="center" > <a href="homepage"> torna alla HomePage </a></Div>
</body>
</html>