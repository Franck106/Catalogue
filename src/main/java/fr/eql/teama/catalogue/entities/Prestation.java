package fr.eql.teama.catalogue.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Prestation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date startDate;

    private Date endDate;

    private Integer customerRating;

    private Integer providerRating;

    private Boolean delivered;

    private Boolean cancelled;

    @OneToOne
    private User customer;

    @ManyToOne
    private Proposal proposal;

}
