package fr.eql.teama.catalogue.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;

@Service
@Transactional
public interface CredentialsService {
    String trueHash(String toHash) throws NoSuchAlgorithmException;
    String hash(String toHash);
}
