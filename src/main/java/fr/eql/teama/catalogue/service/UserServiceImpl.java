package fr.eql.teama.catalogue.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import fr.eql.teama.catalogue.dao.CredentialsRepository;
import fr.eql.teama.catalogue.dao.UserRepository;
import fr.eql.teama.catalogue.entities.Prestation;
import fr.eql.teama.catalogue.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Autowired
    private GeolocationService geolocationService;

    @Autowired
    private PrestationService prestationService;

    @Override
    public User addUser(User newUser) {
        geolocationService.addGeolocationToUser(newUser);
        newUser.setImage("img/default.png");
        newUser.setGlobalRating(0.0f);
        credentialsRepository.save(newUser.getCredentials());
        return (User) userRepository.save(newUser);
    }

    @Override
    public User updateUser(User user) {
        geolocationService.addGeolocationToUser(user);
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

    @Override
    public void updateRatings(User provider) {
        List<Prestation> prestations = prestationService.findAllPrestationsForProvider(provider.getId());

        if (prestations.size() == 0) {
            return;
        }

        float avg = 0;

        for (Prestation presta : prestations) {
            if (presta.getDelivered()) {
                float ratings = presta.getCustomerRating();

                avg += ratings;
            }
        }

        avg /= prestations.size();
        provider.setGlobalRating(avg);

        updateUser(provider);
    }
}
