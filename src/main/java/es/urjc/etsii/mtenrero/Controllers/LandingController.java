package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Marcos on 26/01/2017.
 */
@Controller
public class LandingController {

    @RequestMapping("/")
    public String getLanding(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName);
        return "index";
    }
}

