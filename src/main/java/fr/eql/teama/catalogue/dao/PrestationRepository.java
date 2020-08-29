package fr.eql.teama.catalogue.dao;

import fr.eql.teama.catalogue.entities.Prestation;
import fr.eql.teama.catalogue.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrestationRepository extends CrudRepository<Prestation, Integer> {
    List<Prestation> findAllByCustomer(User customer);
    List<Prestation> findAllByProposalProviderId(Integer id);
}
