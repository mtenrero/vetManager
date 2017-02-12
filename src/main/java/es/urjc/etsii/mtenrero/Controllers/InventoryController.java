package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mtenrero on 28/01/2017.
 */
@Controller
public class InventoryController {
    @RequestMapping("/dashboard/inventory")
    public String getLanding(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Inventory");

        model.addAttribute("navInventory", true);

        return "inventory";
    }
    @RequestMapping("/dashboard/inventory/new")
    public String getAddItem(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Inventory: New item");

        model.addAttribute("navInventory", true);

        return "addItem";
    }
}