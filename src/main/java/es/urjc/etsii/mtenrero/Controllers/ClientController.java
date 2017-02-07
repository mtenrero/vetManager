package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.Entities.Client;
import es.urjc.etsii.mtenrero.Repositories.ClientRepository;
import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;


/**
 * Created by mtenrero on 28/01/2017.
 */
@Controller
public class ClientController {
    @Autowired
    private ClientRepository repository;
    @PostConstruct
    public void init() {
        repository.save(new Client(457324402, "Hola aracola","",122, "XXX"));
        repository.save(new Client(457394402, "Hola caracola","sjsj", 1212, "XXXX"));
    }
    @RequestMapping("/dashboard/clients")
    public String getLanding(Model model,Pageable page) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Clients");
        model.addAttribute("navClients", true);
        model.addAttribute("client",repository.findAll(page));
        return "clients";
    }

    @RequestMapping("/dashboard/clients/new")
    public String addClient(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Add new Client");
        model.addAttribute("navClients", true);
        return "addClient";
    }
}
