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
    <title>New Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">

    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h1>New Ninja</h1>
        <form:form action="/create/ninja" method="post" modelAttribute="newNinja">
            <p>
                <p><form:label path="firstName">First Name</form:label></p>
                <p class="text-danger"><form:errors path="firstName"/></p>
                <form:input path="firstName"/>
            </p>
            <p>
                <p><form:label path="lastName">Last Name</form:label></p>
                <p class="text-danger"><form:errors path="lastName"/></p>
                <form:input path="lastName"/>
            </p>
            <p>
            <p><form:label path="age">Age</form:label></p>
            <p class="text-danger"><form:errors path="age"/></p>
            <form:input path="age"/>
            </p>
            <p>
                <p><form:label path="dojo">Dojo:</form:label></p>
                <p class="text-danger"><form:errors path="dojo"/></p>
            <form:select path="dojo">
                <c:forEach var="dojo" items="${dojos}">
                    <form:option type="number"  value="${dojo.id}"><c:out value="${dojo.name}"></c:out></form:option>
                </c:forEach>
            </form:select>
            </p>
            <input type="submit" value="Submit"/>
        </form:form>
    </div>
</body>
</html>

