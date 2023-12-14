package med.appointments.casestudy.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "schedule")
@Getter
@Setter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "doctor_id")
    private Integer doctorId;

    @Column(name = "patient_id")
    private Integer patientId;

   // @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "appointment_date")
    private Date appointmentDate;

    @Column(name = "comments")
    private String comments;

    @Column(name = "location_id_number")
    private Integer locationId;




}
