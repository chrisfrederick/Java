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
    <form:form action="/expenses" method="post" modelAttribute="expense">
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
    </form:form>
</body>
</html>