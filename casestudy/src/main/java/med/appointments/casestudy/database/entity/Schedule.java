package med.appointments.casestudy.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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

    @FutureOrPresent
     @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "appointment_date")
    private Date appointmentDate;

    @Column(name = "comments")
    private String comments;



    //@ManyToOne(cascade = {CascadeType.ALL, CascadeType.MERGE})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id_number")
    private Location location;  // Use Location entity for association



    // Add a transient property for patientName
    @Transient
    private String patientName;


}


/*   private Date appointmentDate;

 private String comments;
 */