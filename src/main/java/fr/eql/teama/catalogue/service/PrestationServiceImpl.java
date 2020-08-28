package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.dao.PrestationRepository;
import fr.eql.teama.catalogue.dao.ProposalRepository;
import fr.eql.teama.catalogue.dao.UserRepository;
import fr.eql.teama.catalogue.dto.PrestationDto;
import fr.eql.teama.catalogue.dto.PrestationDtoToPrestation;
import fr.eql.teama.catalogue.dto.PrestationToPrestationDto;
import fr.eql.teama.catalogue.entities.Prestation;
import fr.eql.teama.catalogue.entities.Proposal;
import fr.eql.teama.catalogue.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PrestationServiceImpl implements PrestationService{

    @Autowired
    private PrestationRepository prestationRepository;

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private UserRepository userRepository;

    private final PrestationDtoToPrestation prestationDtoToPrestation;

    private final PrestationToPrestationDto prestationToPrestationDto;

    public PrestationServiceImpl(PrestationDtoToPrestation prestationDtoToPrestation, PrestationToPrestationDto prestationToPrestationDto) {
        this.prestationDtoToPrestation = prestationDtoToPrestation;
        this.prestationToPrestationDto = prestationToPrestationDto;
    }

    @Override
    public Prestation addPrestation(Prestation newPresta) {
        if (newPresta.getProposal() != null){ //aj
            Proposal getCurrentProp = proposalRepository.findById(newPresta.getProposal().getId()).get();
            getCurrentProp.getPrestations().add(newPresta);
           proposalRepository.save(getCurrentProp);
        }
        System.out.println("JE PASSE DANS SERVICE IMPL " + newPresta.getId());
        return prestationRepository.save(newPresta);
    }

    @Override
    public PrestationDto addPresta(PrestationDto prestationDto) {
        Prestation detached = prestationDtoToPrestation.convert(prestationDto);
        System.out.println( detached.getCustomer().getId() + "SERVICE OMPL");
        Prestation saved = prestationRepository.save(detached);
        return prestationToPrestationDto.convert(saved);
    }


    @Override
    public Prestation findById(Integer id) {
        return prestationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Prestation> findAllPrestationsForUser(Integer id) {
        User customer = userRepository.findById(id).get();
        return prestationRepository.findAllByCustomer(customer);
    }
}

