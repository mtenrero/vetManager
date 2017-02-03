package es.urjc.etsii.mtenrero.Entities;

import javax.persistence.*;
import java.util.Date;

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
    private long breed;
    @OneToMany(cascade = CascadeType.ALL)
    private long weightHistoryID; // Weight Table ID
    @OneToMany(cascade = CascadeType.ALL)
    private long diagnosesID; // Diagnoses Table ID
    private Date birthday;
    private String layerColour;
    private String layerType;
    private boolean sterilised;
    private boolean agressive;
    private String prev_pathologies;

    public Pet() {
    }

    public Pet(long id, String name, String kind, long breed, long weightHistoryID, long diagnosesID, Date birthday, String layerColour, String layerType, boolean sterilised, boolean agressive, String prev_pathologies) {
        this.id = id;
        this.name = name;
        this.kind = kind;
        this.breed = breed;
        this.weightHistoryID = weightHistoryID;
        this.diagnosesID = diagnosesID;
        this.birthday = birthday;
        this.layerColour = layerColour;
        this.layerType = layerType;
        this.sterilised = sterilised;
        this.agressive = agressive;
        this.prev_pathologies = prev_pathologies;
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

    public long getBreed() {
        return breed;
    }

    public void setBreed(long breed) {
        this.breed = breed;
    }

    public long getWeightHistoryID() {
        return weightHistoryID;
    }

    public void setWeightHistoryID(long weightHistoryID) {
        this.weightHistoryID = weightHistoryID;
    }

    public long getDiagnosesID() {
        return diagnosesID;
    }

    public void setDiagnosesID(long diagnosesID) {
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
