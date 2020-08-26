package fr.eql.teama.catalogue.dao;

import fr.eql.teama.catalogue.entities.Credentials;
import org.springframework.data.repository.CrudRepository;

public interface CredentialsRepository extends CrudRepository<Credentials, Integer> {
}
