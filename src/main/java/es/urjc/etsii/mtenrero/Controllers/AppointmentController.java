package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.Communication;
import es.urjc.etsii.mtenrero.Entities.Client;
import es.urjc.etsii.mtenrero.Entities.Pet;
import es.urjc.etsii.mtenrero.Entities.Appointment;
import es.urjc.etsii.mtenrero.Entities.Pet_Breed;
import es.urjc.etsii.mtenrero.Repositories.AppointmentRepository;
import es.urjc.etsii.mtenrero.Repositories.ClientRepository;
import es.urjc.etsii.mtenrero.Repositories.PetRepository;
import es.urjc.etsii.mtenrero.Repositories.PreferenceRepository;
import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
    PreferenceRepository preferenceRepository;

    @RequestMapping("/dashboard/appointments")
    public String getLanding(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Appointments");
        model.addAttribute("navAppointments", true);

        model.addAttribute("intervals",this.preferenceRepository.findAll().get(0).generateWeekdayAppointmentIntervals());
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

        if (appointmentRepository.save(appointment) != null) {
            model.addAttribute("savedClient", true);
            model.addAttribute("toastMessage", "Appointment saved correctly!");
            try {
                new Communication().main(petRepository.findById(petId).getClient().getEmail(),"Se concerto una cita","Tu mascota tiene fechada una consulta");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("intervals",this.preferenceRepository.findAll().get(0).generateWeekdayAppointmentIntervals());
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