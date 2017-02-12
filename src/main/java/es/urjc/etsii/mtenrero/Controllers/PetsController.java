package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.Entities.Client;
import es.urjc.etsii.mtenrero.Entities.Pet;
import es.urjc.etsii.mtenrero.Repositories.ClientRepository;
import es.urjc.etsii.mtenrero.Repositories.PetRepository;
import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.util.Optional;


/**
 * Created by mtenrero on 28/01/2017.
 */
@Controller
public class PetsController {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private ClientRepository clientRepository;


    @PostConstruct
    public void init() {
        Client client=new Client(02, "caracola","sjsj", 1212, "XXXX");
        clientRepository.save(client);
        Pet pet=new Pet(1, "Hola aracola", "XXX");
        pet.setClient(client);
        petRepository.save(pet);

    }

    @GetMapping("/dashboard/pets")
    public String getLanding(Model model, Pageable page) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Pets");
        model.addAttribute("savedClient", false);
        model.addAttribute("navPets", true);
        model.addAttribute("pet",petRepository.findAll(page));
        return "pets";
    }

    @GetMapping("/dashboard/pets/new")
    public String addPet(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Add new pet");
        model.addAttribute("navPets", true);
        return "addPet";
    }
    @PostMapping("/dashboard/pets/new")
    public String savePet(Model model, @RequestParam (value = "newClient",defaultValue = "off")String newClient,
                          @RequestParam(value = "nameClient",defaultValue = "off") String nameClient,
                          @RequestParam (value = "lastNameClient",defaultValue = "off")String lastNameClient,

                          @RequestParam(value = "phoneClient",defaultValue = "off") String phoneClient,
                          @RequestParam (value = "petName") String petName,
                          @RequestParam String species  ,
                          @RequestParam String  petBirthdate,
                          @RequestParam (value = "sterilized",defaultValue = "off") String sterilized
                          ){
        model.addAttribute("title", VetmanagerApplication.appName + ": Add new pet");
        model.addAttribute("navPets", true);
        //Create first pet and post we create/inser client to pet
        //Pet pet=new Pet(petId,petName,species,petBreed,petWeigth
        if(newClient=="off"){//Existing client

        }else{//New Client

        }
        model.addAttribute("pet",petRepository.findAll());
     //if( petRepository.save(pet))
        model.addAttribute("savedClient", false);
        model.addAttribute("toastMessage", "Client saved correctly!");
        return "pets";
    }
}
