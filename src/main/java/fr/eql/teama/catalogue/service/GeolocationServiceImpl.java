package fr.eql.teama.catalogue.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import fr.eql.teama.catalogue.entities.User;
import org.springframework.stereotype.Service;

@Service
public class GeolocationServiceImpl implements GeolocationService {
    @Override
    public User addGeolocationToUser(User user) {
        user.setGeolocation("");

        try {
            GeoApiContext context = new GeoApiContext.Builder()
                    .apiKey("AIzaSyCOw0SJtnQymqVzVFfvxDFzrKtzAeHCLHI")
                    .build();

            String fullAddress = user.getAddress() + " " + user.getPostCode() + " " + user.getCity();

            GeocodingResult[] results =  GeocodingApi.geocode(context, fullAddress).await();

            if (results.length > 0) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                user.setGeolocation(gson.toJson(results[0].geometry.location));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
