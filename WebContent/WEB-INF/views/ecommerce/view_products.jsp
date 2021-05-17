<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
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
        .error{
    	color:red;
    }
     .notice{
    	color:yellow;
    }
  </style>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
<table>
<tr>    
	<th>Product id</th>    
	<th>Name</th>    
	<th>Brand</th>    
	<th>Description</th>    
	<th>Price</th>
	<th>Available quantity</th>
	<th> </th>
</tr>
<c:forEach items="${Products}" var="product">
  <tr>
    <td>${product.id}</td>
    <td>${product.name}</td>
    <td>${product.brand}</td>
    <td>${product.desc}</td>
    <td>${product.price}</td>
    <td>${product.quantity}</td>
    <td>
        <a href="${pageContext.request.contextPath}/ecommerce/buyProduct?productId=${product.id}">
            <button>Buy</button>
        </a>
            </td>
  </tr>
</c:forEach>
</table>
<h3 class="notice">${notice}</h3>
 <h3 class="error">${error}</h3>
<form action="${pageContext.request.contextPath}/ecommerce/sendOrder">
    <input type="submit" value="Send order">

</form><br>
 <a href="${pageContext.request.contextPath}/ecommerce/">
            <button>Home</button>
        </a>
</body>
</html>