<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>



<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Welcome Doctor</h1>
            </div>
        </div>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>


<section class="bg-light1 pt-5 pb-5">
     <div class="container">
<form action="/users/doctorhome/show" method="post">
    <div class="row justify-content-center pt-4">
        <div class="col-12 text-center">
            <button type="submit" class="btn btn-primary">Upcoming Appointments</button>
        </div>
    </div>
</form>

</div>
</section>



   <c:if test="${not empty scheduleVar}">
        <section class="bg-light1 pb-5">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-12">

                        <h3 class="text-center pb-3">Appointments Found ${scheduleVar.size()}</h3>


                     <table class="table table-hover">
                         <tr>
                             <td>Id</td>
                             <td>Doctor_id</td>
                             <td>Patient_id</td>
                             <td>Appointment Date</td>
                             <td>Comments</td>

                         </tr>
                         <c:forEach items="${scheduleVar}" var="schedule">
                             <tr>
                                 <td>${schedule.id}</td>
                                 <td>${schedule.doctorId}</td>
                                 <td>${schedule.patientId}</td>
                                 <td>${schedule.appointmentDate}</td>
                                 <td>${schedule.comments}</td>

                             </tr>
                         </c:forEach>
                     </table>

                     </div>
                       </div>
                   </div>
               </section>
           </c:if>

<jsp:include page="../include/footer.jsp"/>