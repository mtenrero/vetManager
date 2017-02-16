package es.urjc.etsii.mtenrero.Repositories;

import es.urjc.etsii.mtenrero.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by was12 on 04/02/2017.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByLegalID(int legalID);
}
