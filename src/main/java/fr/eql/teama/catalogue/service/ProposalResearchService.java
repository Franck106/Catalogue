package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.dto.ProposalResearchRequest;
import fr.eql.teama.catalogue.dto.ProposalResearchResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProposalResearchService {
    ProposalResearchResponse search(ProposalResearchRequest request);
}
