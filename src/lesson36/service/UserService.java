package lesson36.service;

import lesson36.dao.UserDAO;
import lesson36.exception.BadRequestException;
import lesson36.exception.UnexpectedException;
import lesson36.model.User;

public class UserService {
    private static User loggedUser;
    private UserDAO userDAO = new UserDAO();

    public User registerUser(User user) throws UnexpectedException {
        if(userDAO.getUserByLoginAndPassword(user.getUserName(), user.getPassword()) != null)
            throw new BadRequestException("Register User", "Validation", "User with user name: "+user.getUserName()+" is already registered.");
        if (user.getUserName() == null || user.getUserName().equals(""))
            throw new BadRequestException("Register User", "Validation", "User register error: user name can not be empty");
        if (user.getPassword() == null || user.getPassword().equals(""))
            throw new BadRequestException("Register User", "Validation", "User register error: user password can not be empty");
        if (user.getCountry() == null || user.getCountry().equals(""))
            throw new BadRequestException("Register User", "Validation", "User register error: user country can not be empty");

        return userDAO.registerUser(user);
    }

    public void login(String userName, String password) throws UnexpectedException{
        User user = userDAO.getUserByLoginAndPassword(userName, password);
        if(user == null)
            throw  new BadRequestException("Login", "Validation", "User with name: "+userName+" was not found, or password is incorrect");

        loggedUser = user;
    }

    public void logout(){
        loggedUser = null;
    }

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static void checkAuthorization() throws BadRequestException {
        if(loggedUser == null)
            throw new BadRequestException("Authorization", "Validation", "You must be logged in system for perform this operation");
    }
}
