package fr.eql.teama.catalogue.dao;

import fr.eql.teama.catalogue.entities.Prestation;
import org.springframework.data.repository.CrudRepository;

public interface PrestationRepository extends CrudRepository<Prestation, Integer> {
}
