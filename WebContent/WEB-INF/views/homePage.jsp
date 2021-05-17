<%@page import="it.beije.makemake.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
</head>
<body>

<jsp:useBean id="loggedUser" class="it.beije.makemake.User" scope="session"/>

<%
//User loggedUser = (User) session.getAttribute("loggedUser");
if (loggedUser == null) {
	response.sendRedirect("loginEcommerce.jsp");
}
%>


<TABLE WIDTH="75%" ALIGN="center">
  <TR>
<TD>
<DIV ALIGN="center">
<h1>Benvenuto</h1></DIV>
<DIV ALIGN="justify">
<a>

Ciao ${User.name}, benvenuto nel nostro Ecommerce!!!
</a>
<h1>Seleziona l' operazione da effettuare</h1>



	
	<ul>
	<li>
	<a href="viewproduct">Visualizza Prodotti</a>
	</li>
	<li>
	<a href="vieworder">Visualizza Ordini</a>
	</li>
	<li>
	<a href="createorder">Effettua un Ordine</a>
	</li>
	</ul>
		
		
		
		
	<a href="logOut"> LOGOUT</a>
</DIV>
</TD>
</TR>
</TABLE>
</body>
</html>