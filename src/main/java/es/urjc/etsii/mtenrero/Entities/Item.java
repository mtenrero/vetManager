package es.urjc.etsii.mtenrero.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by was12 on 06/02/2017.
 */
@Entity
public class Item{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String factory;
    private int quantity;
    private long price;
    private String definition;
    private String diseases;
    private String caducity;
    private String category;
    private String species;
    public String getName() {
        return name;
    }

    public Item() {

    }

    public Item(String name, String factory, int quantity, long price, String definition) {
        this.name = name;
        this.factory = factory;
        this.quantity = quantity;
        this.price = price;
        this.definition = definition;

    }



    public int getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getCaducity() {
        return caducity;
    }

    public void setCaducity(String caducity) {
        this.caducity = caducity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }
}
