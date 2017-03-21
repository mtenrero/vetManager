package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.BusinessLogic.Helpers.AppointmentMerger;
import es.urjc.etsii.mtenrero.Entities.Appointment;
import es.urjc.etsii.mtenrero.Entities.Client;
import es.urjc.etsii.mtenrero.Repositories.AppointmentRepository;
import es.urjc.etsii.mtenrero.Repositories.ClientRepository;
import es.urjc.etsii.mtenrero.Repositories.PetRepository;
import es.urjc.etsii.mtenrero.Repositories.PreferenceRepository;
import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created by marcostenrero on 14/3/17.
 */
@Controller
public class ClientDashboardController {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    PreferenceRepository preferenceRepository;
    @Autowired
    PetRepository petRepository;

    @GetMapping("/clientDashboard")
    public String getLanding(Model model, Pageable page) {
        model.addAttribute("title", VetmanagerApplication.appName);
        model.addAttribute("navClients", true);

        return "publicClientView";
    }


    @GetMapping("/clientDashboard/my-preferences")
    public String getMyPreferences(Principal principal, Model model, Pageable page) {
        model.addAttribute("title", VetmanagerApplication.appName);
        model.addAttribute("navClients", true);
        model.addAttribute("client", clientRepository.findByLegalID(Integer.parseInt(principal.getName())));

        System.out.print(principal.getName());

        return "clientFrontend/personal_preferences";
    }


    /** UPDATE CONTROLLERS **/
    @PostMapping("/clientDashboard/my-preferences")
   public String updateMyPreferences(Principal principal, Model model, @RequestParam("hours") int hours) {

        Client existingClient = clientRepository.findByLegalID(Integer.parseInt(principal.getName()));

        existingClient.setHoursBeforeNotification(hours);

        if (clientRepository.save(existingClient) != null) {
            model.addAttribute("title", VetmanagerApplication.appName);
            model.addAttribute("navClients", true);
            model.addAttribute("savedClient", true);
            model.addAttribute("toastMessage", "Client updated correctly!");

        }



        return "publicClientView";
    }

    @GetMapping("/clientDashboard/my-data")
    public String getMyData(Principal principal, Model model, Pageable page) {
        model.addAttribute("title", VetmanagerApplication.appName);
        model.addAttribute("navClients", true);
        model.addAttribute("client", clientRepository.findByLegalID(Integer.parseInt(principal.getName())));

        System.out.print(principal.getName());

        return "clientFrontend/personal_data";
    }


    /** UPDATE CONTROLLERS **/
    @PostMapping("/clientDashboard/my-data")
    public String updateMyData(Principal principal, Model model, @ModelAttribute("client") Client updatedClient) {

        Client existingClient = clientRepository.findByLegalID(Integer.parseInt(principal.getName()));

        existingClient.setFirstName(updatedClient.getFirstName());
        existingClient.setLastName(updatedClient.getLastName());
        existingClient.setAddressCity(updatedClient.getAddressCity());
        existingClient.setAddressStreet(updatedClient.getAddressStreet());
        existingClient.setAddressZIP(updatedClient.getAddressZIP());
        existingClient.setEmail(updatedClient.getEmail());
        existingClient.setPhone1(updatedClient.getPhone1());
        existingClient.setPhone2(updatedClient.getPhone2());

        clientRepository.save(existingClient);

        model.addAttribute("title", VetmanagerApplication.appName);
        model.addAttribute("navClients", true);
        model.addAttribute("savedClient", true);
        model.addAttribute("toastMessage", "Client updated correctly!");

        return "publicClientView";
    }

   @GetMapping("clientDashboard/my-pets")
    public String getMyPets(Principal principal, Model model) {
        model.addAttribute("title", VetmanagerApplication.appName);
        model.addAttribute("navClients", true);
        model.addAttribute("pets", clientRepository.findByLegalID(Integer.parseInt(principal.getName())).getPets());

        return "clientFrontend/pets_data";
   }

   @GetMapping("clientDashboard/my-appointments")
    public String getMyAppointments(Principal principal, Model model) {
       AppointmentMerger appointmentMerger = new AppointmentMerger(clientRepository);
       model.addAttribute("title", VetmanagerApplication.appName);
       model.addAttribute("navClients", true);
       model.addAttribute("appointments", appointmentMerger.getAppointmentsByClient(
               clientRepository.findByLegalID(Integer.parseInt(principal.getName()))
       ));
       model.addAttribute("pets", clientRepository.findByLegalID(Integer.parseInt(principal.getName())).getPets());
       model.addAttribute("intervals",this.preferenceRepository.findAll().get(0).generateWeekdayAppointmentIntervals());

       return "clientFrontend/appointments_data";
   }

    @PostMapping("/clientDashboard/my-appointments/new")
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
        }
        model.addAttribute("Appointment", appointmentRepository.findAll());
        return "clientFrontend/my-appointments";
    }

}
