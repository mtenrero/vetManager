package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mtenrero on 28/01/2017.
 */
@Controller
public class DashboardController {
    @RequestMapping("/dashboard")
    public String getLanding(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Dashboard");

        model.addAttribute("navDashboard", true);

        return "dashboard";
    }
}
