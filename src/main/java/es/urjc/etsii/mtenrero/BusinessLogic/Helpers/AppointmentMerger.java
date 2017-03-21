package es.urjc.etsii.mtenrero.BusinessLogic.Helpers;

import es.urjc.etsii.mtenrero.Entities.Appointment;
import es.urjc.etsii.mtenrero.Entities.Client;
import es.urjc.etsii.mtenrero.Entities.Pet;
import es.urjc.etsii.mtenrero.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcostenrero on 21/3/17.
 */
public class AppointmentMerger {

    ClientRepository clientRepository;

    public AppointmentMerger(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Appointment> getAppointmentsByClient(Client client) {

        List<Appointment> appointments = new ArrayList<>();

        for (Pet pet : client.getPets()) {
            appointments.addAll(pet.getAppointment());
        }

        return appointments;
    }
}
