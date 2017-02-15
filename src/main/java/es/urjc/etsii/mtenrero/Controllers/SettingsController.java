package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mtenrero on 28/01/2017.
 */
@Controller
public class SettingsController {
    @GetMapping("/dashboard/settings")
    public String getLanding(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Settings");
        model.addAttribute("navSettings", true);
        return "Settings";
    }
    @PostMapping("/dashboard/settings")
    public String updateSettings(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Settings");
        model.addAttribute("navSettings", true);

        return "Settings";
    }
}
