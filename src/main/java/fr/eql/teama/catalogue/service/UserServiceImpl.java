package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.dao.UserRepository;
import fr.eql.teama.catalogue.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User newUser) {
        return (User) userRepository.save(newUser);
    }
}
