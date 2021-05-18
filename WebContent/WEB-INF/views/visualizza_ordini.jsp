<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista dei prodotti</title>
</head>




<body>
	<TABLE WIDTH="75%" ALIGN="center">
		<tr>
			<td>
				<Div align="right" > <a href="homepage"> torna alla HomePage </a></Div>
			<td>
		</tr>
		<tr>
			<th>ECCO LA LISTA DEGLI ORDINI EFFETTUATI NELL'ECOMMERCE BEIJE<br></th>
		</tr>
  		<TR>
			<TD>
			<DIV ALIGN="left">
				<c:forEach items="${orderDetails}" var="orderdetail">
					order Id: ${orderdetail.orderId}<br>
					name: ${orderdetail.name}<br>
					brand: ${orderdetail.brand}<br>
					quantity: ${orderdetail.orderItemQuantity}<br>
					description: ${orderdetail.description}<br>
					<br><br>
				</c:forEach>
			</DIV>
			</TD>
		</TR>
	</TABLE>
</body>
</html>