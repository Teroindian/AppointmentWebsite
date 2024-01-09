// appointmentScript.js
$(document).ready(function () {
    $('#appointmentDate').datetimepicker({
        format: 'yyyy-MM-ddTHH:mm',
        minDate: new Date(),
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

    $('form').submit(function () {
        var selectedDate = $('#appointmentDate').datetimepicker('getDate');
        var currentDate = new Date();

        if (selectedDate > currentDate) {
            showAlert('Error', 'Selected date must be earlier than or equal to the current date.');
            return false;
        }

        showAlert('Success', 'Appointment created successfully!');
        return true;
    });

    function showAlert(title, message) {
        $('#alertTitle').text(title);
        $('#alertMessage').text(message);
        $('#errorAlert').removeClass('alert-danger').addClass('alert-success').show();
    }
});
