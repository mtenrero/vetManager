package es.urjc.etsii.mtenrero.Repositories;

import es.urjc.etsii.mtenrero.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by was12 on 04/02/2017.
 */
public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet findById(long id);

}
