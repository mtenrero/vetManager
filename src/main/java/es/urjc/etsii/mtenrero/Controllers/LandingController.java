package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Marcos on 26/01/2017.
 */
@Controller
public class LandingController {

    @RequestMapping("/")
    public String getLanding(HttpServletRequest request,Model model) {
        model.addAttribute("title", VetmanagerApplication.appName);
        if (request.isUserInRole("MANAGER")) {
            return "redirect:/dashboard";
        }
        if (request.isUserInRole("CLIENT")) {
            return "redirect:/clientDashboard";
        }
        return "index";
    }
}

