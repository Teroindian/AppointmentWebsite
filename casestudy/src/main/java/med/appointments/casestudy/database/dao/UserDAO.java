package med.appointments.casestudy.database.dao;

import med.appointments.casestudy.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends JpaRepository<User, Long> {
    public User findByEmailIgnoreCase(String email);


    public User findById(Integer id);

    @Query("SELECT u FROM User u WHERE u.firstName = :firstName OR u.lastName = :lastName")
    List<User> findByFirstNameOrLastName(String firstName, String lastName);

    //@Query("SELECT u FROM User u WHERE LOWER(u.firstName) = LOWER(:firstName) OR LOWER(u.lastName) = LOWER(:lastName)")
    //List<User> findByFirstNameOrLastName(String firstName, String lastName);


    //  non native query
   //  @Query("SELECT u FROM User u WHERE u.firstName = :query OR u.lastName = :query AND u.userType = 'doctor'")
    //    List<User> findDoctorsByFirstNameOrLastName(String query);

//native query below
  //  @Query(value = "SELECT * FROM users u WHERE (u.first_name = :query OR u.last_name = :query) AND u.user_type = 'doctor'", nativeQuery = true)
  //  List<User> findDoctorsByFirstNameOrLastName(String query);

    @Query(value = "SELECT * FROM users u WHERE (u.firstname = :query OR u.lastname = :query) AND u.user_type = 'doctor'", nativeQuery = true)
    List<User> findDoctorsByFirstNameOrLastName(String query);



    @Query("SELECT u FROM User u WHERE u.id = :patientId AND u.userType = 'patient'")
    Optional<User> findPatientById(Integer patientId);

    @Query("SELECT u FROM User u WHERE u.id = :doctorId AND u.userType = 'doctor'")
    Optional<User> findDoctorById(Integer doctorId);


}



