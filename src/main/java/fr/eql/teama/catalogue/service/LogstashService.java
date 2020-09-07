package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.dto.LogProposalDto;
import fr.eql.teama.catalogue.entities.Proposal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LogstashService {

    @Value("${logstash.url:http://localhost:9090}")
    String logstashUrl;

    //To log the addition of a new proposal by a connected user
    public void postProposal(Proposal proposal) {
        LogProposalDto proposalDto = LogProposalDto.from(proposal);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<LogProposalDto> request = new HttpEntity<>(proposalDto, headers);
        String response = restTemplate.postForObject(logstashUrl, request, String.class);
        //System.out.println("========== logstach response ================ "+response);
    }
}
