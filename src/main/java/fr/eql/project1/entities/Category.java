package fr.eql.project1.entities;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private Integer id;

    private String name;

    private String description;

    private List<Category> categories = new ArrayList<Category> ();

    private List<Proposal> proposals = new ArrayList<Proposal> ();

    private Category category;

}
