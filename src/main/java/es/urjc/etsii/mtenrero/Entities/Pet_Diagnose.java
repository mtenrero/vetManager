package es.urjc.etsii.mtenrero.Entities;

import javax.persistence.*;

/**
 * Created by mtenrero on 03/02/2017.
 */
public class Pet_Diagnose {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private long pet_id;

    // TODO Develop Diagnose Entity


    public Pet_Diagnose() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPet_id() {
        return pet_id;
    }

    public void setPet_id(long pet_id) {
        this.pet_id = pet_id;
    }
}
