package es.urjc.etsii.mtenrero.Repositories;

import es.urjc.etsii.mtenrero.Entities.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Adrian on 2/14/17.
 */
public interface PreferenceRepository extends MongoRepository<Preference,Long> {

}
