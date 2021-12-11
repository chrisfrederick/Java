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
    <h1>JSP Page</h1>
    <table style="border: 1px solid black">
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Action</th>
        </tr>
        <c:forEach var="language" items="${language}">
            <tr>
                <td><a href="/languages/${language.id}">${language.name}</a></td>
                <td>${language.creator}</td>
                <td>${language.currentVersion} </td>
                <td>
                    <a href="/languages/edit/${language.id}">edit</a>
                    <form action="/languages/destroy/${language.id}" method="post">
                        <input type="hidden" name="_method" value="destroy">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/languages/new">Create a new entry</a>
</body>
</html>