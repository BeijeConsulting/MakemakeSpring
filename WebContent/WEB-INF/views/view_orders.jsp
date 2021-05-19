<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders view</title>
</head>
<body>

${errore}
	<c:if test="${errore ==null }">
		<table>
			<tr>
				<th>Order id</th>
				<th>date</th>
				<th>Id-user</th>
				<th>Status</th>
				<th>Total</th>
				<th> </th>
				
			</tr>		
		<c:forEach items="${orders}" var="order">
			<tr>	
				<td>${order.id}</td>
				<td>${order.date}</td>
				<td>${order.userId}</td>
				<td>${order.status}</td>
				<td>${order.total}</td>
				<td >
					<a href="order_details_page?orderId=${order.id}">
						Visualizza dettaglio  ordine
					</a>
				</td>
			</tr>
		</c:forEach>
		</table>
	</c:if>

</body>
</html>