package lesson36.service;

import lesson36.dao.Session;
import lesson36.dao.UserDAO;
import lesson36.exception.BadRequestException;
import lesson36.exception.UnexpectedException;
import lesson36.model.User;

public class UserService {
    private UserDAO userDAO;

    public UserService() throws UnexpectedException {
        userDAO = new UserDAO();
    }

    public User registerUser(User user) throws UnexpectedException {
        if(userDAO.getUserByLoginAndPassword(user.getUserName(), user.getPassword()) != null)
            throw new BadRequestException("Register User", "Validation", "User with user name: "+user.getUserName()+" is already registered.");
        if (user.getUserName().equals("") || user.getPassword().equals("") || user.getCountry().equals(""))
            throw new BadRequestException("Register User", "Validation", "values can not be empty");

        return userDAO.registerUser(user);
    }

    public void login(String userName, String password) throws UnexpectedException{
        if(Session.getLoggedUser() != null)
            throw new BadRequestException("Login", "Validation", "You are already logged as user: "+Session.getLoggedUser().getUserName());

        User user = userDAO.getUserByLoginAndPassword(userName, password);
        if(user == null)
            throw  new BadRequestException("Login", "Validation", "User with name: "+userName+" was not found, or password is incorrect");

        Session.setLoggedUser(user);
    }

    public void logout(){
        if(Session.getLoggedUser() == null)
            throw new BadRequestException("Login", "Validation", "Nobody is logged in.");
        Session.setLoggedUser(null);
    }
}
