package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by marcostenrero on 14/3/17.
 */
@Controller
public class ClientDashboardController {

    @GetMapping("/clientDashboard")
    public String getLanding(Model model, Pageable page) {
        model.addAttribute("title", VetmanagerApplication.appName);
        model.addAttribute("navClients", true);

        return "publicClientView";
    }

}
