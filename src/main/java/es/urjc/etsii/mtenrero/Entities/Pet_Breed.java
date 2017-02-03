package es.urjc.etsii.mtenrero.Entities;

import javax.persistence.*;

/**
 * Created by mtenrero on 03/02/2017.
 */
public class Pet_Breed {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private long pet_ID;
    private String breed;
}
