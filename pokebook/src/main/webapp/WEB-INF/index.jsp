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
        <th>Actions</th>
    </tr>
    <c:forEach var="expense" items="${expense}">
    <tr>
        <td><a href="/expense/${expense.id}">${expense.expenseName}</a></td>
        <td>${expense.vendor}</td>
        <td>${expense.amount} </td>
        <td>
            <a href="/expense/edit/${expense.id}">edit</a>
<%--            <a href="/expense/destroy/${expense.id}">delete</a>--%>
            <form action="/expense/destroy/${expense.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" value="Delete">
            </form>
        </td>

    </tr>
    </c:forEach>
</table>
</body>
</html>