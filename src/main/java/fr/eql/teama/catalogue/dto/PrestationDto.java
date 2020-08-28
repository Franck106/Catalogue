package fr.eql.teama.catalogue.dto;

import fr.eql.teama.catalogue.entities.Prestation;
import fr.eql.teama.catalogue.entities.Proposal;
import fr.eql.teama.catalogue.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrestationDto {
    private Integer id;
    private Boolean delivered;
    private Boolean cancelled;
    private Boolean valide;
   // private Integer idProposal;
    private Integer idCustomer;
   private Proposal proposal;
  //  private User user;

    public static PrestationDto fromPrestation(Prestation prestation){
        PrestationDto prestationDto = new PrestationDto();
        prestationDto.setId(prestation.getId());
        prestationDto.setDelivered(prestation.getDelivered());
        prestationDto.setCancelled(prestation.getCancelled());
        prestationDto.setValide(prestation.getValide());
        System.out.println(prestationDto.cancelled + "CANCELLLLLLLLJPHIVHB");
        prestationDto.setProposal(prestation.getProposal());
    //    prestationDto.setIdCustomer(prestation.getCustomer().getId());
    //    System.out.println(prestationDto.idCustomer + "ID CUST DANS FORM PRESTRA");
      //  Proposal prop = new Proposal();
     //   prop.setId(prestation.getProposal().getId());
     //   prestationDto.setProposal(prop);
       // prestationDto.setProposal(prestation.getProposal());
      //  User user = new User();
      // user.setId(prestation.getCustomer().getId());
      //  prestationDto.setUser(user);
       // prestationDto.setIdCustomer(prestation.getCustomer().getId());
        return prestationDto;
    }

    public Prestation toPrestation(){
        Prestation prestation = new Prestation();
        prestation.setId(getId());
        prestation.setDelivered(getDelivered());
        prestation.setCancelled(getCancelled());
        prestation.setValide(getValide());
        prestation.setProposal(getProposal());
    //    prestation.setProposal(getProposal());
   //     prestation.getCustomer().setId(idCustomer);
    //    prestation.setCustomer(prestation.getCustomer());
      //  prestation.setCustomer(prestation.getCustomer());
    /*   Proposal proposal = new Proposal();
        proposal.setId(getIdProposal());
        prestation.setProposal(proposal);
        User user = new User();
        user.setId(getIdCustomer());
        prestation.setCustomer(user);*/
        return prestation;
    }



}
