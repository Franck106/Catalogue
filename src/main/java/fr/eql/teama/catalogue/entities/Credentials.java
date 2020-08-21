package fr.eql.teama.catalogue.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Credentials {

    @Id
    @GeneratedValue
    private Integer id;
    private String login;
    private String hashedPassword;

    @OneToOne
    private User user;

}
