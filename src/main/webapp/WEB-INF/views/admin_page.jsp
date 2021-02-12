<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin Page</title>
    <link href="resources/css/common.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="resources/css/style.css"> <!-- Resource style -->
    <!-- Bootstrap Core CSS -->
    <link href="resources/bootstrap.min.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="resources/css/clean-blog.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Ubuntu:400,700' rel='stylesheet' type='text/css'>
</head>

<body style="background-color: #befafc">

<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                Menu <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand" href="<c:url value="/admin"/>">Hospital</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="<c:url value="/admin"/>">Admin</a>
                </li>
                <li>
                    <a href="<c:url value="/aboutUs"/>">About us</a>
                </li>
                <li>
                    <a href="<c:url value="#"/>">Contact us</a>
                </li>
                <li>
                    <a href="<c:url value="/logout"/>">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<header class="intro-header" style="background-color: #befafc; background-image: url('../../resources/img/home-page.jpg')">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <div class="site-heading">
                    <h1>Hospital</h1>
                    <hr class="small">
                    <span class="subheading">Admin Page</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div class="container">
<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
    <div class="post-preview">
        <button data-toggle="collapse" data-target="#unregisteredUsers" class="btn-secondary btn-link"><h1>List of unregistered users</h1></button>

        <div id="unregisteredUsers" class="collapse">
            <c:if test="${unregisteredUsers.size()==0}">
                <h3>There are no unregistered users.</h3>
            </c:if>
        <c:forEach items="${unregisteredUsers}" var="user">
            <br>
            <strong>User #${user.id}:</strong>  ${user.getName()} ${user.getSurname()}<br>
            <br>
            <form action="/registerUser" method="post">
                <input type="hidden" name="doctorId" value="${user.getId()}"/>
                <input type="text" name="category" placeholder="Enter category"/>
                <button class="btn-secondary btn-danger" type="submit">Register as a Doctor</button>
            </form>
            <br>
            <form action="/registerUser" method="post">
                <button class="btn-secondary btn-danger" type="submit" name ="nurseId" value="${user.getId()}" >Register as a Nurse</button>
                <button class="btn-secondary btn-danger" type="submit" name ="patientId" value="${user.getId()}" >Register as a Patient</button>
            </form>
        </c:forEach>
        </div>
    </div>
    <hr>
    <div class="post-preview">
        <button data-toggle="collapse" data-target="#doctors" class="btn-secondary btn-link"><h1>List of doctors</h1></button>

        <div id="doctors" class="collapse">
        <form action="/admin">
            <select name="type">
                <option value="0" disabled selected>Choose sorting type</option>
                <option value="1">Alphabet</option>
                <option value="2">Category</option>
            </select>
            <button type="submit" class="btn-secondary btn-danger">
                <strong>sort</strong>
            </button>
        </form>
            <c:if test="${doctors.size()==0}">
                <h3>There are no doctors.</h3>
            </c:if>
        <c:forEach items="${doctors}" var="user">
            <form action="/admin/user" method="get">
                <input type="hidden" name="doctorId" value="${user.getId()}"/>
                <button type="submit" class="btn-danger btn-link"><strong>User #${user.id}:</strong> ${user.getName()} ${user.getSurname()}</button>
            </form>
        </c:forEach>
        </div>
    </div>
    <hr>
    <div class="post-preview">
        <button data-toggle="collapse" data-target="#nurses" class="btn-secondary btn-link"><h1>List of nurses</h1></button>
        <div id="nurses" class="collapse">
        <form action="/admin">
            <select name="type">
                <option value="0" disabled selected>Choose sorting type</option>
                <option value="3">Alphabet</option>
                <option value="4">Birthday</option>
            </select>
            <button class="btn-secondary btn-danger"type="submit">
                <strong>sort</strong>
            </button>
        </form>
            <c:if test="${nurses.size()==0}">
                <h3>There are no nurses.</h3>
            </c:if>
        <c:forEach items="${nurses}" var="user">
            <form action="/admin/user" method="get">
                <input type="hidden" name="nurseId" value="${user.getId()}"/>
                <button class="btn-danger btn-link" type="submit"><strong>User #${user.id}:</strong> ${user.getName()} ${user.getSurname()}</button>
            </form>
        </c:forEach>
        </div>
    </div>
    <hr>
    <div class="post-preview">
        <button data-toggle="collapse" data-target="#patients" class="btn-secondary btn-link"><h1>List of patients</h1></button>
        <div id="patients" class="collapse"><form action="/admin">
            <select name="type" >
                <option value="0" disabled selected>Choose sorting type</option>
                <option value="5">Alphabet</option>
                <option value="6">Birthday</option>
            </select>
            <button class="btn-secondary btn-danger" type="submit">
                <strong>sort</strong>
            </button>
        </form>
            <c:if test="${patients.size()==0}">
                <h3>There are no patients.</h3>
            </c:if>
        <c:forEach items="${patients}" var="user">
            <form action="/admin/user" method="get">
                <input type="hidden" name="patientId" value="${user.getId()}"/>
                <button class="btn-danger btn-link" type="submit"><strong>User #${user.id}:</strong> ${user.getName()} ${user.getSurname()}</button>
            </form>
        </c:forEach>
        </div>
    </div>
    </div>
</div>
<hr>

<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <p class="copyright text-muted">Hospital &copy;  2021</p>
        </div>
    </div>
</footer>
<!-- jQuery -->
<script src="resources/js/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resources/js/bootstrap.min.js"></script>

<!-- Contact Form JavaScript -->
<script src="resources/js/jqBootstrapValidation.js"></script>
<script src="resources/js/contact_me.js"></script>

<!-- Theme JavaScript -->
<script src="resources/js/clean-blog.min.js"></script>
</body>
</html>