package es.urjc.etsii.mtenrero.Repositories;

import es.urjc.etsii.mtenrero.Entities.Appointment;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by was12 on 13/02/2017.
 */

public interface AppointmentRepository extends JpaRepository<Appointment,Long>{
   @Cacheable("vetmanager")
   List<Appointment> findByDate(String date);
   @CachePut("vetmanager")
   Appointment save(Appointment appointment);
}
