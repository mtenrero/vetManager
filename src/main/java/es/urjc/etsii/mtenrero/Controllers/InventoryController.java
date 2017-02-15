package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.Entities.Diseases;
import es.urjc.etsii.mtenrero.Entities.Item;
import es.urjc.etsii.mtenrero.Repositories.DiseasesRepository;
import es.urjc.etsii.mtenrero.Repositories.ItemRepository;
import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by mtenrero on 28/01/2017.
 */
@Controller
public class InventoryController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    DiseasesRepository diseasesRepository;


    @RequestMapping("/dashboard/inventory")
    public String getLanding(Model model, Pageable page) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Inventory");
        model.addAttribute("navInventory", true);
        model.addAttribute("Item",itemRepository.findAll());
        return "inventory";
    }
    @GetMapping("/dashboard/inventory/new")
    public String getAddItem(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Inventory: New item");
        model.addAttribute("navInventory", true);
        List<String> diseases=new ArrayList<String>();
        diseases.add("Cancer");
        diseases.add("Leishmaniosis");
        diseases.add("Candidiasis");
        model.addAttribute("diseases",diseases);
        return "addItem";
    }

    @PostMapping("/dashboard/inventory")
    public String AddItem(Model model,
                          @RequestParam String nameItem,
                          @RequestParam String factory,
                          @RequestParam (value = "vaccine",defaultValue = "off")String vaccine,
                          @RequestParam (value="diseases",defaultValue = "") String diseases,
                          @RequestParam Optional<String> caducity,
                          @RequestParam Optional<String> species,
                          @RequestParam int numberBoxes,@RequestParam int unitBoxes,@RequestParam long priceUnit,
                          @RequestParam String other_information
                          ) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Inventory: New item");
        model.addAttribute("navInventory", true);
        Item item=new Item(nameItem,factory,numberBoxes,priceUnit,other_information);
        if( !vaccine.equals("off")){
            item.setCategory("Clinic Material");
            item.setDiseases(diseases);
        }else{
            item.setCaducity(caducity.get());
            item.setSpecies(species.get());
            item.setCategory("Vaccine "+species.get());
            item.setDiseases(diseases);
        }
       if(itemRepository.save(item)!=null){
           model.addAttribute("savedClient", true);
           model.addAttribute("toastMessage", "Item saved correctly!");
       }
        model.addAttribute("Item",itemRepository.findAll());
        return "inventory";
    }

}