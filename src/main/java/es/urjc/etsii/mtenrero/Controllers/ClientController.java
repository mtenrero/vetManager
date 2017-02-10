package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.Entities.Client;
import es.urjc.etsii.mtenrero.Repositories.ClientRepository;
import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @PostConstruct
    public void init() {
        clientRepository.save(new Client(457324402, "Hola aracola","",122, "XXX"));
        clientRepository.save(new Client(457394402, "Hola caracola","sjsj", 1212, "XXXX"));
    }

    @GetMapping("/dashboard/clients")
    public String getLanding(Model model,Pageable page) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Clients");

        model.addAttribute("navClients", true);
        model.addAttribute("client",clientRepository.findAll(page));

        return "clients";
    }

    @GetMapping("/dashboard/clients/new")
    public String addClient(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Add new Client");

        model.addAttribute("navClients", true);

        return "addClient";
    }

    @PostMapping("/dashboard/clients/new")
    public String saveClient(Model model, @RequestParam int legalID, @RequestParam String firstName, @RequestParam String lastName, @RequestParam Optional<Integer> phone1, @RequestParam int phone2, @RequestParam String addressStreet, @RequestParam String addressCity, @RequestParam int addressZIP, @RequestParam String email) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Clients");
        model.addAttribute("navClients", true);
        Client client=new Client(legalID,firstName,lastName,phone1.get(),email);
        if (clientRepository.save(client) != null) {
            model.addAttribute("savedClient", true);
            model.addAttribute("toastMessage", "Client saved correctly!");
        }
        model.addAttribute("client",clientRepository.findAll());
        return "clients";
    }

}
