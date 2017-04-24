package es.urjc.etsii.mtenrero.Entities;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by was12 on 14/03/2017.
 */
@MappedSuperclass
public abstract class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique=true)
    private String logon;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    public User() {
        this.roles = new ArrayList<>();
    }

    public User(String name, String password, String... roles) {
        this.logon = name;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.roles = new ArrayList<>(Arrays.asList(roles));
    }

    public String getLogon() {
        return logon;
    }

    public void setLogon(String logon) {
        this.logon = logon;
    }

    public String getPasswordHash() {
        return password;
    }

    public void setPasswordHash(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    public void setRoles(String... roles) {
        this.roles = new ArrayList<>(Arrays.asList(roles));
    }

    public List<String> getRoles() {
        return roles;
    }
}
