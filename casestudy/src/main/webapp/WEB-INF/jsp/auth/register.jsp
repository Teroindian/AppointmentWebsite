<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

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
                <form method="get" action="/auth/registerSubmit">

                <div class="mt-3">
                                        <label for="username" class="form-label">Username</label>
                                        <input type="text" class="form-control" id="username" name="username" value="${form.username}">
                                    </div>
                                    <c:if test="${errors.hasFieldErrors('username')}">
                                        <div style="color:red">
                                            <c:forEach items="${errors.getFieldErrors('username')}" var="error">
                                                ${error.defaultMessage}<br>
                                            </c:forEach>
                                        </div>
                                    </c:if>







                 <div class="mt-3">
                                         <label for="firstname" class="form-label">firstname</label>
                                         <input type="text" class="form-control" id="firstname" name="firstname" value="${form.firstname}">
                                     </div>
                                     <c:if test="${errors.hasFieldErrors('firstname')}">
                                         <div style="color:red">
                                             <c:forEach items="${errors.getFieldErrors('firstname')}" var="error">
                                                 ${error.defaultMessage}<br>
                                             </c:forEach>
                                         </div>
                                     </c:if>


                <div class="mt-3">
                                        <label for="lastname" class="form-label">lastname</label>
                                        <input type="text" class="form-control" id="lastname" name="lastname" value="${form.lastname}">
                                    </div>
                                    <c:if test="${errors.hasFieldErrors('lastname')}">
                                        <div style="color:red">
                                            <c:forEach items="${errors.getFieldErrors('lastname')}" var="error">
                                                ${error.defaultMessage}<br>
                                            </c:forEach>
                                        </div>
                                    </c:if>



                    <div class="mt-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="text" class="form-control" id="email" name="email" aria-describedby="emailHelp" value="${form.email}">
                    </div>
                    <c:if test="${errors.hasFieldErrors('email')}">
                        <div style="color:red">
                            <c:forEach items="${errors.getFieldErrors('email')}" var="error">
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
                                            <label for="phone" class="form-label">phone</label>
                                            <input type="text" class="form-control" id="phone" name="phone" value="${form.phone}">
                                        </div>
                                        <c:if test="${errors.hasFieldErrors('phone')}">
                                            <div style="color:red">
                                                <c:forEach items="${errors.getFieldErrors('phone')}" var="error">
                                                    ${error.defaultMessage}<br>
                                                </c:forEach>
                                            </div>
                                        </c:if>







                    <button type="submit" class="btn btn-primary mt-4">Submit</button>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>