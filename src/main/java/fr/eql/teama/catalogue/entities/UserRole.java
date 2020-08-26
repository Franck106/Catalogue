package fr.eql.teama.catalogue.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public enum UserRole {
    DEFAULT,
    PREMIUM,
    ADMIN,
    ;

    @Id
    private String id;
}
