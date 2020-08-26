package fr.eql.teama.catalogue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UpdateException extends RuntimeException {
    public UpdateException() {}
    public UpdateException(String message){
        super(message);
    }
    public UpdateException(Throwable cause) {
        super(cause);
    }
    public UpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
