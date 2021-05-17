<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="createorder" method="post">

  <table>
  <tr>
  <th>
  NAME
  </th>
  <th>
  BRAND
  </th>
  <th>
  PRICE
  </th>
  <th>
  DESC
  </th>
  <th>
  QUANTITY
  </th>
  <th></th>
  </tr>
  <tr>
  <c:forEach items="${prodotti}" var="prodotto">
           
                <td> ${prodotto.name} </td>
                <td> ${prodotto.brand} </td>
                <td> ${prodotto.price} </td>
                <td> ${prodotto.desc} </td>
                <td> ${prodotto.quantity} </td>
                <td><input type="number" name=${prodotto.quantity}></td>
                <td><input type="checkbox" name="serviceBox"
                    value="${prodotto.id}" /></td>
            
        </c:forEach>
        </tr></table>
<input type="submit" value="BUY">
</form> 



<a href="home">torna alla Home</a><br><br>
<a href="logOut"> LOGOUT</a>
</body>
</html>