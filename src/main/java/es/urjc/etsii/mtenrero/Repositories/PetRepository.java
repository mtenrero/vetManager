package es.urjc.etsii.mtenrero.Repositories;

import es.urjc.etsii.mtenrero.Entities.Pet;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by was12 on 04/02/2017.
 */

public interface PetRepository extends JpaRepository<Pet, Long> {
    @CachePut("vetmanager")
    Pet save(Pet pet);
    @Cacheable("vetmanager")
    Pet findById(long id);

}
