package fr.eql.teama.catalogue.dto;

import fr.eql.teama.catalogue.entities.Prestation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrestationDto {
    private Integer id;
    private Boolean delivered;
    private Boolean cancelled;
    private Boolean valide;
    private Integer idProposal;
    private Integer idCustomer;

    public static PrestationDto fromPrestation(Prestation prestation){
        PrestationDto prestationDto = new PrestationDto();
        prestationDto.setId(prestation.getId());
        prestationDto.setDelivered(prestation.getDelivered());
        prestationDto.setCancelled(prestation.getCancelled());
        prestationDto.setValide(prestation.getValide());
        prestationDto.setIdProposal(prestation.getProposal().getId());
        prestationDto.setIdCustomer(prestation.getCustomer().getId());
        return prestationDto;
    }

    public Prestation toPrestation(){
        Prestation prestation = new Prestation();
        prestation.setId(prestation.getId());
        prestation.setDelivered(prestation.getDelivered());
        prestation.setCancelled(prestation.getCancelled());
        prestation.setValide(prestation.getValide());
        prestation.setProposal(prestation.getProposal());
        prestation.setCustomer(prestation.getCustomer());
        return prestation;
    }



}
