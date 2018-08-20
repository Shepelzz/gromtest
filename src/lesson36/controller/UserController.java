package lesson36.controller;

import lesson36.exception.DAOException;
import lesson36.exception.ServiceException;
import lesson36.model.User;
import lesson36.service.UserService;

public class UserController {
    private UserService userService = new UserService();

    public User registerUser(User user) throws DAOException, ServiceException {
        return userService.registerUser(user);
    }

    public void login(String userName, String password){

    }

    public void logout(){

    }

}
