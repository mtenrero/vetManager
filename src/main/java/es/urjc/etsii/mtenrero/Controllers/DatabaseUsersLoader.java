package es.urjc.etsii.mtenrero.Controllers;


import es.urjc.etsii.mtenrero.Entities.Client;
import es.urjc.etsii.mtenrero.Entities.Manager;
import es.urjc.etsii.mtenrero.Repositories.ClientRepository;
import es.urjc.etsii.mtenrero.Repositories.ManagerRepository;
import es.urjc.etsii.mtenrero.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by was12 on 14/03/2017.
 */
@Component
public class DatabaseUsersLoader {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private ClientRepository clientRepository;
    @PostConstruct
    private void initDatabase() {

        // Si no hay ningun manager, crea uno por defecto
        if (managerRepository.findAll().size() == 0) {
            managerRepository.save(new Manager("manager", "vetmanager"));
        }

        if (clientRepository.findAll().size() == 0) {
            Client def = new Client(123456789,"Marcos","Tenrero");
            def.setPhone1(123456789);
            clientRepository.save(def);
        }



    }
}
