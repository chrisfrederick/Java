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
    <title>Edit Show</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <p><c:out value="${loggedout}${notLoggedIn}"></c:out></p>
    <h1>Edit ${tvShow.title}</h1>
    <form:form action="/update/${tvShow.id}" method="post" modelAttribute="tvShow">
        <input type="hidden" name="_method" value="put">
        <form:input type="hidden" path="id" value="${tvShow.id}"/>
        <form:hidden value="${userId}" path = "user"></form:hidden>
        <p>
            <form:label path="title">Title</form:label>
            <form:errors path="title"/>
            <form:input path="title"/>
        </p>
        <p>
            <form:label path="network">Network</form:label>
            <form:errors path="network"/>
            <form:input path="network"/>
        </p>
        <p>
            <form:label path="description">Description</form:label>
            <form:errors path="description"/>
            <form:input  path="description"/>
        </p>
        <input type="submit" value="Update"/>
        <a href="/dashboard">Cancel</a>
    </form:form>
    <form action="/shows/destroy/${tvShow.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete Show From Database">
    </form>
</body>
</body>
</html>

