<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h1>Here is your Omikuji!</h1>
    <p>
        In <c:out value="${number}"></c:out> years,<br>
        you will live in <c:out value="${city}"></c:out><br>
        with<c:out value="${person}"></c:out> as your roommate,<br>
        <c:out value="${hobby}"></c:out> for a living.<br>
        The next time you see a <c:out value="${thing}"></c:out>,<br>
        you will have good luck.<br>
        Also, <c:out value="${nice}"></c:out><br>
    </p>
    <a href="/">Back</a>
</body>
</html>