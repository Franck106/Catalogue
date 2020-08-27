package fr.eql.teama.catalogue.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import fr.eql.teama.catalogue.entities.User;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public double getDistance(String locationA, String locationB) {
        try {
            JacksonJsonParser parser = new JacksonJsonParser();

            Map<String, Object> locA = parser.parseMap(locationA);
            Map<String, Object> locB = parser.parseMap(locationB);

            Double latA = (Double)locA.get("lat");
            Double lngA = (Double)locA.get("lng");
            Double latB = (Double)locB.get("lat");
            Double lngB = (Double)locB.get("lng");

            double theta = lngA - lngB;
            double distance = (Math.sin(Math.toRadians(latA)) *
                    Math.sin(Math.toRadians(latB))) + (Math.cos(Math.toRadians(latA)) *
                    Math.cos(Math.toRadians(latB)) * Math.cos(Math.toRadians(theta)));

            distance = Math.acos(distance);
            distance = Math.toDegrees(distance);
            return distance * 60 * 1.1515 * 1.609344;
        } catch(Exception e) {
            return 0.0;
        }
    }
}
