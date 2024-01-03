package med.appointments.casestudy.service;

import lombok.extern.slf4j.Slf4j;
import med.appointments.casestudy.database.dao.LocationDAO;
import med.appointments.casestudy.database.dao.ScheduleDAO;
import med.appointments.casestudy.database.dao.UserDAO;
import med.appointments.casestudy.database.entity.Schedule;
import med.appointments.casestudy.database.entity.User;
import med.appointments.casestudy.formbean.CreateAppointmentFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import med.appointments.casestudy.database.entity.Location;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;



    @Slf4j
    @Service
    public class AppointmentService {

        @Autowired
        private ScheduleDAO scheduleDAO;
        @Autowired
        private UserDAO userDAO;
        @Autowired
        private LocationDAO locationDAO;

        public Schedule createNewAppointment(Integer userId, Integer doctorId, Integer locationId, CreateAppointmentFormBean form) {
            try {
                // Retrieve the corresponding schedule by doctorId
                Schedule schedule = scheduleDAO.findById(doctorId);

                // If the schedule doesn't exist, create a new one
                if (schedule == null) {
                    schedule = new Schedule();
                    schedule.setDoctorId(doctorId);
                }

                // Set the patient ID based on the user type
                if (isPatient(userId)) {
                    schedule.setPatientId(userId);
                } else {
                    // Handle the case where the user is not a patient
                    log.error("User with ID {} is not a patient. Cannot create appointment.", userId);
                    return null;
                }

                SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                Date appointmentDate = dateFormatter.parse(form.getAppointmentDate());

                // Set the appointment details
                schedule.setAppointmentDate(appointmentDate);
                schedule.setComments(form.getComments());

                // Set the location based on user input
                Location location =  locationDAO.findById(locationId);;

                // Check if the location exists in the database
               /* if (locationId != null) {
                    location =
                } else {
                    // If location ID is not provided, create a new location
                    location = new Location();
                    location.setAddress(form.getLocationName());
                    location = locationDAO.save(location);
                }*/

                // Associate the location with the schedule
                schedule.setLocation(location);

                // Save the updated schedule to the database
                scheduleDAO.save(schedule);

                // Log the successful creation of the appointment
                log.info("Appointment created successfully for user ID {} and doctor ID: {}", userId, doctorId);

                return schedule; // Return the updated schedule if needed
            } catch (Exception e) {
                // Log the exception or handle it as needed
                log.error("Failed to create appointment", e);
                return null; // Failed to create appointment
            }
        }

        private boolean isPatient(Integer userId) {
            // Retrieve the user by ID
            User user = userDAO.findById(userId);

            // Check if the user exists and has the 'patient' userType
            return user != null && "patient".equals(user.getUserType());
        }
    }




   /* public Schedule createNewAppointment(Integer doctorId, CreateAppointmentFormBean form) {
        try {
            // Retrieve the corresponding schedule by doctorId
            Schedule schedule = scheduleDAO.findById(doctorId);

            // If the schedule doesn't exist, create a new one
            if (schedule == null) {
                schedule = new Schedule();
                schedule.setDoctorId(doctorId);
            }

            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            Date appointmentDate = dateFormatter.parse(form.getAppointmentDate());

            // Set the appointment details
            schedule.setAppointmentDate(appointmentDate);
            schedule.setComments(form.getComments());

            // Save the updated schedule to the database
            scheduleDAO.save(schedule);

            // Log the successful creation of the appointment
            log.info("Appointment created successfully for doctor ID: {}", doctorId);

            return schedule; // Return the updated schedule if needed
        } catch (Exception e) {
            // Log the exception or handle it as needed
            log.error("Failed to create appointment", e);
            return null; // Failed to create appointment
        }
    }*/
//}


  /*  public Schedule createNewAppointment(CreateAppointmentFormBean form) {
        try {
            // Retrieve the corresponding schedule
            Schedule schedule = scheduleDAO.findById(form.getScheduleId());

            // Convert LocalDateTime to Date
           // LocalDateTime appointmentDateTime = form.getAppointmentDate();
          //  Date appointmentDate = Date.from(appointmentDateTime.atZone(ZoneId.systemDefault()).toInstant());

            if ( schedule == null ) {


               schedule  = new Schedule();

            }


            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            Date appointmentDate = dateFormatter.parse(form.getAppointmentDate());

            // Set the appointment details
            schedule.setAppointmentDate(appointmentDate);
            schedule.setComments(form.getComments());

            // Save the updated schedule to the database
            // Assuming you have a ScheduleDAO for saving schedules
            scheduleDAO.save(schedule);

            // Log the successful creation of the appointment
            log.info("Appointment created successfully for doctor schedule ID: {}", form.getScheduleId());

            return schedule; // Return the updated schedule if needed
        } catch (Exception e) {
            // Log the exception or handle it as needed
            log.error("Failed to create appointment", e);
            return null; // Failed to create appointment
        }
    }
*/






