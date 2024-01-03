package med.appointments.casestudy.formbean;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateAppointmentFormBean {

  private String appointmentDate;
  private String comments;
  private Integer doctorId;
  private Integer locationId;
  @Getter
  private String locationName;  // Add this field for locationName

  // ... other fields and methods

}
