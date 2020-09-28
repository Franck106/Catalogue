package fr.eql.teama.catalogue.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
@AllArgsConstructor
public class Geolocation {
    private Double lat;
    private Double lng;
}
