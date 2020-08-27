package fr.eql.teama.catalogue.dto;

import fr.eql.teama.catalogue.entities.Credentials;
import fr.eql.teama.catalogue.entities.User;
import fr.eql.teama.catalogue.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullUserDto {
    private Integer id;
    private String firstName = "";
    private String lastName = "";
    private String address = "";
    private String postCode = "";
    private String city = "";
    private String phoneNumber = "";
    private String email = "";
    private Boolean premium;
    private Boolean admin;
    private String registrationNumber = "";
    private Integer globalRating;
    private String image = "";
    private String geolocation = "";

    private String login = "";
    private String password = "";
    private String role = "DEFAULT";

    public static FullUserDto from(User user) {
        FullUserDto dto = new FullUserDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setAddress(user.getAddress());
        dto.setPostCode(user.getPostCode());
        dto.setCity(user.getCity());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setEmail(user.getEmail());
        dto.setPremium(user.getPremium());
        dto.setAdmin(user.getAdmin());
        dto.setRegistrationNumber(user.getRegistrationNumber());
        dto.setGlobalRating(user.getGlobalRating());
        dto.setImage(user.getImage());
        dto.setLogin(user.getCredentials().getLogin());
        dto.setPassword(user.getCredentials().getHashedPassword());
        dto.setRole(user.getRole().toString());
        dto.setGeolocation(user.getGeolocation());

        return dto;
    }

    public User toUser() {
        User user = new User();
        user.setId(getId());
        user.setFirstName(getFirstName());
        user.setLastName(getLastName());
        user.setAddress(getAddress());
        user.setPostCode(getPostCode());
        user.setCity(getCity());
        user.setPhoneNumber(getPhoneNumber());
        user.setEmail(getEmail());
        user.setRole(UserRole.valueOf(getRole()));
        user.setImage(getImage());
        user.setGeolocation(getGeolocation());

        Credentials credentials = new Credentials();
        credentials.setLogin(getLogin());
        credentials.setHashedPassword(getPassword());
        user.setCredentials(credentials);

        return user;
    }
}
