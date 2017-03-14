package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.Entities.User;
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
    private UserRepository userRepository;
    @PostConstruct
    private void initDatabase() {
        //NO DESCOMENTAR BAJO NINGUN CONCEPTO //SON EJEMPLOS
        //SI SE CARGAN DE NUEVO EL PROGRAMA EXPLOTA
        //FUTURA ACTUALIZACION CAMBIAR LA CLAVE PRINCIPAL DE LA CLASE USER
        //^PARA QUE NO EXIStAN CLOneS
       /**
        userRepository.save(new User("999", "vetmanager",  "ROLE_MANAGER"));
        userRepository.save(new User("1234", "cliente", "ROLE_CLIENT"));**/
    }
}
