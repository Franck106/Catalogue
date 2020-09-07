package fr.eql.teama.catalogue.controller;

import fr.eql.teama.catalogue.entities.Proposal;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class LogstashController {

    public void postProposal(Proposal proposal) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:9090";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Proposal> request = new HttpEntity<>(proposal, headers);
        String response = restTemplate.postForObject(url, request, String.class);
        //System.out.println("========== logstach response ================ "+response);
    }
}
