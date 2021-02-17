<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resources"/>

<html lang="${language}">
<head>
    <title><fmt:message key="newAccount"/></title>
    <link href="resources/css/common.css" rel="stylesheet" type="text/css"/>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body class="body-blue">
    <h1 class="text-xl-center"><fmt:message key="newAccount"/></h1>
    <form action="/register" method="post" class="form-signin">
        <div class="form-group">
            <label for="name"><strong><fmt:message key="name"/></strong></label>
            <input type="text" id = "name" name="name" class="form-control" placeholder="<fmt:message key='enterName'/>"/><br>

            <label for="surname"><strong><fmt:message key="surname"/></strong></label>
            <input type="text" id="surname" name="surname" class="form-control" placeholder="<fmt:message key='enterSurname'/>"/><br>

            <label for="birthday"><strong><fmt:message key="dateOfBirth"/></strong></label>
            <input type="date" id="birthday" name="birthday" class="form-control"/><br>

            <label for="email"><strong><fmt:message key="email"/> </strong></label>
            <input type="email" id="email" name="email" class="form-control" placeholder="<fmt:message key='enterEmail'/>"/><br>

            <label for="password"><strong><fmt:message key="password"/> </strong></label>
            <input type="password" id="password" name="password" class="form-control" placeholder="<fmt:message key='enterPassword'/>"/><br>

            <label for="confirm_password"><strong><fmt:message key="confirmPassword"/> </strong></label>
            <input type="password" id="confirm_password" name="confirm-password" class="form-control" placeholder="<fmt:message key='enterPassword'/>">

            <button class="btn btn-lg btn-danger btn-block" type="submit"><fmt:message key="newAccount"/></button>
            <h4 class="text-center"><a href="/login"><fmt:message key="login"/></a></h4>
        </div>
    </form>
</body>
</html>