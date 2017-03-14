package es.urjc.etsii.mtenrero.Entities;

import javax.persistence.*;

/**
 * Created by was12 on 04/02/2017.
 */
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String date;
    @ManyToOne
    private Pet pet;
    private String color;
    private String category;
    private String hour;
    private String minute;
    private String duration;
    private int cost;
    public Appointment() {

    }

    public Appointment(String date, Pet pet, String category) {
        this.date = date;
        this.pet = pet;
        this.category = category;
        this.color=this.gettingColor(category);

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    private String gettingColor(String category){
        switch (this.category){
            case "Query":{
                return "brown darken-4";
            }case "Vaccine":{
                return "pink ";
            }case "Review":{
                return "deep-purple darken-2";
            }case "Surgery":{
                return " teal lighten-3";
            }case "Urgency":{
                return " red darken-4";
            }
            default:{
                return " lime darken-4";
            }
        }
    }
}
