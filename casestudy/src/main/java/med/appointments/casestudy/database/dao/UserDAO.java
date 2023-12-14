package med.appointments.casestudy.database.dao;

import med.appointments.casestudy.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Long> {
    public User findByEmailIgnoreCase(String email);


    public User findById(Integer id);

    @Query("SELECT u FROM User u WHERE u.firstName = :firstName OR u.lastName = :lastName")
    List<User> findByFirstNameOrLastName(String firstName, String lastName);

}
