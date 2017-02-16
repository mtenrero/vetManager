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
    @OneToMany
    private List<Pet> pet_id;
    private String breed;

    public Pet_Breed() {
    }

    public Pet_Breed(String breed) {
        this.breed = breed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Pet> getPet_id() {
        return pet_id;
    }

    public void setPet_id(List<Pet> pet_id) {
        this.pet_id = pet_id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
