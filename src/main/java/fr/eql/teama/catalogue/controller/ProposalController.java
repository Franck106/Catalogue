package fr.eql.teama.catalogue.controller;

import fr.eql.teama.catalogue.dto.DeleteResponse;
import fr.eql.teama.catalogue.dto.ProposalResearchRequest;
import fr.eql.teama.catalogue.dto.ProposalResearchResponse;
import fr.eql.teama.catalogue.entities.User;
import fr.eql.teama.catalogue.exception.AlreadyExistException;
import fr.eql.teama.catalogue.entities.Proposal;
import fr.eql.teama.catalogue.exception.ProposalException;
import fr.eql.teama.catalogue.exception.UpdateException;
import fr.eql.teama.catalogue.service.ProposalResearchService;
import fr.eql.teama.catalogue.service.ProposalService;
import fr.eql.teama.catalogue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class ProposalController {

    @Autowired
    ProposalService proposalService;

    @Autowired
    UserService userService;

    @Autowired
    ProposalResearchService proposalResearchService;

    LogstashController logstashController = new LogstashController();

    @GetMapping(value = "/proposals")
    public List<Proposal> getProposals(@RequestParam(value = "name", required = false) String name)
            throws ProposalException {
        if (name == null) {
            List<Proposal> result = proposalService.getProposalList();
            if (result != null) {
                return result;
            } else {
                throw new ProposalException("Aucune donnée trouvée.");
            }
        } else {
            List<Proposal> result = (List<Proposal>) proposalService.getProposalsByName(name);
            if (result != null && result.size() > 0) {
                return result;
            } else {
                throw new ProposalException("Aucune donnée trouvée.");
            }
        }
    }

    @GetMapping(value = "/proposals/{id}")
    public ResponseEntity<Proposal> getProposalsByName(@PathVariable("id") Integer id) {
        Proposal proposal = proposalService.getProposalById(id);
        if (proposal != null) {
            return new ResponseEntity<Proposal>(proposal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/proposals")
    public Proposal addProposal(@RequestBody Proposal proposal) throws AlreadyExistException {
        if (proposalService.checkProposalExistForUser(proposal)) {
            throw new AlreadyExistException("Ce service est déjà proposé par l'utilisateur #" + proposal.getProvider().getId());
        } else {
            User provider = userService.findUserById(proposal.getProvider().getId());
            proposal.setProvider(provider);
            Proposal newProposal = proposalService.addProposal(proposal);
            logstashController.postProposal(newProposal);
            return newProposal;
        }
    }

    @PutMapping(value = "/proposals")
    public Proposal modifyProposal(@RequestBody Proposal proposal) throws UpdateException {
        if (proposal.getId() == null) {
            throw new UpdateException("Le service à modifier est introuvable.");
        }
        Proposal proposal1 = proposalService.getProposalById(proposal.getId());
        if (proposal1 != null) {
            return proposalService.modifyProposal(proposal);
        } else {
            throw new UpdateException("Le service à modifier est introuvable.");
        }

    }

    @DeleteMapping(value = "proposals/{id}")
    public ResponseEntity<DeleteResponse> removeProposal(@PathVariable("id") Integer id) throws RuntimeException {
        try {
            proposalService.removeProposal(id);
            return new ResponseEntity<DeleteResponse>(
                    DeleteResponse.withSuccess("Le service a bien été supprimé."),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<DeleteResponse>(
                    DeleteResponse.withError("Service introuvable."),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/proposals/search")
    public ProposalResearchResponse searchProposal(@RequestBody ProposalResearchRequest request) throws AlreadyExistException {
        return proposalResearchService.search(request);
    }

    @GetMapping(value = "/proposals/user/{id}")
    public List<Proposal> getProposalsForUser (@PathVariable("id") Integer id) {
        return proposalService.getProposalsByUser(id);
    }
}
