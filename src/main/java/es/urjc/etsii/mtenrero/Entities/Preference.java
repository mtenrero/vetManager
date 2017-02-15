package es.urjc.etsii.mtenrero.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

/**
 * Created by Adrian on 2/14/17.
 */
@Entity
public class Preference {

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

    @Id private Date created = new Date();


}
