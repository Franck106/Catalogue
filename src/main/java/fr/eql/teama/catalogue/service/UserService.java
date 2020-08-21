package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.entities.User;

import javax.jws.WebService;

@WebService
public interface UserService {
    User addUser(User newUser);
}
