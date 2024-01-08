package med.appointments.casestudy.database.dao;

import med.appointments.casestudy.database.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleDAO  extends JpaRepository<Schedule, Long> {


     public Schedule findById(Integer id);


     // Example: Find a schedule by location ID
    public  Schedule findByLocationId(Integer locationId);

     // Add a method to retrieve schedules by doctorId
     // List<Schedule> findByDoctorId(Integer doctorId);


    List<Schedule> findByDoctorId(Integer doctorId);

    List<Schedule> findByPatientId(Integer patientId);


    // Add a method to fetch upcoming appointments for a specific doctor
    @Query("SELECT s FROM Schedule s " +
            "WHERE s.doctorId = :doctorId " +
            "AND s.appointmentDate > CURRENT_TIMESTAMP " +
            "ORDER BY s.appointmentDate ASC")
    List<Schedule> findUpcomingAppointmentsForDoctor( Integer doctorId);
}

