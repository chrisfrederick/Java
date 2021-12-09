<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Books</title>
</head>
<body>
<h1>${book.title}</h1>

<p>
    ${book.description}<br>
    ${book.language}<br>
    ${book.numberOfPages}<br>
</p>

</body>
</html>