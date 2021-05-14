<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="it.beije.makemake.ecommerce.Order" %><%--
  Created by IntelliJ IDEA.
  User: Ricky
  Date: 14/05/2021
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--  <c:url value="css/style.css" var="jstlCss" />--%>
<%--  <link href="${jstlCss}" rel="stylesheet" >--%>
  <style>
    table {
      font-family: arial, sans-serif;
      border-collapse: collapse;
      width: 100%;
    }

    td, th {
      border: 1px solid #dddddd;
      text-align: left;
      padding: 8px;
    }

    tr:nth-child(even) {
      background-color: #dddddd;
    }
  </style>
  <title>Orders</title>
</head>
<body>
<h1>These are your orders:</h1>
<table>
  <tr>
    <th>Id</th>
    <th>Date</th>
    <th>Status</th>
    <th>Total (€)</th>
    <th></th>
  </tr>
<c:forEach items="${orders}" var="order">
  <tr>
    <td>${order.id}</td>
    <td>${order.dateString}</td>
    <td>${order.status}</td>
    <td>${order.total}</td>
    <td><a href="orderdetails.jsp?orderId=${order.id}">
      <button>View order details</button>
    </a></td>
  </tr>
</c:forEach>
</table>

</body>
</html>
