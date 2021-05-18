<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<<<<<<< HEAD
	<head>
		<meta charset="ISO-8859-1">
		<title>Home</title>
	</head>
	<body>
		<header>
			<h1>Amazerific</h1>
		</header>
		<main>
				<h1>Benvenuto ${user.username}</h1>
				<p>Scegli l'operazione che vuoi andare a fare</p>
				<ul>
					<li><a href="showproducts">Visualizza prodotti disponibili</a></li>
					<li><a href="chooseproduct">Fai un ordine</a></li>
					<li><a href="cart">Vai al carrello</a>
					<li><a href="*">Dettaglio oridini</a></li>
					<li><a href="Logout.jsp">Fai logout</a></li>
				</ul>
		</main>
		<footer>
		</footer>
	</body>
=======
<head>
<meta charset="ISO-8859-1">
<title>Makemake Home</title>
</head>
<body>
Benvenuto ${user.username}<br>
<a href= "product_page" > [Visualizza prodotti] </a>
<a href= "order_page" > [Cronologia Ordini] </a>
<a href= "logout_page" > [Logout] </a>

</body>
>>>>>>> viscomi_shenouda
</html>