<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : pageContext.request.locale}" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="Content"/>

<html lang="${language}">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
    <title>Hospital Project</title>
</head>
<body>
<header>
    <nav>
        <div class="container">
            <div class="nav-wrapper">
                <a href="${pageContext.request.contextPath}/" class="brand-logo"><i class="material-icons">local_hospital</i><fmt:message key="hospital" /></a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <li>
                        <div>
                            <form>
                                <select id="language" name="language" onchange="submit()">
                                    <option  value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                                    <option  value="ua" ${language == 'ua' ? 'selected' : ''}>Українська</option>
                                </select>
                            </form>
                        </div>
                    </li>
                    <li><a href="/"><fmt:message key="home" /></a></li>
                    <li><a href="${pageContext.request.contextPath}/aboutUs"><fmt:message key="aboutUs" /></a></li>
                    <li><a href="${pageContext.request.contextPath}/login" class="btn"><fmt:message key="login" /></a></li>
                </ul>
            </div>
        </div>
    </nav>

    <ul class="sidenav" id="mobile-demo">
        <li><a href="${pageContext.request.contextPath}/"><fmt:message key="home" /></a></li>
        <li><a href="${pageContext.request.contextPath}/aboutUs"><fmt:message key="aboutUs" /></a></li>
    </ul>
</header>

<!--   Card elements  -->
<div class="row">
    <div class="col s12 m4">
        <div class="card z-depth-3 hoverable">
            <div class="card-image">
                <img src="${pageContext.request.contextPath}/img/home.jpg" alt="image">
                <span class="card-title"><fmt:message key="doctors"/></span>
            </div>
            <div class="card-content">
                <p><fmt:message key="about1"/></p>
            </div>
            <div class="card-action">
                <a href="#"><fmt:message key="readMore"/></a>
            </div>
        </div>
    </div>

    <div class="col s12 m4">
        <div class="card z-depth-3 hoverable">
            <div class="card-image">
                <img src="${pageContext.request.contextPath}/img/home.jpg" alt="image">
                <span class="card-title"><fmt:message key="nurses"/></span>
            </div>
            <div class="card-content">
                <p><fmt:message key="about2"/></p>
            </div>
            <div class="card-action">
                <a href="#"><fmt:message key="readMore"/></a>
            </div>
        </div>
    </div>

    <div class="col s12 m4">
        <div class="card z-depth-3 hoverable">
            <div class="card-image">
                <img src="${pageContext.request.contextPath}/img/home.jpg" alt="image">
                <span class="card-title"><fmt:message key="patients"/></span>
            </div>
            <div class="card-content">
                <p><fmt:message key="about3"/></p>
            </div>
            <div class="card-action">
                <a href="#"><fmt:message key="readMore"/></a>
            </div>
        </div>
    </div>
</div>

<jsp:include page="parts/footer.jsp" />

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
<script>
    $(document).ready(function(){
        $('select').formSelect();
        $('.sidenav').sidenav();
    });
</script>
</body>
</html>