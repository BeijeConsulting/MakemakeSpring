<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="loggedUser" class="it.beije.makemake.User" scope="session"/>

<%
if (loggedUser == null) 
	response.sendRedirect("login_ecommerce");
%>

name : <%= loggedUser.getName() %><br>
surname : <%= loggedUser.getSurname() %><br>
username : <%= loggedUser.getUsername() %><br>

<%--password : <%= loggedUser.getPassword() %><br> --%>

</body>
</html>