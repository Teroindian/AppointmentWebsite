package med.appointments.casestudy.service;

import lombok.extern.slf4j.Slf4j;
import med.appointments.casestudy.database.dao.UserDAO;
import med.appointments.casestudy.database.entity.User;
import med.appointments.casestudy.formbean.RegisterUserFormBean;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createNewUser(RegisterUserFormBean form) {
        User user = new User();

        user.setEmail(form.getEmail().toLowerCase());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setPhone(form.getPhone());
        user.setCity(form.getCity());
        user.setUserType(form.getUserType());

        String encoded = passwordEncoder.encode(form.getPassword());
        log.debug("Encoded password: " + encoded);
        user.setPassword(encoded);

        return userDAO.save(user);
    }

    public boolean isPatient(Integer userId) {
        User user = userDAO.findById(userId);
        return user != null && "patient".equals(user.getUserType());

    }

    public boolean isDoctor(Integer userId) {
        User user = userDAO.findById(userId);
        return user != null && "doctor".equals(user.getUserType());
    }

   // public Optional<User> getDoctorByUsername(String username) {
 //       return userDAO.findByEmailAndUserType(username, "doctor");
   // }





    public User findUserByEmail(String email) {
        return userDAO.findByEmailIgnoreCase(email);
    }
}
