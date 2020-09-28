package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.dao.ProposalRepository;
import fr.eql.teama.catalogue.dto.ProposalResearchRequest;
import fr.eql.teama.catalogue.dto.ProposalResearchResponse;
import fr.eql.teama.catalogue.entities.Geolocation;
import fr.eql.teama.catalogue.entities.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
            if (request.getCategories() != null) {
                Expression<String> category = root.get("category").get("id");
                predicates.add(category.in(request.getCategories()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };

        List<Proposal> results = proposalRepository.findAll(specification);

        // If search location is provided, use it as a filter
        if (request.getSearchLocation() != null && !request.getSearchLocation().trim().isEmpty()) {
            results = results.stream().filter(proposal -> {
                if (proposal.getMaxDistance() == 0) {
                    return true;
                }
                JacksonJsonParser parser = new JacksonJsonParser();

                Map<String, Object> req = parser.parseMap(request.getSearchLocation());
                Geolocation geolocation = new Geolocation();
                geolocation.setLat((Double) req.get("lat"));
                geolocation.setLng((Double) req.get("lng"));
                Map<String, Object> locB = parser.parseMap(request.getSearchLocation());
                // Determine distance between search location and provider's location
                double distance = geolocationService.getDistance(
                        proposal.getProvider().getGeolocation(),
                       geolocation);

                return distance < proposal.getMaxDistance();
            }).collect(Collectors.toList());
        }

        // Sort, most recent first
        results.sort((o1, o2) -> Math.round(o2.getDate().getTime() - o1.getDate().getTime()));

        if (request.getMaxResults() != null && results.size() > request.getMaxResults()) {
            results = results.subList(0, request.getMaxResults());
        }

        return new ProposalResearchResponse(results.size(), results);
    }
}
