package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.dao.ProposalRepository;
import fr.eql.teama.catalogue.dto.ProposalResearchRequest;
import fr.eql.teama.catalogue.dto.ProposalResearchResponse;
import fr.eql.teama.catalogue.entities.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProposalResearchServiceImpl implements ProposalResearchService {

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private GeolocationService geolocationService;

    @Autowired
    private EntityManager em;

    @Override
    public ProposalResearchResponse search(ProposalResearchRequest request) {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        Specification<Proposal> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Filter by category
            Expression<String> category = root.get("category").get("id");
            predicates.add(category.in(request.getCategories()));

            return builder.and(predicates.toArray(new Predicate[0]));
        };

        List<Proposal> results = proposalRepository.findAll(specification);

        if (request.getSearchLocation() != null && !request.getSearchLocation().trim().isEmpty()) {
            results = results.stream().filter(proposal -> {
                if (proposal.getMaxDistance() == 0) {
                    return true;
                }

                double distance = geolocationService.getDistance(
                        proposal.getProvider().getGeolocation(),
                        request.getSearchLocation());

                return distance < proposal.getMaxDistance();
            }).collect(Collectors.toList());
        }

        return new ProposalResearchResponse(results.size(), results);
    }
}
