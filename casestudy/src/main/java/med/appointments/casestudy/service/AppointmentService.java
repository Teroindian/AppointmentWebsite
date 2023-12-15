package med.appointments.casestudy.service;

import lombok.extern.slf4j.Slf4j;
import med.appointments.casestudy.database.dao.ScheduleDAO;
import med.appointments.casestudy.database.entity.Schedule;
import med.appointments.casestudy.formbean.CreateAppointmentFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
@Service

public class AppointmentService {



    @Autowired
    private ScheduleDAO scheduleDAO;

    // Other necessary dependencies can be injected as needed

    public Schedule createNewAppointment(CreateAppointmentFormBean form) {
        try {
            // Retrieve the corresponding schedule
            Schedule schedule = scheduleDAO.findById(form.getDoctorScheduleId());

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
            log.info("Appointment created successfully for doctor schedule ID: {}", form.getDoctorScheduleId());

            return schedule; // Return the updated schedule if needed
        } catch (Exception e) {
            // Log the exception or handle it as needed
            log.error("Failed to create appointment", e);
            return null; // Failed to create appointment
        }
    }



    }



