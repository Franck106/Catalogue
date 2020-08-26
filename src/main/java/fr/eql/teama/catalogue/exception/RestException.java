package fr.eql.teama.catalogue.exception;

public class RestException extends RuntimeException {
    public RestException() {}
    public RestException(String message){
        super(message);
    }
    public RestException(Throwable cause) {
        super(cause);
    }
    public RestException(String message, Throwable cause) {
        super(message, cause);
    }
}
