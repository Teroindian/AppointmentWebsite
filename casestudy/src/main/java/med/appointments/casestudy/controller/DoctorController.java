package med.appointments.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import med.appointments.casestudy.database.dao.DoctorDAO;
import med.appointments.casestudy.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller

public class DoctorController {

    @Autowired
    private DoctorDAO doctorDAO;

    @Autowired
    private DoctorService doctorService;


    @GetMapping("/doctor/create")
    public ModelAndView createDoctor(
    ){
        ModelAndView response = new ModelAndView("doctor/create");

        log.debug(" In create doctor with no Args");
        return response;
    }


}
