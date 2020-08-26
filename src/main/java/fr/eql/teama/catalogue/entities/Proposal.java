package fr.eql.teama.catalogue.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String image;

    private String description;

    private Double price;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User provider;

    @OneToMany(mappedBy = "proposal")
    @JsonIgnore
    private List<Prestation> prestations;


}
