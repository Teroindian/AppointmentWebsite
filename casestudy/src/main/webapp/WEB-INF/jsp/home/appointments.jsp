<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light pt-5 pb-5">
        <div class="container">
            <div class="row">
                <div class="col-12 text-center">
                    <h1 class="display-4">Upcoming Appointments</h1>
                </div>
            </div>

            <c:if test="${not empty appointmentsVar}">
                <div class="row justify-content-center">
                    <div class="col-12">
                        <table class="table table-hover">
                            <tr>
                                <th>Appointment Date</th>
                                <th>Doctor</th>
                                <th>Comments</th>
                            </tr>
                            <c:forEach items="${appointmentsVar}" var="appointment">
                                <tr>
                                    <td>${appointment.appointmentDate}</td>
                                    <td>${appointment.doctorName}</td>
                                    <td>${appointment.comments}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>
