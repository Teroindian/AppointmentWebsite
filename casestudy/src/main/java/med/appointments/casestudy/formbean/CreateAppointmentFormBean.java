package med.appointments.casestudy.formbean;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateAppointmentFormBean {

    private Integer doctorScheduleId;
    private String appointmentDate;
    private String comments;
}
