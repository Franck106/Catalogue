package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.dto.ProposalResearchRequest;
import fr.eql.teama.catalogue.entities.Proposal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProposalResearchService {
    List<Proposal> search(ProposalResearchRequest request);
}
