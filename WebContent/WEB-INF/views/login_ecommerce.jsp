<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pagina di login</title>
</head>
<body>
	<TABLE WIDTH="75%" ALIGN="left">
  		<TR>
			<TD>
			<DIV ALIGN="left">
			Beije-Shop: inserisci le credenziali<br><br>
			${errore}
			<form action="login" method="POST">
  				<label for="username">username:</label><br>
  				<input type="text" name="username"><br>
 				<label for="password">password:</label><br>
  				<input type="password" name="password"><br><br>
  				<input type="submit" value="Login"><br><br>
  				<br><br>
   				<a href="registrazione">se non hai un account, registrati</a>
   			</form> 
			</DIV>
			</TD>
		</TR>
	</TABLE>
</body>
</html>