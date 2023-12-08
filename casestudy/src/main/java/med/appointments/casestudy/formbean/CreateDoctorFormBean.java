package med.appointments.casestudy.formbean;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDoctorFormBean {



    private Integer id;

    private String firstname;

    private String lastname;

    private String specialization;

    private String email;

    private String phone;
}
