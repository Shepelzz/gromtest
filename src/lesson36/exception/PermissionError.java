package lesson36.exception;

public class PermissionError extends RuntimeException {
    public PermissionError(String method, String place, String message) {
        super(method+". "+place+" error: "+message);
    }
}
