package fr.eql.teama.catalogue.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity
public class Category {

    @Id
    private Integer id;

    private String name;

    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    @JsonIgnore
    private List<Category> categories = new ArrayList<> ();

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Proposal> proposals = new ArrayList<> ();

    @ManyToOne
    private Category category;

    private String image;

}
