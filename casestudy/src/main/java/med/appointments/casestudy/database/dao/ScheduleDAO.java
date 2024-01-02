package med.appointments.casestudy.database.dao;

import med.appointments.casestudy.database.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleDAO  extends JpaRepository<Schedule, Long> {


     public Schedule findById(Integer id);


     // Add a method to retrieve schedules by doctorId
     // List<Schedule> findByDoctorId(Integer doctorId);
}
