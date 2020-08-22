package fr.eql.project1.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
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

    private Proposal proposal;

}
