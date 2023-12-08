package med.appointments.casestudy.database.dao;

import med.appointments.casestudy.database.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorDAO  extends JpaRepository<Doctor, Long> {

    public Doctor findById(Integer id);


}
