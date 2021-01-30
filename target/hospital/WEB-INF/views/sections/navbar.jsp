<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal">Travel Agency</h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="<c:url value="/"/>">Home</a>
            <a class="p-2 text-dark" href="<c:url value="/admin"/>">Management</a>
            <a class="p-2 text-dark" href="<c:url value="/doctorPage"/>">Doctor Page</a>
            <a class="p-2 text-dark" href="<c:url value="/patientPage"/>">Patient Page</a>
        <a class="p-2 text-dark" href="<c:url value="/login"/>">Login</a>
        <a class="p-2 text-dark" href="<c:url value="/logout"/>">Logout</a>
    </nav>
</div>
