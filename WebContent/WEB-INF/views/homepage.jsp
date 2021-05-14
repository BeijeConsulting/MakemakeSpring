<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>homepage</title>
</head>
<body>

<TABLE WIDTH="75%" ALIGN="center">
  <TR>
<TD>
<DIV ALIGN="center">
<h1>BENVENUTO ${username}</h1></DIV>
<DIV ALIGN="justify">


<form action="menuEcommerce" method="POST" >
 	 	
 	 	<input type="radio" id="visualizza" name="operazione" value="visualizza_prodotti">
 		<label for="visualizza">Visualizza Prodotti</label><br>
  		<input type="radio" id="ricerca" name="operazione" value="ricerca">
  		<label for="ricerca">Ricerca un prodotto</label><br>
  		<input type="radio" id="aggiungi" name="operazione" value="aggiungi">
  		<label for="aggiungi">Visualizza un ordine</label><br>
	
		<input type="submit" value ="Submit">
	</form>
	</DIV>
</TD>
</TR>
</TABLE>
</body>
</html>