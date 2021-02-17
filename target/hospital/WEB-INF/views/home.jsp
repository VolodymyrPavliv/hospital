<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resources"/>

<!doctype html>
<html lang="${language}">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href='http://fonts.googleapis.com/css?family=Ubuntu:400,700' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" href="resources/css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="resources/css/style.css"> <!-- Resource style -->
    <script src="resources/js/modernizr.js"></script> <!-- Modernizr -->

    <title>Home page</title>
</head>
<body>
<main id="cd-main-content">
    <section id="cd-intro">
        <h1 class="text-xl-center"><stronger><fmt:message key="welcome"/></stronger></h1>
        <header>
            <form>
                <select class="form-control" id="language" name="language" onchange="submit()" >
                    <option  value="en" ${language == 'en' ? 'selected' : ''}>en</option>
                    <option  value="ua" ${language == 'ua' ? 'selected' : ''}>укр</option>
                </select>
            </form>
            <a class="cd-menu-trigger" href="#main-nav"><fmt:message key="menu"/><span></span></a>
        </header>
        <div class="cd-blurred-bg"></div>
    </section> <!-- cd-intro -->
</main>

<div class="cd-shadow-layer"></div>

<nav id="main-nav">
    <ul>
        <li><a href="/aboutUs"><span><fmt:message key="aboutUs"/></span></a></li>
        <li><a href="/contactUs"><span><fmt:message key="contactUs"/></span></a></li>
        <li><a href="/login"><span><fmt:message key="login"/> </span></a></li>
        <li><a href="/register"><span><fmt:message key="newAccount"/></span></a></li>
    </ul>
    <a href="#0" class="cd-close-menu">Close<span></span></a>
</nav>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="resources/js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>