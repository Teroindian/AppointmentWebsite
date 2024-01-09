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

<!-- Include the external JavaScript file -->
<script type="text/javascript" src="./js/appointmentScript.js"></script>

<!-- ... rest of your HTML code ... -->




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
    <!-- Doctor ID (Assuming the patient knows the doctor's ID) -->
    <div class="mt-3">
        <label for="doctorId" class="form-label">Doctor ID:</label>
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

    <!-- Location Selection (Dropdown) -->
    <div class="form-group">
        <label for="locationId">Location:</label>
        <select id="locationId" name="locationId" required>
            <option value="" disabled selected>Select a location</option>
            <!-- Populate this list dynamically with locations from the server -->

                        <option value="1">Hospital A</option>
                        <option value="2">Clinic B</option>
                        <option value="3">Hospital C</option>
                        <!-- Add more options as needed -->

            <!-- This part needs to be populated dynamically based on your data -->
        </select>
    </div>

    <!-- Submit Button -->
    <button type="submit" class="btn btn-primary">Create Appointment</button>
</form>

<jsp:include page="../include/footer.jsp"/>
