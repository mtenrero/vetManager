package es.urjc.etsii.mtenrero.Entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mtenrero on 03/02/2017.
 */
@Entity
public class Pet_Breed {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany(mappedBy = "breed")
    private List<Pet> pet_ID;
    private String breed;
}
