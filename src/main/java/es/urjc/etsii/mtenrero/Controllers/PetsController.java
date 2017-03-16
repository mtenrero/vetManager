package es.urjc.etsii.mtenrero.Controllers;

import es.urjc.etsii.mtenrero.Entities.*;
import es.urjc.etsii.mtenrero.Repositories.ClientRepository;
import es.urjc.etsii.mtenrero.Repositories.PetRepository;
import es.urjc.etsii.mtenrero.Repositories.Pet_BreedRepository;
import es.urjc.etsii.mtenrero.Repositories.Pet_WeightHistoryRepository;
import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.util.List;
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
    @Autowired
    private Pet_WeightHistoryRepository petWeightHistoryRepository;
    @Autowired
    private Pet_BreedRepository pet_breedRepository;


    @PostConstruct
    public void init() {
        /**
        Client client=new Client(02, "caracola","sjsj", 1212, "XXXX");
        clientRepository.save(client);
        Pet pet=new Pet(1, "Hola aracola", "XXX");
        pet.setClient(client);
        petRepository.save(pet);**/

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
    public String savePet(Model model,
                          @RequestParam (value = "newClient",defaultValue = "off")String newClient,
                          //FIND CLIENT
                          @RequestParam Optional<Integer> dni,
                          //NEW CLIENT
                          @RequestParam String firstName,
                          @RequestParam(value = "clientIdInput") int clientId,
                          @RequestParam String lastName,
                          @RequestParam Optional<Integer> legalID,
                          @RequestParam Optional<Integer> phone1,
                          @RequestParam Optional<Integer> phone2,
                          @RequestParam String addressStreet,
                          @RequestParam String addressCity,
                          @RequestParam Optional<Integer> addressZIP,
                          @RequestParam String email,
                          //NEW PET
                          @RequestParam String petName,
                          @RequestParam String species  ,
                          @RequestParam String pet_breed,
                          @RequestParam(value = "petWeight") Optional<Float> pet_weigth,
                          @RequestParam long petId,
                          @RequestParam String  petBirthdate,
                          @RequestParam String  petLayerColour,
                          @RequestParam String  petHairType,
                          @RequestParam (value = "sterilized",defaultValue = "false") boolean sterilized,
                          @RequestParam (value = "agressive",defaultValue = "false") boolean agressive,
                          @RequestParam String pet_prevpathologies
                          ){
        model.addAttribute("title", VetmanagerApplication.appName + ": Add new pet");
        model.addAttribute("navPets", true);

        List<Pet_Breed> breed = pet_breedRepository.findByBreed(pet_breed);

        Pet pet = new Pet(petName,species,petBirthdate,petLayerColour,petHairType,true,false,pet_prevpathologies);
        Pet_WeightHistory history = new Pet_WeightHistory();
        if (pet_weigth.isPresent()) {
            history.setWeight(pet_weigth.get());
        }
        petWeightHistoryRepository.save(history);
        pet.getWeightHistoryID().add(history);

        Client client;

        if (!newClient.equals("off")) {
            client = new Client(legalID.get(),firstName,lastName,phone1.get(),addressStreet,addressCity,addressZIP.get(),email);
            if(phone2.isPresent()){
                client.setPhone2(phone2.get());
            }
            clientRepository.save(client);
        } else {
            client = clientRepository.findById((long) clientId);
        }

        if(!breed.isEmpty()){
            pet.setBreed(breed.get(0));
        }else{
            Pet_Breed newBreed=new Pet_Breed(pet_breed);
            pet_breedRepository.save(newBreed);
            pet.setBreed(newBreed);
        }

        List<Pet> pets= client.getPets();
        pets.add(pet);
        client.setPets(pets);
//        clientRepository.save(client);
        pet.setClient(client);
        if( clientRepository.save(client)!=null){
            model.addAttribute("savedClient", false);
            model.addAttribute("toastMessage", "Pet saved correctly!");
        }
        model.addAttribute("pet",petRepository.findAll());
        return "pets";
    }

    @GetMapping("/dashboard/pet/{id}")
    public String getinfo(Model model,@PathVariable long id) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Clients");
        model.addAttribute("navClients", true);
        model.addAttribute("pets",petRepository.findOne(id));
        return "pet_view";
    }
}
