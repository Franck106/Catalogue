package fr.eql.teama.catalogue.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String address;

    private String postCode;

    private String city;

    private String phoneNumber;

    private String email;

    private Boolean premium;

    private Boolean admin;

    private String registrationNumber;

    private Float globalRating;

    private String image;

    @OneToOne
    private Credentials credentials;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "provider")
    @JsonIgnore
    private List<Proposal> proposals = new ArrayList<> ();

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String geolocation;

    public User (String firstName) {
        this.firstName = firstName;
    }


}
