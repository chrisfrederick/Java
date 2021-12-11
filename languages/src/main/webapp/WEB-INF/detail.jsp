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
    <h1>Language Detail</h1>
    <p>
        Language Name: ${language.name}<br>
        Creator: ${language.creator}<br>
        Version: ${language.currentVersion}<br>
    </p>
    <a href="/languages">Home</a><br>
    <form action="/languages/destroy/${languages.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete Language">
    </form>
</body>
</html>