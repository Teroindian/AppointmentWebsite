package med.appointments.casestudy.database.dao;


import jakarta.transaction.Transactional;
import med.appointments.casestudy.database.entity.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LocationDAOTest {


    @Autowired
    private LocationDAO locationDAO;



    @Test
    @Transactional
    public void createLocationTest() {
        // Given
        Location location = new Location();
        location.setCity("Test Location");
        location.setAddress("Test Address");

        // When
        Location createdLocation = locationDAO.save(location);

        // Then
        Assertions.assertNotNull(createdLocation.getId());
        Assertions.assertEquals("Test Location", createdLocation.getCity());
        Assertions.assertEquals("Test Address", createdLocation.getAddress());
    }

    @Test
    @Transactional
    public void findLocationByIdTest() {
        // Given
        Location location = new Location();
        location.setCity("Test Location");
        location.setAddress("Test Address");
        Location createdLocation = locationDAO.save(location);

        // When
        Location foundLocation = locationDAO.findById(createdLocation.getId());

        // Then
        Assertions.assertNotNull(foundLocation);
        Assertions.assertEquals("Test Location", foundLocation.getCity());
        Assertions.assertEquals("Test Address", foundLocation.getAddress());
    }

    @Test
    @Transactional
    public void deleteLocationTest() {
        // Given
        Location location = new Location();
        location.setCity("Test Location");
        location.setAddress("Test Address");
        Location createdLocation = locationDAO.save(location);

        // When
        locationDAO.deleteById(createdLocation.getId());

        // Then
        Location deletedLocation = locationDAO.findById(createdLocation.getId());
        Assertions.assertNull(deletedLocation, "Deleted location should be null");
    }




}
