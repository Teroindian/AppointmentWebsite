<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>

<!-- Add the following lines to include Bootstrap and jQuery scripts -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-csGNlM3JAQl+LdScNQ4BqcEZiPHjTFzDNBrDfgsCdFYz5qgFVOFlV9DBbmcxVM9r"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjOsdzW6zvHFyZm/zefUdqSKtAOp6ukkGHwJEa9HjxAgx0xq11cqHu+peiDIEuk" crossorigin="anonymous"></script>

<script>
    // Activate the date-time picker
    $(document).ready(function () {
        $('#appointmentDate').datetimepicker({
            format: 'yyyy-MM-ddTHH:mm', // Adjust the format as needed
            minDate: new Date(), // Set the minimum date to the current date
            icons: {
                time: 'far fa-clock',
                date: 'far fa-calendar',
                up: 'fas fa-arrow-up',
                down: 'fas fa-arrow-down',
                previous: 'fas fa-chevron-left',
                next: 'fas fa-chevron-right',
                today: 'far fa-calendar-check',
                clear: 'far fa-trash-alt',
                close: 'far fa-times'
            }
        });
    });

    // Add submit event listener to the form
    $('form').submit(function () {
        // Get the selected date from the datepicker
        var selectedDate = $('#appointmentDate').datetimepicker('getDate');

        // Get the current date
        var currentDate = new Date();

        // Compare the dates
        if (selectedDate > currentDate) {
            // Show an alert if the selected date is later than the current date
            showAlert('Error', 'Selected date must be earlier than or equal to the current date.');
            return false; // Prevent form submission
        }

        return true; // Allow form submission
    });

    // Function to show Bootstrap alert
    function showAlert(title, message) {
        $('#alertTitle').text(title);
        $('#alertMessage').text(message);
        $('#errorAlert').show();
    }
</script>

<!-- Add this HTML for the Bootstrap alert -->
<div id="errorAlert" class="alert alert-danger alert-dismissible fade show" role="alert" style="display: none;">
    <strong id="alertTitle"></strong> <span id="alertMessage"></span>
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
</div>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Schedule Appointment</h1>
            </div>
        </div>
    </div>
</section>

<!-- Form for creating appointments -->
<form action="/schedule/create-appointment" method="post">
    <!-- Add hidden input to pass doctor's schedule ID -->
     <!--  <input type="hidden" name="doctorScheduleId" value="${schedule.id}"> -->

   <!-- Use the doctor's ID for the appointment -->
   <div class="mt-3">
       <label for="doctorId" class="form-label">Doctor ID</label>
       <input type="text" class="form-control" id="doctorId" name="doctorId" placeholder="Enter Doctor ID" required>
   </div>

   <!-- Appointment Date -->
   <div class="form-group pt-3">
       <label for="appointmentDate">Appointment Date:</label>
       <input type="datetime-local" id="appointmentDate" name="appointmentDate" required>
   </div>

   <!-- Comments -->
   <div class="form-group">
       <label for="comments">Comments:</label>
       <textarea id="comments" name="comments" rows="4"></textarea>
   </div>

   <button type="submit" class="btn btn-primary">Create Appointment</button>

            </div>
        </div>
    </div>
</form>






<jsp:include page="../include/footer.jsp"/>
