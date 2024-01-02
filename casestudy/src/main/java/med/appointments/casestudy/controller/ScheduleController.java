package med.appointments.casestudy.controller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import med.appointments.casestudy.database.dao.ScheduleDAO;
import med.appointments.casestudy.database.entity.Schedule;
import med.appointments.casestudy.database.entity.User;
import med.appointments.casestudy.formbean.CreateAppointmentFormBean;
import med.appointments.casestudy.service.AppointmentService;
import med.appointments.casestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Slf4j
@Controller



public class ScheduleController {


    @Autowired
    private ScheduleDAO scheduleDAO;

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private UserService userService;


    @GetMapping("/doctor/schedule/{userId}")
    public ModelAndView schedule(@PathVariable int userId) {
        ModelAndView response = new ModelAndView();
        response.setViewName("doctor/schedule");

        // Retrieve schedule by userId
        Schedule schedule = scheduleDAO.findById(userId);

        // Add the schedule to the response
        response.addObject("schedule", schedule);

        return response;
    }


    // Existing method to view the schedule
    @GetMapping("/schedule/{id}")
    public ModelAndView viewSchedule(@PathVariable int scheduleId) {
        ModelAndView response = new ModelAndView("doctor/schedule");

        // Fetch the schedule details
        Schedule schedule = scheduleDAO.findById(scheduleId);
        response.addObject("schedule", schedule);

        return response;
    }

    // New method to display the form for creating a new appointment
   /* @GetMapping("/schedule/{scheduleId}/create-appointment")
    public ModelAndView showCreateAppointmentForm(@PathVariable int scheduleId) {
        ModelAndView response = new ModelAndView("doctor/create-appointment");

        // Fetch the schedule details
        Schedule schedule = scheduleDAO.findById(scheduleId);
        response.addObject("schedule", schedule);

        // Add doctor's ID to the model
        response.addObject("doctorId", schedule.getDoctorId());

        // Create a new form bean for appointment details
        CreateAppointmentFormBean formBean = new CreateAppointmentFormBean();
        formBean.setDoctorScheduleId(scheduleId);

        response.addObject("form", formBean);

        return response;
    }*/


    // New method to handle the form submission for creating a new appointment
    @PostMapping("/schedule/create-appointment")
    public ModelAndView createAppointment(@RequestParam(name = "doctorId", required = false) Integer doctorId,
                                          @Valid CreateAppointmentFormBean form,
                                          BindingResult bindingResult,
                                           Principal principal) {

        ModelAndView response = new ModelAndView("redirect:/doctor/schedule/" + doctorId);

        // Check if doctorId is null or not
        if (doctorId == null) {
            // Handle the case where doctorId is not provided
            return response.addObject("error", "Doctor ID is required");
        }

        if (bindingResult.hasErrors()) {
            // If there are validation errors, handle them as needed
            // Redirect back to the create appointment form with an error message, for example
            return response.addObject("error", "Invalid input for appointment");
        }

        // Get the logged-in user's ID
        String username = principal.getName();
        User loggedInUser = userService.findUserByEmail(username);

        // Check if the logged-in user is a patient
        if (userService.isPatient(loggedInUser.getId())) {
            // If the logged-in user is a patient, use their ID as the patient ID
            Integer patientId = loggedInUser.getId();

            // Create a new appointment
            Schedule createdAppointment = appointmentService.createNewAppointment(patientId, doctorId, form);

            if (createdAppointment == null) {
                // Handle the case where the appointment creation fails
                return response.addObject("error", "Failed to create appointment");
            }

            // Optionally, you can add a success message
            return response.addObject("success", "Appointment created successfully");
        } else {
            // If the logged-in user is not a patient, return an error
            return response.addObject("error", "You are not authorized to create appointments");
        }
    }

}

