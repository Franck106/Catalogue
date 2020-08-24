package fr.eql.teama.catalogue.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Proposal {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String image;

    private String description;

    private Double price;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    @OneToOne
    private Prestation prestation;


}
