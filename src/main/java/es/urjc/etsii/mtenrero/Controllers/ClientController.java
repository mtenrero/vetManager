package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mtenrero on 28/01/2017.
 */
@Controller
public class ClientController {
    @RequestMapping("/dashboard/clients")
    public String getLanding(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Clients");

        model.addAttribute("navClients", true);

        return "clients";
    }

    @RequestMapping("/dashboard/clients/new")
    public String addClient(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Add new Client");

        model.addAttribute("navClients", true);

        return "addClient";
    }
}
