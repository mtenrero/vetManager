package es.urjc.etsii.mtenrero.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mtenrero on 03/02/2017.
 */
@Entity
public class Pet_Diagnose implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Pet_Diagnose() {
    }



}
