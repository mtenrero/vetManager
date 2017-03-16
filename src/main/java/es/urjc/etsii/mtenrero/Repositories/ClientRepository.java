package es.urjc.etsii.mtenrero.Repositories;

import com.mongodb.gridfs.CLI;
import es.urjc.etsii.mtenrero.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by was12 on 04/02/2017.
 */
public interface ClientRepository extends UserRepository<Client> {
    Client findByLegalID(int legalID);

    Collection<? extends Client> findFirst10ByPhone1(int i);

    Collection<? extends Client> findFirst10ByLastNameContainingIgnoreCase(String word);

    Collection<? extends Client> findFirst10ByFirstNameContainingIgnoreCase(String word);

    Collection<? extends Client> findFirst10ByLegalID(int i);



    Client findById(long id);
}
