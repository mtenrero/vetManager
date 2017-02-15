package es.urjc.etsii.mtenrero.Repositories;

import es.urjc.etsii.mtenrero.Entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by was12 on 13/02/2017.
 */
public interface AppointmentRepository extends JpaRepository<Appointment,Long>{
   List<Appointment> findByDate(String date);
}
