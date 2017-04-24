package es.urjc.etsii.mtenrero.Repositories;


import es.urjc.etsii.mtenrero.Entities.Client;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.Collection;

/**
 * Created by was12 on 04/02/2017.
 */

public interface ClientRepository extends UserRepository<Client> {
    @CachePut("vetmanager")
    Client save(Client client);
    @Cacheable("vetmanager")
    Client findByLegalID(int legalID);

    Collection<? extends Client> findFirst10ByPhone1(int i);

    Collection<? extends Client> findFirst10ByLastNameContainingIgnoreCase(String word);

    Collection<? extends Client> findFirst10ByFirstNameContainingIgnoreCase(String word);

    Collection<? extends Client> findFirst10ByLegalID(int i);
    @Cacheable("vetmanager")
    Client findById(long id);
}
