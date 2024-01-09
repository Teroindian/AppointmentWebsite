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
                <h1 class="m-0">Login</h1>
            </div>
        </div>
    </div>
</section>


<c:if test="${param['error'] eq ''}">
    <section class="pt-5">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-6">
                    <div class="alert alert-danger w-100 mb-0">Invalid Username or Password</div>
                </div>
            </div>
        </div>
    </section>
</c:if>



<section class="pt-5 pb-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <!-- the action attribute on the form tag is the URL that the form will submit to when then user clicks the submit button -->
                <form method="post" action="/auth/loginSubmit">





                    <div class="mt-3">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control ${param['error'] eq 'true' ? 'is-invalid' : ''}" id="username" name="username">
                    </div>

                    <div class="mt-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control ${param['error'] eq 'true' ? 'is-invalid' : ''}" id="password" name="password">
                    </div>


                    <button type="submit" class="btn btn-primary mt-4">Submit</button>
                </form>

            </div>
        </div>
    </div>
</section>


<jsp:include page="../include/footer.jsp"/>