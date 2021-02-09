<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<header>
    <a href="/">Hospital </a>||
    <a href="/aboutUs">About us </a>||
    <a href="/logout">Logout</a>
</header>
<body>
<h1>List of unregistered users</h1>
<c:forEach items="${unregisteredUsers}" var="user">
    <p>${user.getName()}</p>
    <form action="/registerUser" method="post">
        <input type="hidden" name="doctorId" value="${user.getId()}"/>
        <input type="text" name="category" placeholder="Enter category"/>
        <input type="submit" value="Register As A Doctor"/>
    </form>
    <form action="/registerUser" method="post">
        <input type="hidden" name="nurseId" value="${user.getId()}">
        <input type="submit" value="Register As A Nurse"/>
    </form>
    <form action="/registerUser" method="post">
        <input type="hidden" name="patientId" value="${user.getId()}">
        <input type="submit" value="Register As A Patient"/>
    </form>
</c:forEach>
-------------------------------------
<h1>List of doctors</h1>
<c:forEach items="${doctors}" var="user">
    <p>${user.getName()} ${user.getSurname()}</p>
    <form action="/admin/user" method="get">
        <input type="hidden" name="doctorId" value="${user.getId()}"/>
        <input type="submit" value="Details"/>
    </form>
</c:forEach>
-------------------------------------
<h1>List of nurses</h1>
<c:forEach items="${nurses}" var="user">
    <p>${user.getName()} ${user.getSurname()}</p>
    <form action="/admin/user" method="get">
        <input type="hidden" name="nurseId" value="${user.getId()}"/>
        <input type="submit" value="Details"/>
    </form>
</c:forEach>
-------------------------------------
<h1>List of patients</h1>
<c:forEach items="${patients}" var="user">
    <p>${user.getName()} ${user.getSurname()}</p>
    <form action="/admin/user" method="get">
        <input type="hidden" name="patientId" value="${user.getId()}"/>
        <input type="submit" value="Details"/>
    </form>
</c:forEach>
</body>
</html>

