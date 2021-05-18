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
	<TABLE WIDTH="75%" align="center">
		<tr>
			<td><Div align="right" > <a href="homepage"> torna alla HomePage </a></Div></td>
		</tr>
		<tr>
			<td>ECCO LA LISTA DEI PRODOTTI DELL'ECOMMERCE BEIJE<br></td>
		</tr>
  		<tr>
			<td>
			
			<br><br>
			<DIV ALIGN="left">
				<c:forEach items="${prodotti}" var="prodotto">
					name: ${prodotto.name}<br>
					brand: ${prodotto.brand}<br>
					description: ${prodotto.desc}<br>
					price: ${prodotto.price}<br>
					quantity: ${prodotto.quantity}<br>
				<br><br><br>
				</c:forEach>
			</DIV>
			</td>
		</tr>
	</TABLE>
</body>
</html>