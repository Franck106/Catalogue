package fr.eql.teama.catalogue.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface CredentialsService {
    String hash(String toHash);
}
