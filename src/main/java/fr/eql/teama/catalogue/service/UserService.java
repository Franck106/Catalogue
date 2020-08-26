package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.entities.User;

import javax.jws.WebService;
import java.util.List;
import java.util.Optional;

@WebService
public interface UserService {
    User addUser(User newUser);
    User updateUser(User user);
    User findUserById(Integer id);
    User findUserByLogin(String login);
    void deleteUser(Integer id);
    List<User> getAllUsers();
    List<User> findByCity(String city);
    List<User> findByPostCode(String postCode);




}
