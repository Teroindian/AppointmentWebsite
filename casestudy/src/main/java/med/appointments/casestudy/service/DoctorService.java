package med.appointments.casestudy.service;


import lombok.extern.slf4j.Slf4j;
import med.appointments.casestudy.database.dao.DoctorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DoctorService {

    @Autowired
    private DoctorDAO doctorDAO;
}
