package es.urjc.etsii.mtenrero.Controllers;


import es.urjc.etsii.mtenrero.Entities.Manager;
import es.urjc.etsii.mtenrero.Repositories.ManagerRepository;
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
    @PostConstruct
    private void initDatabase() {
        //NO DESCOMENTAR BAJO NINGUN CONCEPTO //SON EJEMPLOS
        //SI SE CARGAN DE NUEVO EL PROGRAMA EXPLOTA
        //FUTURA ACTUALIZACION CAMBIAR LA CLAVE PRINCIPAL DE LA CLASE USER
        //PARA QUE NO EXISTAN CLONES

        //managerRepository.save(new Manager("999", "vetmanager"));
        //userRepository.save(new User("1234", "cliente", "ROLE_CLIENT"));
    }
}
