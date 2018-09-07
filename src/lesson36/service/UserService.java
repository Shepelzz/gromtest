package lesson36.service;

import lesson36.dao.Session;
import lesson36.dao.UserDAO;
import lesson36.exception.BadRequestException;
import lesson36.exception.InternalServerError;
import lesson36.model.User;

public class UserService {
    private UserDAO userDAO;

    public UserService() throws InternalServerError {
        userDAO = new UserDAO();
    }

    public User registerUser(User user) throws InternalServerError {
        if (user.getUserName().equals("") || user.getPassword().equals("") || user.getCountry().equals(""))
            throw new BadRequestException("registerUser", "values can not be empty");
        if(userDAO.getUserByLoginAndPassword(user.getUserName(), user.getPassword()) != null)
            throw new BadRequestException("registerUser", "User with user name: "+user.getUserName()+" is already registered.");

        return userDAO.registerUser(user);
    }

    public void login(String userName, String password) throws InternalServerError {
        Session.login(userName, password);
    }

    public void logout(){
        Session.logout();
    }
}
