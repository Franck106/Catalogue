package fr.eql.teama.catalogue.controller;

import fr.eql.teama.catalogue.entities.Proposal;
import fr.eql.teama.catalogue.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class ProposalController {

    @Autowired
    ProposalService proposalService;

    @GetMapping(value = "/proposals")
    public List<Proposal> getProposals(@RequestParam(value = "name", required = false) String name) {
        if(name==null) {
            return proposalService.getProposalList();
        } else {
            return (List<Proposal>) proposalService.getProposalsByName(name);
        }

    }

    @GetMapping(value = "/proposals/{id}")
    public Optional<Proposal> getProposalsByName(@PathVariable("id") Integer id) {
        return proposalService.getProposalById(id);
    }

    @PostMapping(value = "/proposals")
    public Proposal addProposal(@RequestBody Proposal proposal) {
        return proposalService.addProposal(proposal);
    }

    @PutMapping(value = "/proposals")
    public Proposal modifyProposal(@RequestBody Proposal proposal) {
        return proposalService.modifyProposal(proposal);
    }

    @DeleteMapping(value = "proposals/{id}")
    public void removeProposal(@PathVariable("id") Integer id) throws RuntimeException{
        try {
            proposalService.removeProposal(id);
        } catch (Exception e) {
        }

}

}
