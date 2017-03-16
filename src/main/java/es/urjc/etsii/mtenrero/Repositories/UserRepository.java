package es.urjc.etsii.mtenrero.Repositories;

import es.urjc.etsii.mtenrero.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by marcostenrero on 16/3/17.
 */
@NoRepositoryBean
public interface UserRepository<T extends User> extends JpaRepository<T, Long> {

    T findByLogon(String logon);

}
