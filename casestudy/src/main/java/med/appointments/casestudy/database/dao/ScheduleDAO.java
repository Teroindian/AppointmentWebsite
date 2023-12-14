package med.appointments.casestudy.database.dao;

import med.appointments.casestudy.database.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleDAO  extends JpaRepository<Schedule, Long> {


     public Schedule findById(Integer id);
}
