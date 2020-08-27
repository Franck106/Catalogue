package fr.eql.teama.catalogue.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import fr.eql.teama.catalogue.entities.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Setter @Getter
public class GeolocationServiceImpl implements GeolocationService, InitializingBean {

    @Value("${keys.gmaps}")
    private String apiKey;

    private GeoApiContext context;

    @Override
    public User addGeolocationToUser(User user) {
        user.setGeolocation("");

        System.out.println("Using Google Maps API key : " + System.getenv("GMAPS_API_KEY"));

        try {
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

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Using Google Maps API key : " + apiKey);

        context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
    }
}
