package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by mtenrero on 28/01/2017.
 */
@Controller
public class DashboardController {
    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("MANAGER")) {
            return "redirect:/dashboard";
        }
        return "redirect:/user/";
    }
    @RequestMapping("/dashboard")
    public String getLanding(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Dashboard");
        model.addAttribute("navDashboard", true);
        return "dashboard";
    }
    @RequestMapping("/clientdashboard")
    public String getClientDashboard(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Dashboard");
        model.addAttribute("navDashboard", true);
        return "client_dashboard";
    }
}
