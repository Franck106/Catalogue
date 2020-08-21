package fr.eql.project1.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
public class Credentials {

    @Id
    @GeneratedValue
    private Integer id;
    private String login;
    private String hashedPassword;
    private User user;

}
