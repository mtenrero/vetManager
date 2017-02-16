package es.urjc.etsii.mtenrero.Entities;

import javax.persistence.*;
import java.util.ArrayList;
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
    @ManyToOne
    private Pet_Breed breed;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pet_WeightHistory> weightHistoryID; // Weight Table ID
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pet_Diagnose> diagnosesID; // Diagnoses Table ID
    private String birthday;
    private String layerColour;
    private String layerType;
    private boolean sterilised;
    private boolean agressive;
    private String prev_pathologies;
    @ManyToOne
    private Client client;
    private String stade;
    public Pet() {
    }

    public Pet_Breed getBreed() {
        return breed;
    }

    public void setBreed(Pet_Breed breed) {
        this.breed = breed;
    }

    public Pet(long id, String name, String kind, String birthday, String layerColour, String layerType, boolean sterilised, boolean agressive, String prev_pathologies) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.birthday = birthday;
        this.layerColour = layerColour;
        this.layerType = layerType;
        this.sterilised = sterilised;
        this.agressive = agressive;
        this.prev_pathologies = prev_pathologies;
        this.stade="Alive";
        this.weightHistoryID=new ArrayList<>();
        this.diagnosesID=new ArrayList<>();
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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
