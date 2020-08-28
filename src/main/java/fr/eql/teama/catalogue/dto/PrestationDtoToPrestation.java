package fr.eql.teama.catalogue.dto;

import fr.eql.teama.catalogue.entities.Prestation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PrestationDtoToPrestation implements Converter<PrestationDto, Prestation> {

    @Override
    public Prestation convert(PrestationDto source) {
        final Prestation prestation = new Prestation();
        prestation.setId(source.getId());
        prestation.setDelivered(source.getDelivered());
        prestation.setCancelled(source.getCancelled());
        prestation.setValide(source.getValide());
       // prestation.setProposal(prestation.getProposal());
        prestation.setCustomer(prestation.getCustomer());
  /*      Proposal proposal = new Proposal();
        proposal.setId(getIdProposal());
        prestation.setProposal(proposal);
        User user = new User();
        user.setId(getIdCustomer());
        prestation.setCustomer(user); */
        return prestation;
    }
}
