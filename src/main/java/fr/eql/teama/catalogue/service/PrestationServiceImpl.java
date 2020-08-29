package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.dao.PrestationRepository;
import fr.eql.teama.catalogue.dao.ProposalRepository;
import fr.eql.teama.catalogue.dao.UserRepository;
import fr.eql.teama.catalogue.entities.Prestation;
import fr.eql.teama.catalogue.entities.Proposal;
import fr.eql.teama.catalogue.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PrestationServiceImpl implements PrestationService {

    @Autowired
    private PrestationRepository prestationRepository;

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Prestation addPrestation(Prestation newPresta) {
        if (newPresta.getProposal() != null) {
            Proposal getCurrentProp = proposalRepository.findById(newPresta.getProposal().getId()).get();
            getCurrentProp.getPrestations().add(newPresta);
            proposalRepository.save(getCurrentProp);
        }

        return prestationRepository.save(newPresta);
    }


    @Override
    public Prestation findById(Integer id) {
        return prestationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Prestation> findAllPrestationsForUser(Integer id) {
        User customer = userRepository.findById(id).get();
        List<Prestation> result = prestationRepository.findAllByCustomer(customer);
        result.sort((a, b) -> b.getStartDate().compareTo(a.getStartDate()));
        return result;
    }

    @Override
    public List<Prestation> findAllPrestationsForProvider(Integer id) {
        List<Prestation> result = prestationRepository.findAllByProposalProviderId(id);
        result.sort((a, b) -> b.getStartDate().compareTo(a.getStartDate()));

        return result;
    }
}

