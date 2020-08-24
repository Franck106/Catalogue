package fr.eql.teama.catalogue.dao;

import fr.eql.teama.catalogue.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
