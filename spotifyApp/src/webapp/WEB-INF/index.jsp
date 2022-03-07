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
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div>
    <div id="login">
        <h1>First, log in to spotify</h1>
        <a href="/login">Log in</a>
    </div>
    <div id="loggedin">
    </div>
</div>
<script id="loggedin-template" type="text/x-handlebars-template">
    <h1>Logged in as </h1>
    <img id="avatar" width="200" src="" />
    <dl>
        <dt>Display name</dt><dd></dd>
        <dt>Username</dt><dd></dd>
        <dt>Email</dt><dd></dd>
        <dt>Spotify URI</dt><dd><a href=""></a></dd>
        <dt>Link</dt><dd><a href=""></a></dd>
        <dt>Profile Image</dt><dd></dd>
    </dl>
    <p><a href="/">Log in again</a></p>
</script>
</body>
</html>

