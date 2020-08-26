package fr.eql.teama.catalogue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProposalException extends RestException {

    public ProposalException() {
    }
    public ProposalException(String message){
        super(message);
    }
    public ProposalException(Throwable cause) {
        super(cause);
    }

    public ProposalException(String message, Throwable cause) {
        super(message, cause);
    }
}
