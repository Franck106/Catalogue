package fr.eql.teama.catalogue.controller;

import fr.eql.teama.catalogue.entities.Prestation;
import fr.eql.teama.catalogue.entities.Proposal;
import fr.eql.teama.catalogue.service.PrestationService;
import fr.eql.teama.catalogue.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class PrestationController {

    @Autowired
    private PrestationService prestationService;


    //ajout
    @PostMapping(value = "/prestation")
    Prestation addPrestation (@RequestBody Prestation newPresta){
        prestationService.addPrestation(newPresta);
        return newPresta;
    }

    //modif
    @PutMapping(value = "/prestation")
    Prestation modifyPrestation (@RequestBody Prestation presta) throws Exception {
        Prestation existingPresta = prestationService.findById(presta.getId());
        if (existingPresta == null){
            throw new Exception("Cette prestation n'existe pas");
        }
        Prestation updatedPrestation = prestationService.addPrestation(presta);
        return presta;
    }

}
