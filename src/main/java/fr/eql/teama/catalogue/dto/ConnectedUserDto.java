package fr.eql.teama.catalogue.dto;

import fr.eql.teama.catalogue.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ConnectedUserDto {
    private Integer id;
    private String firstName = "";
    private String lastName = "";
    private String address = "";
    private String postCode = "";
    private String city = "";
    private String email = "";
    private Boolean premium;
    private Boolean admin;
    private String registrationNumber = "";
    private Float globalRating;
    private String geolocation = "";

    private String login = "";
    private String role = "DEFAULT";

    public static ConnectedUserDto from(User user) {
        ConnectedUserDto dto = new ConnectedUserDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setAddress(user.getAddress());
        dto.setPostCode(user.getPostCode());
        dto.setCity(user.getCity());
        dto.setEmail(user.getEmail());
        dto.setPremium(user.getPremium());
        dto.setAdmin(user.getAdmin());
        dto.setRegistrationNumber(user.getRegistrationNumber());
        dto.setGlobalRating(user.getGlobalRating());
        dto.setRole(user.getRole().toString());
        dto.setGeolocation(user.getGeolocation());

        if (user.getCredentials() != null) {
            dto.setLogin(user.getCredentials().getLogin());
        }

        return dto;
    }

}
