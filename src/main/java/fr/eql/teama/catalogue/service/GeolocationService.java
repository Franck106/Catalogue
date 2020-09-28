package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.entities.Geolocation;
import fr.eql.teama.catalogue.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface GeolocationService {
    User addGeolocationToUser(User user);
    double getDistance(Geolocation locationA, Geolocation locationB);
}
