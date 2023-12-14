package med.appointments.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import med.appointments.casestudy.database.dao.UserDAO;
import med.appointments.casestudy.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;




        @GetMapping("/home/search")
    public ModelAndView search( @RequestParam(required = false) String firstName,
                                @RequestParam(required = false) String lastName){
        ModelAndView response = new ModelAndView("home/search");

            log.debug("In the User search controller method: firstName = " + firstName + ", lastName = " + lastName);



            if (firstName != null || lastName != null) {
                // Use both first name and last name parameters in the search
                List<User> users = userDAO.findByFirstNameOrLastName(firstName, lastName);
                response.addObject("userVar", users);
                response.addObject("search", firstName); // Assuming you want to use the first name for display
                for (User user : users) {
                    log.debug("User: id = " + user.getId() + ", last name = " + user.getLastName());
                }
            }

        return response;
    }


    @GetMapping("/users/doctorhome")
    public ModelAndView createDoctor(
    ){
        ModelAndView response = new ModelAndView("users/doctorhome");

        log.debug(" In create home doctor with no Args");
        return response;
    }


}
/*   @GetMapping("/customer/search")
    public ModelAndView search(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ) {
        ModelAndView response = new ModelAndView("customer/search");

        // Log the values received from the form
        log.debug("In the customer search controller method: firstName = " + firstName + ", lastName = " + lastName);

        if (firstName != null || lastName != null) {
            // Use both first name and last name parameters in the search
            List<User> users = userDAO.findByFirstNameOrLastName(firstName, lastName);
            response.addObject("customerVar", customers);
            response.addObject("search", firstName); // Assuming you want to use the first name for display
            for (User user : users) {
                log.debug("User: id = " + user.getId() + ", last name = " + user.getLastname());
            }
        }

        return response;
    }*/