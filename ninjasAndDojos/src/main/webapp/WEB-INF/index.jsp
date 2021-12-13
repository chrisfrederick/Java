<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
        <h1>Welcome to Dojos and Ninjas!</h1>
        <a href="/dojos/new">Start by Creating a Dojo Location Here!</a>
        <h2>Or, If the dojo you want exists, add your name here!</h2>
        <a href="/ninjas/new">Add your name to a Dojo Location</a>
        <h2>To view all Ninjas in a location, Click on the city</h2>
        <c:forEach var="dojo" items="${dojos}">
            <p><a href="/dojos/${dojo.id}">${dojo.name}</a></p>
        </c:forEach>
</body>
</html>

