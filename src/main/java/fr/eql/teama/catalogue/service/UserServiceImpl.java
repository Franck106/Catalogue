package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.dao.CredentialsRepository;
import fr.eql.teama.catalogue.dao.UserRepository;
import fr.eql.teama.catalogue.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Override
    public User addUser(User newUser) {
        credentialsRepository.save(newUser.getCredentials());
        return (User) userRepository.save(newUser);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findUserByLogin(String login) {
        return userRepository.findByCredentialsLogin(login);
    }


    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public List<User> findByCity(String city) {
        return userRepository.findByCity(city);
    }

    @Override
    public List<User> findByPostCode(String postCode) {
        return userRepository.findByPostCode(postCode);
    }

}
