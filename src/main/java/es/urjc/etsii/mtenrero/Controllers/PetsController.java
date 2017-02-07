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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;


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

    @RequestMapping("/dashboard/pets")
    public String getLanding(Model model, Pageable page) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Pets");
        model.addAttribute("savedClient", false);
        model.addAttribute("navPets", true);
        model.addAttribute("pet",petRepository.findAll(page));
        return "pets";
    }

    @RequestMapping("/dashboard/pets/new")
    public String addPet(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Add new pet");

        model.addAttribute("navPets", true);

        return "addPet";
    }
}
