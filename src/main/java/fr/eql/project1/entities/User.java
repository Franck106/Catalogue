package fr.eql.project1.entities;

import java.util.ArrayList;
import java.util.List;

public class User {
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

    private Integer globalRating;

    private String image;

    private Credentials credentials;

    private List<Proposal> proposals = new ArrayList<Proposal> ();


}
