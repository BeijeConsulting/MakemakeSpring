<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<title>Ecommerce - Register</title>
<style type="text/css">
	button {
		margin-top: 20px;
	}
	
	p {
		font-weight: bold;
		color: red;
	}
</style>
</head>
<body>
<div class="container">
<h1>Register</h1><br>
<form class="row g-3" action="postRegister" method="post">
  <c:if test="${errore != null}">
  	<p>${errore}</p>
  </c:if>
  <div class="col-md-6">
    <label for="username" class="form-label">Username</label>
    <input type="text" class="form-control" id="username" name="username">
  </div>
  <div class="col-md-6">
    <label for="password" class="form-label">Password</label>
    <input type="password" class="form-control" id="password" name="password">
  </div>
  <div class="col-12">
    <label for="name" class="form-label">Name</label>
    <input type="text" class="form-control" id="name" name="name">
  </div>
  <div class="col-12">
    <label for="surname" class="form-label">Surname</label>
    <input type="text" class="form-control" id="surname" name="surname">
  </div>
  <div class="col-12">
    <button type="submit" class="btn btn-primary">Sign up</button>
  </div>
</form>
</div>
</body>
</html>