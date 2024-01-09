<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Search Page</h1>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="bg-light2 pt-5 pb-5" id="welcomeSection">
        <div class="container">
            <div class="row">
                <div class="col-12 text-center">
                    <h1 class="display-3">
                        Welcome <%= org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication().getName() %>
                    </h1>
                </div>
            </div>
        </div>
    </div>
</section>

<script>
    document.addEventListener("DOMContentLoaded", function() {
        var welcomeSection = document.getElementById("welcomeSection");

        // Add Bootstrap classes for styling
        welcomeSection.classList.add("fade", "show");

        setTimeout(function() {
            // Hide the welcome section with Bootstrap fade-out effect
            welcomeSection.classList.remove("show");
        }, 3000);
    });
</script>

<section class="d-flex align-items-center justify-content-center vh-100">
    <div class="container">
        <nav class="navbar navbar-light bg-light">
            <form class="d-flex" action="/home/search" method="get">
                <input class="form-control me-2" id="searchQuery" name="searchQuery" type="text" placeholder="Search Doctor" aria-label="Search" value="${searchQuery}">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </nav>
    </div>
</section>

<c:if test="${userNotFound}">
    <div class="alert alert-warning text-center" role="alert">
        User not found.
    </div>
</c:if>

<c:if test="${not empty userVar}">
    <section class="bg-light1 pb-5">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12">
                    <h3 class="text-center pb-3">Doctors Found ${userVar.size()}</h3>
                    <table class="table table-hover">
                        <tr>
                            <td>Id</td>
                            <td>First Name</td>
                            <td>Last Name</td>
                            <td>Email</td>
                            <td>Phone</td>
                            <td>City</td>
                            <td>UserType</td>
                            <td>Book Appointment<td>
                        </tr>
                        <c:forEach items="${userVar}" var="user">
                            <c:if test="${user.userType eq 'doctor'}">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.firstName}</td>
                                    <td>${user.lastName}</td>
                                    <td>${user.email}</td>
                                    <td>${user.phone}</td>
                                    <td>${user.city}</td>
                                    <td>${user.userType}</td>
                                    <td><a href="/doctor/schedule/${user.id}"</a>Book Appointment</td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </section>
</c:if>

<jsp:include page="../include/footer.jsp"/>
