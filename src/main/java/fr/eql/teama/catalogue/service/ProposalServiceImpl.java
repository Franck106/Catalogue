package fr.eql.teama.catalogue.service;


import fr.eql.teama.catalogue.dao.CategoryRepository;
import fr.eql.teama.catalogue.dao.ProposalRepository;
import fr.eql.teama.catalogue.dao.UserRepository;
import fr.eql.teama.catalogue.entities.Category;
import fr.eql.teama.catalogue.entities.Proposal;
import fr.eql.teama.catalogue.entities.User;
import fr.eql.teama.catalogue.exception.RestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProposalServiceImpl implements ProposalService{

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Proposal> getProposalList() {
        return (List<Proposal>) proposalRepository.findAll();
    }

    @Override
    public Proposal getProposalById(Integer id) {
        return proposalRepository.findById(id).orElse(null);
    }

    @Override
    public List<Proposal> getProposalsByName(String name) {
        return proposalRepository.findAllByName(name);
    }

    @Override
    public Proposal addProposal(Proposal proposal) {
        if(proposal.getCategory() != null) {
            Category category = categoryRepository.findById(proposal.getCategory().getId()).get();
            category.getProposals().add(proposal);
            categoryRepository.save(category);
        }

        // Set proposal's date as now
        proposal.setDate(new Date());

        return proposalRepository.save(proposal);
    }

    @Override
    public Proposal modifyProposal(Proposal proposal) {
        return proposalRepository.save(proposal);
    }

    @Override
    public void removeProposal(Integer id) throws RuntimeException{
        try {
            proposalRepository.deleteById(id);
        } catch (Exception e) {
            throw new RestException();
        }
    }

    @Override
    public boolean checkProposalExistForUser(Proposal proposal) {
        User user = proposal.getProvider();
        List<Proposal> userProposals = proposalRepository.findAllByProvider(user);
        for (Proposal p : userProposals) {
            if (p.getName().equalsIgnoreCase(proposal.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Proposal> getProposalsByUser(Integer id) {
        User user = userRepository.findById(id).get();
        return proposalRepository.findAllByProvider(user);
    }


}
