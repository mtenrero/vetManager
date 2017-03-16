package es.urjc.etsii.mtenrero.Repositories;

import es.urjc.etsii.mtenrero.Entities.Client;
import es.urjc.etsii.mtenrero.Entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by marcostenrero on 16/3/17.
 */
@Transactional
public interface ManagerRepository extends UserRepository<Manager> {
}
