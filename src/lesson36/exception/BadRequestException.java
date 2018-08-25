package lesson36.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String method, String place, String message) {
        super(method+". "+place+" error: "+message);
    }
}
