<%--
  Created by IntelliJ IDEA.
  User: Padawan08
  Date: 12/05/2021
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
</head>
<body>

<h3>Welcome, ${user.name}</h3>
<br>

<form action="${pageContext.request.contextPath}/ecommerce/orders">
    <input type="submit" value="View orders">
</form>

<form action="${pageContext.request.contextPath}/ecommerce/view_products">
    <input type="submit" value="Create order">
</form>

<form action="${pageContext.request.contextPath}/ecommerce/logout">
    <input type="submit" value="Logout">
</form>

</body>
</html>
