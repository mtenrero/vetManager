package es.urjc.etsii.mtenrero.Entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by mtenrero on 03/02/2017.
 */
@Entity
public class Pet_WeightHistory {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private long dog_id;
    private float weight;
    private Date date;

    public Pet_WeightHistory() {
    }

    public Pet_WeightHistory(long dog_id, float weight, Date date) {
        this.dog_id = dog_id;
        this.weight = weight;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDog_id() {
        return dog_id;
    }

    public void setDog_id(long dog_id) {
        this.dog_id = dog_id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
