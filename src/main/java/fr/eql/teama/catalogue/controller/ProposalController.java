package fr.eql.teama.catalogue.controller;

import fr.eql.teama.catalogue.dto.DeleteResponse;
import fr.eql.teama.catalogue.exception.AlreadyExistException;
import fr.eql.teama.catalogue.entities.Proposal;
import fr.eql.teama.catalogue.exception.ProposalException;
import fr.eql.teama.catalogue.exception.UpdateException;
import fr.eql.teama.catalogue.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class ProposalController {

    @Autowired
    ProposalService proposalService;

    @GetMapping(value = "/proposals")
    public List<Proposal> getProposals(@RequestParam(value = "name", required = false) String name)
        throws ProposalException {
            if(name==null) {
                List<Proposal> result = proposalService.getProposalList();
                if(result != null) {
                    return result;
                } else {
                    throw new ProposalException("AUCUNE DONNÉE TROUVÉE");
                }
            } else {
                List<Proposal> result = (List<Proposal>) proposalService.getProposalsByName(name);
                if(result != null && result.size() > 0) {
                    return result;
                } else {
                    throw new ProposalException("AUCUNE DONNÉE TROUVÉE");
                }
            }
    }

    @GetMapping(value = "/proposals/{id}")
    public ResponseEntity<Proposal> getProposalsByName(@PathVariable("id") Integer id) {
        Proposal proposal = proposalService.getProposalById(id);
        if (proposal != null) {
            return new ResponseEntity<Proposal>(proposal,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/proposals")
    public Proposal addProposal(@RequestBody Proposal proposal) throws AlreadyExistException {
        if (proposalService.checkProposalExistForUser(proposal)) {
            throw new AlreadyExistException("CE SERVICE EST DÉJA PROPOSÉ PAR L'UTILISATEUR : " + proposal.getUser().getFirstName());
        } else {
            return proposalService.addProposal(proposal);
        }
    }

    @PutMapping(value = "/proposals")
    public Proposal modifyProposal(@RequestBody Proposal proposal) throws UpdateException {
        if(proposal.getId() == null) {
            throw new UpdateException("LE SERVICE À MODIFIER EST INTROUVABLE.");
        }
        Proposal proposal1 = proposalService.getProposalById(proposal.getId());
        if (proposal1 != null) {
            return proposalService.modifyProposal(proposal);
        } else {
            throw new UpdateException("LLE SERVICE À MODIFIER EST INTROUVABLE.");
        }

    }

    @DeleteMapping(value = "proposals/{id}")
    public ResponseEntity<DeleteResponse> removeProposal(@PathVariable("id") Integer id) throws RuntimeException{
        try {
            proposalService.removeProposal(id);
            return new ResponseEntity<DeleteResponse>(
                    DeleteResponse.withSuccess("Le service a bien été supprimé."),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<DeleteResponse>(
                    DeleteResponse.withError("SERVICE INTROUVABLE"),
                    HttpStatus.NOT_FOUND);
        }

}

}
