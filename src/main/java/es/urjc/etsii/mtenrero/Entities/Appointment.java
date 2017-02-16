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
    @ManyToOne
    private Client client;
    @ManyToOne
    private Pet_Breed breed;
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

    public Pet_Breed getBreed() {
        return breed;
    }

    public void setBreed(Pet_Breed breed) {
        this.breed = breed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
