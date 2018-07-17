package lesson22.homework22_1.exception;

public class LimitExceeded extends BadRequestException {

    public LimitExceeded(String message) {
        super(message);
    }
}
