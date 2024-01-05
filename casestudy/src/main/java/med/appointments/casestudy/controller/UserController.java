package med.appointments.casestudy.controller;

//import ch.qos.logback.core.model.Model;
import lombok.extern.slf4j.Slf4j;
import med.appointments.casestudy.database.dao.ScheduleDAO;
import med.appointments.casestudy.database.dao.UserDAO;
import med.appointments.casestudy.database.entity.Schedule;
import med.appointments.casestudy.database.entity.User;
import med.appointments.casestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ScheduleDAO scheduleDAO;

    @Autowired
    private UserService userService;









    @GetMapping("/users/doctorhome")
    public ModelAndView createDoctor(
    ){
        ModelAndView response = new ModelAndView("users/doctorhome");

        log.debug(" In create home doctor with no Args");
        return response;
    }

    @PostMapping("/users/doctorhome/show")
    public String showDoctorHome(Model model) {
        // Get the logged-in user's username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Get the logged-in user's ID
        Integer userId = userService.findUserByEmail(username).getId();

        // Check if the user is a doctor
        if (userService.isDoctor(userId)) {
            // The user is a doctor
            // Fetch upcoming appointments for the doctor
            List<Schedule> upcomingAppointments = scheduleDAO.findUpcomingAppointmentsForDoctor(userId);

            // Add the upcoming appointments to the model
            model.addAttribute("scheduleVar", upcomingAppointments);

            log.debug("In showDoctorHome");
            return "users/doctorhome";
        } else {
            // Handle the case where the user is not a doctor or is not a valid user
            log.error("User with username {} is not a doctor or is not a valid user", username);
            return "error"; // Redirect to an error page or handle appropriately
        }
    }





    @GetMapping("/home/search")
    public ModelAndView search(@RequestParam(required = false) String searchQuery) {
        ModelAndView response = new ModelAndView("home/search");

        // Log the value received from the form
        log.debug("In the patient search controller method: searchQuery = " + searchQuery);

        if (searchQuery != null) {
            // Use the search query for both first name and last name parameters in the search
            List<User> users = userDAO.findByFirstNameOrLastName(searchQuery, searchQuery);

            // Filter users with userType 'doctor'
            List<User> doctors = users.stream()
                    .filter(user -> "doctor".equals(user.getUserType()))
                    .collect(Collectors.toList());

            response.addObject("userVar", doctors);
            response.addObject("search", searchQuery); // Assuming you want to use the search query for display

            // If no doctors are found, set a flag to display the "User Not Found" message
            response.addObject("userNotFound", doctors.isEmpty());

            for (User user : doctors) {
                log.debug("Doctor: id = " + user.getId() + ", last name = " + user.getLastName());
            }
        }

        return response;
    }



  /*  @GetMapping("/home/search")
    public ModelAndView search(
            @RequestParam(required = false) String searchQuery
    ) {
        ModelAndView response = new ModelAndView("home/search");

        // Log the value received from the form
        log.debug("In the patient search controller method: searchQuery = " + searchQuery);

        if (searchQuery != null) {
            // Use the search query for both first name and last name parameters in the search
            List<User> users = userDAO.findByFirstNameOrLastName(searchQuery, searchQuery);
            response.addObject("userVar", users);
            response.addObject("search", searchQuery); // Assuming you want to use the search query for display
            for (User user : users) {
                log.debug("User: id = " + user.getId() + ", last name = " + user.getLastName());
            }
        }

        return response;
    }*/



  /*  @GetMapping("/home/search")
    public ModelAndView search(@RequestParam(required = false) String searchQuery) {
        ModelAndView response = new ModelAndView("home/search");

        // Log the value received from the form
        log.debug("In the patient search controller method: searchQuery = " + searchQuery);

        if (searchQuery != null) {
            // Use the search query to find doctors
            List<User> doctors = userDAO.findDoctorsByFirstNameOrLastName(searchQuery);
            response.addObject("userVar", doctors);
            response.addObject("search", searchQuery); // Assuming you want to use the search query for display
            for (User doctor : doctors) {
                log.debug("Doctor: id = " + doctor.getId() + ", last name = " + doctor.getLastName());
            }
        }

        return response;
    }*/







}
/*
        @GetMapping("/home/search")
public ModelAndView search(
        @RequestParam(required = false) String searchQuery
) {
    ModelAndView response = new ModelAndView("home/search");

    // Log the value received from the form
    log.debug("In the patient search controller method: searchQuery = " + searchQuery);

    if (searchQuery != null) {
        // Use the search query for both first name and last name parameters in the search
        List<User> users = userDAO.findByFirstNameOrLastName(searchQuery, searchQuery);
        response.addObject("userVar", users);
        response.addObject("search", searchQuery); // Assuming you want to use the search query for display
        for (User user : users) {
            log.debug("User: id = " + user.getId() + ", last name = " + user.getLastname());
        }
    }

    return response;
}




    }*/