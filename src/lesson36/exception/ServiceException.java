package lesson36.exception;

public class ServiceException extends Exception{

    public ServiceException(String message) {
        super("Service exception: "+message);
    }

}
