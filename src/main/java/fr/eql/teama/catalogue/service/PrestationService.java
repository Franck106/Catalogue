package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.entities.Prestation;

import javax.jws.WebService;

@WebService
public interface PrestationService {
    Prestation addPrestation (Prestation newPresta);
    Prestation findById (Integer id);
}
