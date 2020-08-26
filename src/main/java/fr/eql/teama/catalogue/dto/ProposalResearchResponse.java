package fr.eql.teama.catalogue.dto;

import fr.eql.teama.catalogue.entities.Proposal;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ProposalResearchResponse {
    private int numResults;
    private List<Proposal> results;

    public ProposalResearchResponse(int numResults, List<Proposal> results) {
        this.numResults = numResults;
        this.results = results;
    }
}
