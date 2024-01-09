package med.appointments.casestudy.database.dao;

import med.appointments.casestudy.database.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDAO  extends JpaRepository<Location, Long> {

     public Location findById(Integer id);

     public  void deleteById(Integer id);
}
