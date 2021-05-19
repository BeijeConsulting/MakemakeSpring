<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>Order details</title>
</head>
<body>
<table>
<tr>    
	<th>Product id</th>    
	<th>Name</th>    
	<th>Brand</th>    
	<th>Price(€)</th>    
	<th>Quantity</th>
</tr>
<c:forEach items="${orderItems}" var="orderItem">
  <tr>
    <td>${orderItem.product.id}</td>
    <td>${orderItem.product.name}</td>
    <td>${orderItem.product.brand}</td>
    <td>${orderItem.price}</td>
    <td>${orderItem.quantity}</td>
  </tr>
</c:forEach>
</table>
</body>
</html>