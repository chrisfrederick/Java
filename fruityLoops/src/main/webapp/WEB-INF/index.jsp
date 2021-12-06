<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>First JSP</title>
</head>
<body>
    <h1>Fruit Store</h1>
    <c:forEach var="item" items="${itemList}">
        <p>Item:<c:out value="${item.name}"></c:out> </p>
    </c:forEach>
</body>
</html>