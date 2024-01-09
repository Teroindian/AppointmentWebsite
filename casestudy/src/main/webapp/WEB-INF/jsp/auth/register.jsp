<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


     <link href="/pub/css/global-style.css" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
          crossorigin="anonymous">

</head>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">User Registration</h1>
            </div>
        </div>
    </div>
</section>


<section class="pt-5 pb-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <!-- the action attribute on the form tag is the URL that the form will submit to when then user clicks the submit button -->
                <form method="post" action="/auth/registerSubmit" modelAttribute="RegisterUserFormBean">

                <div class="mt-3">
                                <label for="firstName" class="form-label">First Name</label>
                                <input type="text" class="form-control" id="firstName" name="firstName" aria-describedby="firstNameHelp" value="${form.firstName}">
                                <div id="firstNameHelp" class="form-text">Please let us know your first name</div>
                            </div>
                            <c:if test="${errors.hasFieldErrors('firstName')}">
                                            <div style="color:red">
                                                <c:forEach items="${errors.getFieldErrors('firstName')}" var="error">
                                                    ${error.defaultMessage}<br>
                                                </c:forEach>
                                            </div>
                                        </c:if>

                            <div class="mt-3">
                                <label for="lastName" class="form-label">Last Name</label>
                                <input type="text" class="form-control" id="lastName" name="lastName" value="${form.lastName}">
                            </div>
                            <c:if test="${errors.hasFieldErrors('LastName')}">
                                            <div style="color:red">
                                                <c:forEach items="${errors.getFieldErrors('lastName')}" var="error">
                                                    ${error.defaultMessage}<br>
                                                </c:forEach>
                                            </div>
                                        </c:if>



                             <div class="mt-3">
                                            <label for="email" class="form-label">Email</label>
                                            <input type="text" class="form-control" id="email" name="email" value="${form.email}">
                                        </div>
                                        <c:if test="${errors.hasFieldErrors('email')}">
                                                        <div style="color:red">
                                                            <c:forEach items="${errors.getFieldErrors('email')}" var="error">
                                                                ${error.defaultMessage}<br>
                                                            </c:forEach>
                                                        </div>
                                                    </c:if>

                            <div class="mt-3">
                                <label for="phone" class="form-label">Phone</label>
                                <input type="text" class="form-control" id="phone" name="phone" value="${form.phone}">
                            </div>
                            <c:if test="${errors.hasFieldErrors('Phone')}">
                                            <div style="color:red">
                                                <c:forEach items="${errors.getFieldErrors('Phone')}" var="error">
                                                    ${error.defaultMessage}<br>
                                                </c:forEach>
                                            </div>
                                        </c:if>

                            <div class="mt-3">
                                <label for="city" class="form-label">City</label>
                                <input type="text" class="form-control" id="city" name="city" value="${form.city}">
                            </div>
                            <c:if test="${errors.hasFieldErrors('City')}">
                                            <div style="color:red">
                                                <c:forEach items="${errors.getFieldErrors('City')}" var="error">
                                                    ${error.defaultMessage}<br>
                                                </c:forEach>
                                            </div>
                                        </c:if>


                             <div class="mt-3">
                                                    <label for="password" class="form-label">Password</label>
                                                    <input type="text" class="form-control" id="password" name="password" value="${form.password}">
                                                </div>
                                                <c:if test="${errors.hasFieldErrors('password')}">
                                                    <div style="color:red">
                                                        <c:forEach items="${errors.getFieldErrors('password')}" var="error">
                                                            ${error.defaultMessage}<br>
                                                        </c:forEach>
                                                    </div>
                                                </c:if>


                                                <div class="mt-3">
                                                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                                                    <input type="text" class="form-control" id="confirmPassword" name="confirmPassword" value="${form.confirmPassword}">
                                                </div>
                                                <c:if test="${errors.hasFieldErrors('confirmPassword')}">
                                                    <div style="color:red">
                                                        <c:forEach items="${errors.getFieldErrors('confirmPassword')}" var="error">
                                                            ${error.defaultMessage}<br>
                                                        </c:forEach>
                                                    </div>
                                                </c:if>




                                              <div class="mt-3">
                                               <label for="userType" class="form-label">User Type</label>
                                             <select class="form-select" aria-label="Default select example" id="userType" name="userType">
                                               <option selected>Select UserType</option>
                                               <option value="patient">Patient</option>
                                               <option value="doctor">Doctor</option>

                                             </select>
                                             </div>






                    <button type="submit" class="btn btn-primary mt-4">Submit</button>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>