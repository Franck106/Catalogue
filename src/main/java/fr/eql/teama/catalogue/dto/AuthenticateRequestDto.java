package fr.eql.teama.catalogue.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthenticateRequestDto {
    private String login;
    private String password;
}
