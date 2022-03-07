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
    <title>Dashboard</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>Welcome ${userName}!</h1>
    <h3>TV Shows</h3>
    <table class="table">
        <tr>
            <th>Show</th>
            <th>Network</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <c:forEach var="show" items="${user.tvShows}">
            <tr>

                    <td><a href="/shows/${show.id}">${show.title}</a></td>
                    <td>${show.network}</td>
            </tr>
            </c:forEach>
        </c:forEach>
    </table>


    <a href="/shows/new">+ Add a show</a>



    <form action="/logout" method="post">
        <input type="hidden" name="_method" value="logout">
        <input type="submit" value="Logout">
    </form>
</body>
</html>

