package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.dto.LogProposalDto;
import fr.eql.teama.catalogue.entities.Proposal;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class LogstashService {

    LogProposalDto logProposalDto = new LogProposalDto();

    //To log the addition of a new proposal by a connected user
    public void postProposal(Proposal proposal) {
        LogProposalDto proposalDto = logProposalDto.from(proposal);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:9090";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<LogProposalDto> request = new HttpEntity<>(proposalDto, headers);
        String response = restTemplate.postForObject(url, request, String.class);
        //System.out.println("========== logstach response ================ "+response);
    }
}
