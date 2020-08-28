package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.dto.PrestationDto;
import fr.eql.teama.catalogue.entities.Prestation;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface PrestationService {
    Prestation addPrestation (Prestation newPresta);
    PrestationDto addPresta (PrestationDto prestationDto);
    Prestation findById (Integer id);
    List<Prestation> findAllPrestationsForUser(Integer id);
}
