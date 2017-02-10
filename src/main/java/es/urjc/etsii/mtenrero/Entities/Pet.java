package es.urjc.etsii.mtenrero.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by mtenrero on 03/02/2017.
 */
@Entity
public class Pet {

    @Id
    private long id; // Chip ID
    private String name;
    private String kind;
    @ManyToOne(cascade = CascadeType.ALL)
    private Pet_Breed breed;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pet_WeightHistory> weightHistoryID; // Weight Table ID
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pet_Diagnose> diagnosesID; // Diagnoses Table ID
    private Date birthday;
    private String layerColour;
    private String layerType;
    private boolean sterilised;
    private boolean agressive;
    private String prev_pathologies;
    @ManyToOne
    private Client client;
    public Pet() {
    }

    public Pet(long id, String name, String kind) {
        this.id = id;
        this.name = name;
        this.kind = kind;

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Pet_Breed getBreed() {
        return breed;
    }

    public void setBreed(Pet_Breed breed) {
        this.breed = breed;
    }

    public List<Pet_WeightHistory> getWeightHistoryID() {
        return weightHistoryID;
    }

    public void setWeightHistoryID(List<Pet_WeightHistory> weightHistoryID) {
        this.weightHistoryID = weightHistoryID;
    }

    public List<Pet_Diagnose> getDiagnosesID() {
        return diagnosesID;
    }

    public void setDiagnosesID(List<Pet_Diagnose> diagnosesID) {
        this.diagnosesID = diagnosesID;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLayerColour() {
        return layerColour;
    }

    public void setLayerColour(String layerColour) {
        this.layerColour = layerColour;
    }

    public String getLayerType() {
        return layerType;
    }

    public void setLayerType(String layerType) {
        this.layerType = layerType;
    }

    public boolean isSterilised() {
        return sterilised;
    }

    public void setSterilised(boolean sterilised) {
        this.sterilised = sterilised;
    }

    public boolean isAgressive() {
        return agressive;
    }

    public void setAgressive(boolean agressive) {
        this.agressive = agressive;
    }

    public String getPrev_pathologies() {
        return prev_pathologies;
    }

    public void setPrev_pathologies(String prev_pathologies) {
        this.prev_pathologies = prev_pathologies;
    }
}
