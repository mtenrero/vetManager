package es.urjc.etsii.mtenrero.Controllers;

import com.mongodb.gridfs.CLI;
import es.urjc.etsii.mtenrero.BusinessLogic.Helpers.ListSorter;
import es.urjc.etsii.mtenrero.BusinessLogic.Helpers.ParseHelper;
import es.urjc.etsii.mtenrero.Comunication;
import es.urjc.etsii.mtenrero.Entities.Client;
import es.urjc.etsii.mtenrero.Entities.Pet;
import es.urjc.etsii.mtenrero.Repositories.ClientRepository;
import es.urjc.etsii.mtenrero.VetmanagerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/dashboard/clients")
    public String getLanding(Model model,Pageable page) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Clients");
        model.addAttribute("navClients", true);
        model.addAttribute("client",clientRepository.findAll(page));

        return "clients";
    }

    @GetMapping("/dashboard/clients/new")
    public String addClient(Model model) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Add new Client");
        model.addAttribute("navClients", true);
        return "addClient";
    }

    @PostMapping("/dashboard/clients/new")
    public String saveClient(Model model,
                             @RequestParam int legalID,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam int phone1,
                             @RequestParam Optional<Integer> phone2,
                             @RequestParam String addressStreet,
                             @RequestParam String addressCity,
                             @RequestParam int addressZIP,
                             @RequestParam String email) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Clients");
        model.addAttribute("navClients", true);
        Client client=new Client(legalID,firstName,lastName,phone1,addressStreet,addressCity,addressZIP,email);
        if(phone2.isPresent()){
            client.setPhone2(phone2.get());
        }
        if (clientRepository.save(client) != null) {
            model.addAttribute("savedClient", true);
            model.addAttribute("toastMessage", "Client saved correctly!");
            try {
                new Comunication().main(email,"Bienvenido a vetmanager","estas dentro");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("client",clientRepository.findAll());
        return "clients";
    }

    @GetMapping("/dashboard/clients/{id}")
    public String getinfo(Model model,@PathVariable long id) {
        model.addAttribute("title", VetmanagerApplication.appName + ": Clients");
        model.addAttribute("navClients", true);
        model.addAttribute("clients",clientRepository.findOne(id));
        return "client_view";
    }

    @GetMapping("/dashboard/clients/filter")
    public ResponseEntity<List<Client>> getFilteredClients(@RequestParam(value = "content", required = true) String content) {
        List<Client> resultSet = new ArrayList<>();

        // Execute the query in all columns per word
        for (String word : ParseHelper.stringSplitter(content)) {
            resultSet.addAll(clientRepository.findFirst10ByLastNameContainingIgnoreCase(word)); // Last Name
            if (ParseHelper.isInteger(word)) {
                resultSet.addAll(clientRepository.findFirst10ByLegalID(Integer.parseInt(word))); // ID
            }
            resultSet.addAll(clientRepository.findFirst10ByFirstNameContainingIgnoreCase(word)); // First Name
            if (ParseHelper.isInteger(word)) {
                resultSet.addAll(clientRepository.findFirst10ByPhone1(Integer.parseInt(word))); // Phone1
            }
        }

        // Sort Results
        ListSorter<Client> listSorter = new ListSorter<>(resultSet,ParseHelper.stringSplitter(content).size());

        return new ResponseEntity<> (listSorter.sortByOccurrences(), HttpStatus.OK);
    }
}
