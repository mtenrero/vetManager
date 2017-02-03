package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mtenrero on 28/01/2017.
 */
@Controller
public class PetsController {
    @RequestMapping("/dashboard/pets")
    public String getLanding(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Pets");

        model.addAttribute("navPets", true);

        return "pets";
    }

    @RequestMapping("/dashboard/pets/new")
    public String addPet(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Add new pet");

        model.addAttribute("navPets", true);

        return "addPet";
    }
}
