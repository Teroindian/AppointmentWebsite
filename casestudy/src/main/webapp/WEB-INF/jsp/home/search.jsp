<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Home Page</h1>
            </div>
        </div>
    </div>
</section>

<section class="d-flex justify-content-center align-items-center vh-100">
    <nav class="navbar navbar-light bg-light">
        <form class="form-inline" action="/home/search" method="get">
            <input class="form-control mr-sm-2" id="searchQuery" name="searchQuery" type="text" placeholder="Search Doctor" aria-label="Search" value="${searchQuery}">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>
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
