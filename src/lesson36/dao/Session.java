package lesson36.dao;

import lesson36.exception.BadRequestException;
import lesson36.model.User;

public class Session {
    private static User loggedUser = null;

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(User loggedUser) {
        Session.loggedUser = loggedUser;
    }

    public static void checkAuthorization() throws BadRequestException {
        if(loggedUser == null)
            throw new BadRequestException("Authorization", "Validation", "You must be logged in system for perform this operation");
    }
}
