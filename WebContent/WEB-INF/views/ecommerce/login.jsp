<%--
  Created by IntelliJ IDEA.
  User: Padawan08
  Date: 12/05/2021
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
    <style type="text/css">
    .error{
    	color:red;
    }
     .notice{
    	color:yellow;
    }
    </style>
</head>
<body>

<h1 class = "error">${error}</h1>
<h1 class = "notice">${notice}</h1>

<form action="${pageContext.request.contextPath}/ecommerce/login" method="post">
	
  <label for="username">Username:</label><br>
  <input type="text" name="username"><br>
  <label for="password">Password:</label><br>
  <input type="password" name="password"><br><br>
  <input type="submit" value="Submit">
	 <h5>Non sei registrato ? Puoi farlo <a href= '${pageContext.request.contextPath}/ecommerce/registration'>  qui</a></h5>
</form>

</body>
</html>
