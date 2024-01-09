package med.appointments.casestudy.database.dao;

import jakarta.transaction.Transactional;
import med.appointments.casestudy.database.entity.Schedule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ScheduleDAOTest {

    @Autowired
    private ScheduleDAO scheduleDAO;


    @Test
    @Transactional
    public void createScheduleTest() {
        // Given
        Schedule schedule = new Schedule();
        schedule.setDoctorId(1);
        schedule.setPatientId(2);
        schedule.setAppointmentDateFromLocalDateTime(LocalDateTime.now().plusDays(1));
        schedule.setComments("Test comments"); // Set comments

        // When
        Schedule createdSchedule = scheduleDAO.save(schedule);

        // Then
        // Add assertions to verify the created schedule
        // Example assertions:
        Assertions.assertNotNull(createdSchedule.getId());
        Assertions.assertEquals(1, createdSchedule.getDoctorId());
        Assertions.assertEquals(2, createdSchedule.getPatientId());
        Assertions.assertTrue(createdSchedule.getAppointmentDate().after(new Date()));
        Assertions.assertEquals("Test comments", createdSchedule.getComments());

    }



    @Test
    @Transactional
    public void findUpcomingAppointmentsForDoctorTest() {
        // Given
        Integer doctorId = 1; // Set the doctor ID for testing

        // When
        // Call the method to find upcoming appointments for the specified doctor
        List<Schedule> upcomingAppointments = scheduleDAO.findUpcomingAppointmentsForDoctor(doctorId);

        // Then
        // Add assertions to verify the list of upcoming appointments
        // Example assertions:
        Assertions.assertNotNull(upcomingAppointments);
        Assertions.assertTrue(!upcomingAppointments.isEmpty());

        LocalDateTime now = LocalDateTime.now();

        Assertions.assertTrue(upcomingAppointments.stream().allMatch(appointment ->
                appointment.getAppointmentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().isAfter(now)
        ));
    }


}

