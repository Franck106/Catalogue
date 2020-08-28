package fr.eql.teama.catalogue.controller;

import fr.eql.teama.catalogue.entities.Prestation;
import fr.eql.teama.catalogue.entities.Proposal;
import fr.eql.teama.catalogue.entities.User;
import fr.eql.teama.catalogue.service.PrestationService;
import fr.eql.teama.catalogue.service.ProposalService;
import fr.eql.teama.catalogue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class PrestationController {

    @Autowired
    private PrestationService prestationService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProposalService proposalService;

    //ajout
    @PostMapping(value = "/prestation")
    Prestation addPrestation (@RequestBody Prestation newPresta){
        User customer = userService.findUserById(newPresta.getCustomer().getId());
        newPresta.setCustomer(customer);
        Proposal proposal = proposalService.getProposalById(newPresta.getProposal().getId());
        newPresta.setProposal(proposal);
        return prestationService.addPrestation(newPresta);
    }



    //modif
    @PutMapping(value = "/prestation")
    Prestation modifyPrestation (@RequestBody Prestation presta) throws Exception {
        Prestation existingPresta = prestationService.findById(presta.getId());
        if (existingPresta == null){
            throw new Exception("Cette prestation n'existe pas");
        }
        prestationService.addPrestation(presta);
        return presta;
    }

    //add feedback to prestation
    @PutMapping(value = "/prestation/feedback")
    public Prestation addFeedback(@RequestBody Prestation prestation) throws Exception {
        Prestation newPrestation = prestationService.findById(prestation.getId());
        if(newPrestation != null) {
            newPrestation.setCustomerRating(prestation.getCustomerRating());
            return prestationService.addPrestation(newPrestation);
        } else {
            throw new Exception("Cette prestation n'existe pas");
        }
    }

    //Get all Prestations for connected user
    @GetMapping(value = "/prestations/user/{id}")
    public List<Prestation> getPrestationsForUser(@PathVariable("id") Integer id) {
        return prestationService.findAllPrestationsForUser(id);
    }

}
