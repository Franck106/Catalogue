package fr.eql.teama.catalogue.dao;

import fr.eql.teama.catalogue.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByCity(String city);
    List<User> findByPostCode(String postCode);
    User findByCredentialsLogin(String login);
}
