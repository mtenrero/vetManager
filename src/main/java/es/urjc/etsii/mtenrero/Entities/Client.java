package es.urjc.etsii.mtenrero.Entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mtenrero on 03/02/2017.
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int legalID;
    private String firstName;
    private String lastName;
    private int phone1;
    private int phone2;
    private String addressStreet;
    private String addressCity;
    private int addressZIP;
    private String email;
    @OneToMany(mappedBy = "client" , cascade = CascadeType.ALL)
    private List<Pet> pets;

    public Client() {
    }

    public Client(int legalID, String firstName, String lastName, int phone1, String addressStreet, String addressCity, int addressZIP, String email) {
        this.legalID = legalID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone1 = phone1;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.addressZIP = addressZIP;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLegalID() {
        return legalID;
    }

    public void setLegalID(int legalID) {
        this.legalID = legalID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone1() {
        return phone1;
    }

    public void setPhone1(int phone1) {
        this.phone1 = phone1;
    }

    public int getPhone2() {
        return phone2;
    }

    public void setPhone2(int phone2) {
        this.phone2 = phone2;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public int getAddressZIP() {
        return addressZIP;
    }

    public void setAddressZIP(int addressZIP) {
        this.addressZIP = addressZIP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
