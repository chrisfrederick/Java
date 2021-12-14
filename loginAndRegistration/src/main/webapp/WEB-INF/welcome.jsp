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
    <h1>Welcome ${userName}!</h1>
    <h3>Books from everyones shelves</h3>

    <table class="table">
        <tr>
            <th>Id </th>
            <th>Title </th>
            <th>Author Name </th>
            <th>Posted By </th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <c:forEach var="book" items="${user.books}">
                    <td>${book.id}</td>
                    <td><a href="/books/${book.id}">${book.title}</a></td>
                    <td>${book.author}</td>
                    <td>${user.userName}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>


    <a href="/books/new">+ Add a book to my shelf!</a>



    <form action="/logout" method="post">
        <input type="hidden" name="_method" value="logout">
        <input type="submit" value="Logout">
    </form>
</body>
</html>

