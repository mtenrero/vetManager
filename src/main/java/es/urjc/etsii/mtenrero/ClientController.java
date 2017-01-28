package es.urjc.etsii.mtenrero;

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
        model.addAttribute("navClients", true);

        return "clients";
    }
}
