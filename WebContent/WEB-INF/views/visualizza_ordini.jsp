<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista dei prodotti</title>
</head>




<body>
	<Div align="right">
		<a href="homepage"> torna alla HomePage </a>
	</Div>
	<br>
	<br>
	<h3>
		ECCO LA LISTA DEGLI ORDINI EFFETTUATI NELL'ECOMMERCE BEIJE<br>
		<br>
	</h3>
	<form action="viewOrderDetails" method="GET">
	<TABLE>
		<tr>
			<td style="width:10%;font-weight:bold ">Id</td>
			<td style="width:20%;font-weight:bold">Date</td>
			<td style="width:20%;font-weight:bold">Status</td>
			<td style="width:20%;font-weight:bold">Total</td>
		</tr>
		<c:forEach items="${orders}" var="order">
			<TR>
				<td>${order.id}</td>
				<td>${order.date}</td>
				<td>${order.status}</td>
				<td>${order.total}</td>
				<td><input type="radio" name="order" value="${order.id}"></td>
			</TR>
		</c:forEach>

	</TABLE>
	<input type ="submit" value="Visualizza dettagli">
	</form>
</body>
</html>