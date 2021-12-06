<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Counter</title>
</head>
<link>
    <h1>You have visited http://8080 <c:out value="${countToShow}"></c:out> times</h1>
    <a href="/">Test Another Visit?</a>

</body>
</html>