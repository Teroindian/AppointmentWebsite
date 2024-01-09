package med.appointments.casestudy.database.dao;


import jakarta.transaction.Transactional;
import med.appointments.casestudy.database.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDAOTest {


    @Autowired
    private UserDAO userDAO;

    @Test
    @Transactional
    public void findByIdTest() {
        // Given
        Integer userId = 1;

        // When
        User user = userDAO.findById(userId);

        // Then
        Assertions.assertNotNull(user);
        Assertions.assertEquals(userId, user.getId());
    }




    @Test
    @Transactional
    public void findDoctorsByFirstNameOrLastNameTest() {
        // Given
        String query = "DoctorName";

        // When
        List<User> doctors = userDAO.findDoctorsByFirstNameOrLastName(query);

        // Then
        Assertions.assertNotNull(doctors);
        // Add assertions to verify the list of doctors
        // Example assertions:
         Assertions.assertTrue(doctors.stream().allMatch(doctor -> doctor.getUserType().equals("doctor")));
    }


    @Test
    @Transactional
    public void findPatientByIdTest() {
        // Given
        Integer patientId = 1;

        // When
        Optional<User> optionalUser = userDAO.findPatientById(patientId);

        // Then
        Assertions.assertTrue(optionalUser.isPresent());
        // Add assertions to verify the patient user
    }



}
