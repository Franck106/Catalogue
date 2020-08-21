package fr.eql.project1.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Credentials {
    private Integer id;
    private String login;
    private String hashedPassword;
    private User user;

}
