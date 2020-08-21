package fr.eql.project1.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Locale;

@Getter
@Setter
@NoArgsConstructor
public class Proposal {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String image;

    private String description;

    private Double price;

    private Category category;

    private User user;

    private Service service;


}
