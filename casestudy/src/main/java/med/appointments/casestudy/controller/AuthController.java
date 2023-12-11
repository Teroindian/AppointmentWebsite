package med.appointments.casestudy.controller;



import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
//import med.appointments.casestudy.database.dao.DoctorDAO;
//import med.appointments.casestudy.database.entity.Doctor;
import med.appointments.casestudy.database.entity.User;
//import med.appointments.casestudy.formbean.CreateDoctorFormBean;
import med.appointments.casestudy.formbean.RegisterUserFormBean;

import med.appointments.casestudy.security.AuthenticatedUserService;
import med.appointments.casestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
class AuthController {


    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/auth/register")
    public ModelAndView register() {

        ModelAndView response = new ModelAndView();
        response.setViewName("auth/register");
        return response;
    }


    @GetMapping("/auth/login")
    public ModelAndView login() {
        ModelAndView response = new ModelAndView();
        response.setViewName("auth/login");
        return response;
    }



    @GetMapping("/auth/registerSubmit")
    public ModelAndView registerSubmit(@Valid RegisterUserFormBean form, BindingResult bindingResult, HttpSession session)
    {


        if (bindingResult.hasErrors()) {
            log.info("######################### In register user submit - has errors #########################");
            ModelAndView response = new ModelAndView("auth/register");

            for ( ObjectError error : bindingResult.getAllErrors() ) {
                log.info("error: " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }

        log.info("######################### In register user submit #########################");

        User u =   userService.createNewUser(form);


        //this line of code will authenticate the brand new user appk
        authenticatedUserService.authenticateNewUser(session,u.getEmail(),form.getPassword());


        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/");


        return response;
    }


}

//public class AuthController {
//}
