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

import javax.annotation.PostConstruct;

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

        return "clients";
    }

    @GetMapping("/dashboard/clients/new")
    public String addClient(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Add new Client");

        model.addAttribute("navClients", true);

        return "addClient";
    }

    @PostMapping("/dashboard/clients/new")
    public String saveClient(Model model, @ModelAttribute Client client) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Clients");
        model.addAttribute("navClients", true);

        if (clientRepository.save(client) != null) {
            model.addAttribute("savedClient", true);
            model.addAttribute("toastMessage", "Client saved correctly!");
        }

        return "clients";
    }
}
