package med.appointments.casestudy.database.dao;

import med.appointments.casestudy.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
    public User findByEmailIgnoreCase(String email);

}
