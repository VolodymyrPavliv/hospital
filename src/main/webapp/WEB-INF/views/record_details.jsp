<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Record Details</title>
    <!-- Bootstrap Core CSS -->
    <link href="resources/bootstrap.min.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="resources/css/clean-blog.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Ubuntu:400,700' rel='stylesheet' type='text/css'>

</head>

<body style="
background-color: #6df1f6">

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
                    <a href="<c:url value="#"/>">About us</a>
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

<header class="intro-header" style="
background-color: #6df1f6; background-image: url('../../resources/img/home-page.jpg')">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <div class="site-heading">
                    <h1>Hospital</h1>
                    <hr class="small">
                    <span class="subheading">Record Details</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div class="container">
    <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
        <c:if test="${isDoctor!=null}">
        <div class="post-preview">
            <button data-toggle="collapse" data-target="#initialDiagnosis" class="btn-secondary btn-link">
                <h3>Add initial diagnosis</h3></button>
            <div id="initialDiagnosis" class="collapse">
                <form action="/editRecord" method="post">
                    <input type="hidden" name="id" value="${record.getId()}">
                    <textarea name="initialDiagnosis"></textarea>
                    <button type="submit" class="btn-secondary btn-danger">
                        Add</button>
                </form>
            </div>
            <br>
            <button data-toggle="collapse" data-target="#finalDiagnosis" class="btn-secondary btn-link">
                <h3>Add final diagnosis</h3></button>
            <div id="finalDiagnosis" class="collapse">
                <form action="/editRecord" method="post">
                    <input type="hidden" name="id" value="${record.getId()}">
                    <textarea name="finalDiagnosis"></textarea><br><br>
                    <label for="discharge">Discharge date: </label>
                    <input type="date" name="dischargeDate" id="discharge"><br>
                    <button type="submit" class="btn-secondary btn-danger">
                        Add</button>
                </form>
            </div>
            <br>
            <button data-toggle="collapse" data-target="#doctorAssignment" class="btn-secondary btn-link">
                <h3>Add an assignment</h3></button>
            <div id="doctorAssignment" class="collapse">
                <form action="/addAssignment" method="post">
                    <button type="submit" class="btn-secondary btn-danger">
                        Add</button>
                </form>
            </div>
        </div>
        </c:if>
        <c:if test="${isNurse!=null}">
            <div class="post-preview">
                <button data-toggle="collapse" data-target="#nurseAssignment" class="btn-secondary btn-link">
                    <h3>Add an assignment</h3></button>
                <div id="nurseAssignment" class="collapse">
                    <form action="/addAssignment" method="post">
                        <button type="submit" class="btn-secondary btn-danger">
                            Add</button>
                    </form>
                </div>
            </div>
        </c:if>
        <div class="post-preview">
            <p><strong>Patient: </strong> ${patient.getName()} ${patient.getSurname()}</p>
            <p><strong>Entry date: </strong> ${record.getEntryDate()}</p>
            <p><strong>Discharge date: </strong> ${record.getDischargeDate()}</p>
            <p><strong>Initial diagnosis: </strong> ${record.getInitialDiagnosis()}</p>
            <p><strong>Final diagnosis: </strong> ${record.getFinalDiagnosis()}</p>
            <hr>
            <p><strong>Doctor: </strong> ${doctor.getName()} ${doctor.getSurname()}</p>
            <p><strong>Category: </strong> ${doctorInfo.getCategory()}</p>
            <hr>
            <p><strong>Nurse: </strong> ${nurse.getName()} ${nurse.getSurname()}</p>
        </div>
        <hr>
        <div class="post-preview">
            <button data-toggle="collapse" data-target="#assignments" class="btn-secondary btn-link">
                <h3>Assignments</h3></button>
            <div id="assignments" class="collapse">
                <c:if test="${assignments.size()==0}">
                    <h3>There are no assignments.</h3>
                </c:if>
                <c:forEach items="${assignments}" var="assignment">
                    <p><strong>Type: </strong> ${assignment.getType()}</p>
                    <p class="text-xl-center"><strong>Description</strong></p>
                    <p>${assignment.getDescription()}</p>
                    <p><strong>Date: </strong> ${assignment.getDate()}</p>
                    <p><strong>Author: </strong> ${assignment.getUser().getName()}
                            ${assignment.getUser().getSurname()}</p>
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
