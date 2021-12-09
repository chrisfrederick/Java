<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
<h1>PokeBook</h1>

<table style="border: 1px solid black">
    <tr>
        <th>Expense</th>
        <th>Vendor</th>
        <th>Amount</th>
    </tr>
    <c:forEach var="expense" items="${expense}">
    <tr>
        <td>${expense.expenseName}</td>
        <td>${expense.vendor}</td>
        <td>${expense.amount}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>