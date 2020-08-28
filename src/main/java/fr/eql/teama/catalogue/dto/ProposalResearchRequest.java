package fr.eql.teama.catalogue.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ProposalResearchRequest {
    List<Integer> categories;
    String searchLocation;
    Integer maxResults;
}
