<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <link href="/pub/css/global-style.css" rel="stylesheet">

</head>

<section>
    <div class="bg-light pt-5 pb-5">
        <div class="container">
            <div class="row">
                <div class="col-12 text-center">
                   <h1 class="display-4" style="font-family: 'Arial';">Home Page</h1>
                </div>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="bg-light pt-5 pb-5" id="welcomeSection">
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

<section class="d-flex justify-content-center align-items-center mt-3">
    <div class="btn-group" role="group" aria-label="Basic example">
        <a href="/home/search" class="btn btn-primary">Search Doctor</a>
        <a href="/home/appointments" class="btn btn-secondary">Upcoming Appointments</a>
        <a href="/logout" class="btn btn-danger">Sign Out</a>
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

<jsp:include page="../include/footer.jsp"/>
