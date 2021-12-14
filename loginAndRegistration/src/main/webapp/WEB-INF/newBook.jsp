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
    <title>Create</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <form:form action="/create/book" method="post" modelAttribute="newBook">
        <form:hidden value="${userId}" path = "user"></form:hidden>

        <p>
        <p><form:label path="title">Title</form:label></p>
        <p class="text-danger"><form:errors path="title"/></p>
        <form:input path="title"/>
        </p>

        <p>
        <p><form:label path="author">Author</form:label></p>
        <p class="text-danger"><form:errors path="author"/></p>
        <form:input path="author"/>
        </p>

        <p>
        <p><form:label path="thoughts">My Thoughts</form:label></p>
        <p class="text-danger"><form:errors path="thoughts"/></p>
        <form:input path="thoughts"/>
        </p>

        <input type="submit" value="Submit"/>
    </form:form>

    <a href="/welcome">Back to shelf</a>
</body>
</html>

