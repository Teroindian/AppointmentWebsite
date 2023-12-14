package med.appointments.casestudy.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "doctor_location")
@Getter
@Setter
public class DoctorLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor_location")
    private Integer id;

    @Column(name = "id_doctor")
    private Integer doctorId;

    @Column(name = "location_id")
    private Integer locationId;

}
