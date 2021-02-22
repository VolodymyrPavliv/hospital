<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resources"/>

<!DOCTYPE html>
<html lang="${language}">
<head>
    <title><fmt:message key="login"/></title>
    <link href="resources/css/common.css" rel="stylesheet" type="text/css"/>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body class="body-blue">
    <div class="container mt-5">
        <form action="/login" method="post" class="form-signin">
            <h1 class="form-heading"><fmt:message key="login"/></h1>
            <div class="form-group">
                <c:if test="${notRegisteredYet}">
                    <p class="text-left text-info"><fmt:message key="notRegisteredYet"/> </p>
                </c:if>
                <c:if test="${loginIncorrectCredentials}">
                    <p class="text-danger"><fmt:message key="loginIncorrectCredentials" /></p>
                </c:if>
                <c:if test="${emptyCredentials}">
                    <p class="text-danger"><fmt:message key="emptyCredentials" /></p>
                </c:if>
                <label for="email"><strong><fmt:message key="email"/></strong> </label>
                <input id = "email" class="form-control" name="email" type="email" placeholder="<fmt:message key='enterEmail'/> "/><br>
                <label for="password"><strong><fmt:message key="password"/> </strong></label>
                <input id = "password" class="form-control" name="password" type="password" placeholder="<fmt:message key='enterPassword'/>" />
                <button class="btn btn-lg btn-danger btn-block" type="submit"><fmt:message key="login"/></button>
                <h4 class="text-center"><a href="/register"><fmt:message key="newAccount"/></a></h4>
            </div>
        </form>
    </div>
</body>
</html>

