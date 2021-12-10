<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h1>Expense Details</h1>
    <p>Expense Name: ${expense.expenseName}</p><br>
    <p>Expense Desription: ${expense.description}</p><br>
    <p>Vendor: ${expense.vendor}</p><br>
    <p>Amount Spent: ${expense.amount}</p><br>
    <a href="/expense">Home</a>
    <form action="/expense/destroy/${expense.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete Expense">
    </form>

</body>
</html>