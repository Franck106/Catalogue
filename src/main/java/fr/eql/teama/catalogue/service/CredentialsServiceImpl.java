package fr.eql.teama.catalogue.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CredentialsServiceImpl implements CredentialsService {

    public String hash(String toHash) {
        return toHash;
    }
}
