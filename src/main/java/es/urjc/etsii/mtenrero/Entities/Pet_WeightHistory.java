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
    private float weight;
    private Date date;

    public Pet_WeightHistory() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
