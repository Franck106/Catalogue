package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.dao.PrestationRepository;
import fr.eql.teama.catalogue.dao.ProposalRepository;
import fr.eql.teama.catalogue.entities.Prestation;
import fr.eql.teama.catalogue.entities.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PrestationServiceImpl implements PrestationService{

    @Autowired
    private PrestationRepository prestationRepository;

    @Autowired
    private ProposalRepository proposalRepository;

    @Override
    public Prestation addPrestation(Prestation newPresta) {
        if (newPresta.getProposal() != null){
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
}

