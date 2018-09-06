package lesson36.controller;

import lesson36.exception.InternalServerError;
import lesson36.model.User;
import lesson36.service.UserService;

public class UserController {
    private UserService userService;

    public UserController() throws InternalServerError {
        userService = new UserService();
    }

    public User registerUser(User user) throws InternalServerError {
        return userService.registerUser(user);
    }

    public void login(String userName, String password) throws InternalServerError {
        userService.login(userName, password);
    }

    public void logout(){
        userService.logout();
    }

}
