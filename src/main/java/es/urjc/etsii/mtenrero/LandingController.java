package es.urjc.etsii.mtenrero;

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
        return "index";
    }
}

