package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.Entities.Client;
import es.urjc.etsii.mtenrero.Entities.Pet;
import es.urjc.etsii.mtenrero.Entities.Appointment;
import es.urjc.etsii.mtenrero.Entities.Pet_Breed;
import es.urjc.etsii.mtenrero.Repositories.AppointmentRepository;
import es.urjc.etsii.mtenrero.Repositories.ClientRepository;
import es.urjc.etsii.mtenrero.Repositories.PetRepository;
import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

/**
 * Created by mtenrero on 28/01/2017.
 */
@Controller
public class AppointmentController {
    @Autowired
    PetRepository petRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    ClientRepository clientRepository;

    @RequestMapping("/dashboard/appointments")
    public String getLanding(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Appointments");
        model.addAttribute("navAppointments", true);
        model.addAttribute("Appointment", appointmentRepository.findAll());
        return "appointments";
    }

    @PostMapping("/dashboard/appointments")
    public String addAppointment(Model model,
                                 @RequestParam String hour,
                                 @RequestParam String consult,
                                 @RequestParam long petId
    ) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Appointments");
        model.addAttribute("navAppointments", true);
        Appointment appointment = new Appointment(hour, petRepository.findById(petId), consult);
        appointment.setClient(petRepository.findById(petId).getClient());
        appointment.setBreed(petRepository.findById(petId).getBreed());
        if (appointmentRepository.save(appointment) != null) {
            model.addAttribute("savedClient", true);
            model.addAttribute("toastMessage", "Appointment saved correctly!");
        }
        model.addAttribute("Appointment", appointmentRepository.findAll());
        return "appointments";
    }
    @GetMapping("/dashboard/appointments/{id}")
    public String getinfo(Model model,@PathVariable long id) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Clients");
        model.addAttribute("navClients", true);
        model.addAttribute("appointments",appointmentRepository.findOne(id));
        return "appointment_view";
    }
}
