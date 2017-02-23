package es.urjc.etsii.mtenrero.Entities;

import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Adrian on 2/14/17.
 */
@Entity
public class Preference {
    public Preference() {
    }

    public Preference(int maxClientsPerPage, int maxPetsPerPage, int maxItemsPerPage, int minutesPerNormalApointment, int minutesPerVaccineApointment, int openingWeekdayTime, int closingWeekdayTime, int openingWeekendTime, int closingWeekendTime, boolean mon, boolean tue, boolean wed, boolean thu, boolean fri, boolean sat, boolean sun) {
        this.maxClientsPerPage = maxClientsPerPage;
        this.maxPetsPerPage = maxPetsPerPage;
        this.maxItemsPerPage = maxItemsPerPage;
        this.minutesPerNormalApointment = minutesPerNormalApointment;
        this.minutesPerVaccineApointment = minutesPerVaccineApointment;
        this.openingWeekdayTime = openingWeekdayTime;
        this.closingWeekdayTime = closingWeekdayTime;
        this.openingWeekendTime = openingWeekendTime;
        this.closingWeekendTime = closingWeekendTime;
        this.mon = mon;
        this.tue = tue;
        this.wed = wed;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
    }

    private int maxClientsPerPage;
    private int maxPetsPerPage;
    private int maxItemsPerPage;
    private int minutesPerNormalApointment;
    private int minutesPerVaccineApointment;

    private int openingWeekdayTime;
    private int closingWeekdayTime;
    private int openingWeekendTime;
    private int closingWeekendTime;

    private boolean mon;
    private boolean tue;
    private boolean wed;
    private boolean thu;
    private boolean fri;
    private boolean sat;
    private boolean sun;

    @Id
    private String id;
    private Date created = new Date();


    public ArrayList<String> generateWeekdayAppointmentIntervals() {
        LocalDateTime openingWeekday = LocalDateTime.of(2016,2,16,this.openingWeekdayTime,0);
        LocalDateTime closingWeekday = LocalDateTime.of(2016,2,16,this.closingWeekdayTime,0);

        LocalDateTime current = openingWeekday;
        ArrayList<String> intervals = new ArrayList<String>();

        while (closingWeekday.isAfter(current)) {
            LocalDateTime plusDuration = current.plusMinutes(this.getMinutesPerNormalApointment());
            intervals.add(current.getHour()+":"+current.getMinute()+" - "+plusDuration.getHour()+":"+plusDuration.getMinute());
            current = plusDuration;

        }
        return intervals;
    }

    public int getMaxPetsPerPage() {
        return maxPetsPerPage;
    }

    public void setMaxPetsPerPage(int maxPetsPerPage) {
        this.maxPetsPerPage = maxPetsPerPage;
    }

    public int getMaxItemsPerPage() {
        return maxItemsPerPage;
    }

    public void setMaxItemsPerPage(int maxItemsPerPage) {
        this.maxItemsPerPage = maxItemsPerPage;
    }

    public int getMinutesPerNormalApointment() {
        return minutesPerNormalApointment;
    }

    public void setMinutesPerNormalApointment(int minutesPerNormalApointment) {
        this.minutesPerNormalApointment = minutesPerNormalApointment;
    }

    public int getMinutesPerVaccineApointment() {
        return minutesPerVaccineApointment;
    }

    public void setMinutesPerVaccineApointment(int minutesPerVaccineApointment) {
        this.minutesPerVaccineApointment = minutesPerVaccineApointment;
    }

    public int getOpeningWeekdayTime() {
        return openingWeekdayTime;
    }

    public void setOpeningWeekdayTime(int openingWeekdayTime) {
        this.openingWeekdayTime = openingWeekdayTime;
    }

    public int getClosingWeekdayTime() {
        return closingWeekdayTime;
    }

    public void setClosingWeekdayTime(int closingWeekdayTime) {
        this.closingWeekdayTime = closingWeekdayTime;
    }

    public int getOpeningWeekendTime() {
        return openingWeekendTime;
    }

    public void setOpeningWeekendTime(int openingWeekendTime) {
        this.openingWeekendTime = openingWeekendTime;
    }

    public int getClosingWeekendTime() {
        return closingWeekendTime;
    }

    public void setClosingWeekendTime(int closingWeekendTime) {
        this.closingWeekendTime = closingWeekendTime;
    }

    public boolean isMon() {
        return mon;
    }

    public void setMon(boolean mon) {
        this.mon = mon;
    }

    public boolean isTue() {
        return tue;
    }

    public void setTue(boolean tue) {
        this.tue = tue;
    }

    public boolean isWed() {
        return wed;
    }

    public void setWed(boolean wed) {
        this.wed = wed;
    }

    public boolean isThu() {
        return thu;
    }

    public void setThu(boolean thu) {
        this.thu = thu;
    }

    public boolean isFri() {
        return fri;
    }

    public void setFri(boolean fri) {
        this.fri = fri;
    }

    public boolean isSat() {
        return sat;
    }

    public void setSat(boolean sat) {
        this.sat = sat;
    }

    public boolean isSun() {
        return sun;
    }

    public void setSun(boolean sun) {
        this.sun = sun;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getMaxClientsPerPage() {
        return maxClientsPerPage;
    }

    public void setMaxClientsPerPage(int maxClientsPerPage) {
        this.maxClientsPerPage = maxClientsPerPage;
    }
}
