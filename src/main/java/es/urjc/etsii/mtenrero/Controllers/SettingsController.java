package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.Entities.Client;
import es.urjc.etsii.mtenrero.Entities.Preference;
import es.urjc.etsii.mtenrero.Repositories.PreferenceRepository;
import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.sql.Time;

/**
 * Created by mtenrero on 28/01/2017.
 */
@Controller
public class SettingsController {

    @Autowired
    private PreferenceRepository preferenceRepository;

    @PostConstruct
    public void init() {
       if (preferenceRepository.findAll().isEmpty()) {
           // Default preferences
           preferenceRepository.save(new Preference(20,20,20,45,30,10,20,10,18,true,true,true,true,true,true,true));
       }
    }

    @RequestMapping("/dashboard/settings")
    public String getLanding(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Settings");
        model.addAttribute("navSettings", true);

        model.addAttribute("preferences",preferenceRepository.findAll().get(0));
        return "Settings";
    }

    @RequestMapping(value = "/dashboard/settings/update", method = RequestMethod.POST)
    public String setSettings(ModelMap model, RedirectAttributes rm,
                              @RequestParam int maxClientsPerPage,
                              @RequestParam int maxPetsPerPage,
                              @RequestParam int maxItemsPerPage,
                              @RequestParam int minutesPerNormalApointment,
                              @RequestParam int minutesPerVaccineApointment,
                              @RequestParam int openingWeekdayTime,
                              @RequestParam int closingWeekdayTime,
                              @RequestParam int openingWeekendTime,
                              @RequestParam int closingWeekendTime,
                              @RequestParam(defaultValue = "false", required = false) boolean mon,
                              @RequestParam(defaultValue = "false", required = false) boolean tue,
                              @RequestParam(defaultValue = "false", required = false) boolean wed,
                              @RequestParam(defaultValue = "false", required = false) boolean thu,
                              @RequestParam(defaultValue = "false", required = false) boolean fri,
                              @RequestParam(defaultValue = "false", required = false) boolean sat,
                              @RequestParam(defaultValue = "false", required = false) boolean sun
    ) {
        Preference pref = new Preference( maxClientsPerPage, maxPetsPerPage, maxItemsPerPage, minutesPerNormalApointment,  minutesPerVaccineApointment,  openingWeekdayTime,  closingWeekdayTime,  openingWeekendTime,  closingWeekendTime,  mon,  tue,  wed,  thu,  fri, sat,  sun);
        preferenceRepository.deleteAll();
        if (preferenceRepository.save(pref) != null) {
            rm.addFlashAttribute("toastMessage", "Preferences saved correctly!");
        }
        return "redirect:" + "/dashboard/settings";
    }
}
