package es.urjc.etsii.mtenrero.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by marcostenrero on 16/3/17.
 */
@Entity
public class Manager extends User {

    public final static String ROLE = "ROLE_MANAGER";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Manager() {
        super.setRoles(ROLE);
    }

    public Manager(String username, String password) {
        super.setLogon(username);
        super.setPasswordHash(password);
        super.setRoles(ROLE);
    }

    public Manager(String name, String password, String username) {
        super(name, password, ROLE);
        super.setLogon(username);
        super.setRoles(ROLE);

    }
}
