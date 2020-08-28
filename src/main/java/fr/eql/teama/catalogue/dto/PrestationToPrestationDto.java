package fr.eql.teama.catalogue.dto;

import fr.eql.teama.catalogue.entities.Prestation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PrestationToPrestationDto implements Converter<Prestation, PrestationDto> {

    @Override
    public PrestationDto convert(Prestation prestation) {
        final PrestationDto prestationDto = new PrestationDto();
        prestationDto.setId(prestation.getId());
        prestationDto.setDelivered(prestation.getDelivered());
        prestationDto.setCancelled(prestation.getCancelled());
        prestationDto.setValide(prestation.getValide());
  //      prestationDto.setIdProposal(prestation.getProposal().getId());
        prestationDto.setIdCustomer(prestation.getCustomer().getId());
        return prestationDto;
    }
}
