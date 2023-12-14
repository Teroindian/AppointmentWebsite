package med.appointments.casestudy.database.dao;

import med.appointments.casestudy.database.entity.DoctorLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorLocationDAO extends JpaRepository<DoctorLocation, Long> {


     public DoctorLocation findById(Integer id);

}
