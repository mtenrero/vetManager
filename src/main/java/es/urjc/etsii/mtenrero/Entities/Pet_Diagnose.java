package es.urjc.etsii.mtenrero.Entities;

import javax.persistence.*;

/**
 * Created by mtenrero on 03/02/2017.
 */
@Entity
public class Pet_Diagnose {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Pet_Diagnose() {
    }



}
