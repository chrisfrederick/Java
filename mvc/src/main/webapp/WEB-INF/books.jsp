<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h1>All Books</h1>
    <table style="border: 1px solid black">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Language</th>
            <th># of Pages</th>
        </tr>
        <c:forEach var="books" items="${books}">
        <tr>
            <td>${books.id}</td>
            <td>${books.title}</td>
            <td>${books.language}</td>
            <td>${books.numberOfPages}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>