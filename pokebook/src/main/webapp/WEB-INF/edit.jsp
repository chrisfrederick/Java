<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>

<h1>Edit An Expense</h1>
<form:form action="/expense/${expense.id}" method="post" modelAttribute="expense">
    <input type="hidden" name="_method" value="put">
    <form:input type="hidden" path="id" value="${expense.id}"/>
    <p>
        <form:label path="expenseName">Expense Name</form:label>
        <form:errors path="expenseName"/>
        <form:input path="expenseName"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>
        <form:input path="amount"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:input  path="description"/>
    </p>
    <input type="submit" value="Submit"/>
    <a href="/expense">Back</a>
</form:form>
</body>
</html>