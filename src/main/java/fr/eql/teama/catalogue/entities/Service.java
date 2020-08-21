package fr.eql.teama.catalogue.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Service {

    @Id
    @GeneratedValue
    private Integer id;

    private Date startDate;

    private Integer customerRating;

    private Integer providerRating;

    private Boolean delivered;

    private Boolean cancelled;

    private String endDate;

    @OneToOne
    private Proposal proposal;

}
