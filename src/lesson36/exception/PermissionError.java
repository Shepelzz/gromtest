package lesson36.exception;

public class PermissionError extends RuntimeException {
    private String action;

    public PermissionError(String action, String reason) {
        super(reason);
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
