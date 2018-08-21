package lesson36.exception;

public class ParsingException extends DAOException {

    public ParsingException(String message) {
        super("Parsing error: "+message);
    }

}
