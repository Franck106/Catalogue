package fr.eql.teama.catalogue.dto;

import fr.eql.teama.catalogue.entities.Category;
import fr.eql.teama.catalogue.entities.Proposal;
import fr.eql.teama.catalogue.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @NoArgsConstructor
public class LogProposalDto {

    private Integer id;
    private String name;
    private String description;
    private Double price;
    private Category category;
    private ConnectedUserDto provider;
    private Double maxDistance;
    private Date date;

    private static ConnectedUserDto providerToDto(User provider) {
        ConnectedUserDto connectedUserDto = new ConnectedUserDto();
        return connectedUserDto.from(provider);
    }

    public static LogProposalDto from(Proposal proposal) {
        LogProposalDto dto = new LogProposalDto();
        dto.setId(proposal.getId());
        dto.setName(proposal.getName());
        dto.setDescription(proposal.getDescription());
        dto.setPrice(proposal.getPrice());
        dto.setCategory(proposal.getCategory());
        dto.setProvider(providerToDto(proposal.getProvider()));
        dto.setMaxDistance(proposal.getMaxDistance());
        dto.setDate(proposal.getDate());
        return dto;
    }

}
