package es.urjc.etsii.mtenrero.Repositories;

import es.urjc.etsii.mtenrero.Entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by was12 on 14/03/2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
}