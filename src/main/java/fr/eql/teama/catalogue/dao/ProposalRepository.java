package fr.eql.teama.catalogue.dao;

import fr.eql.teama.catalogue.entities.Proposal;
import fr.eql.teama.catalogue.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProposalRepository extends CrudRepository<Proposal, Integer> {
    List<Proposal> findAllByName(String name);
    List<Proposal> findAllByUser(User user);
}
