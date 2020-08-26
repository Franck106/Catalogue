package fr.eql.teama.catalogue.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
@Transactional
public class CredentialsServiceImpl implements CredentialsService {

    //the algorithm is not working yet
    public String trueHash(String toHash) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA256");
        byte[] hash = digest.digest(toHash.getBytes(StandardCharsets.UTF_8));
        String encoded = Base64.getEncoder().encodeToString(hash);
        System.out.println("=======================" + encoded);
        return encoded;
    }

    @Override
    public String hash(String toHash) {
        return toHash;
    }

}
