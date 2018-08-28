package lesson36.controller;

import lesson36.exception.UnexpectedException;
import lesson36.model.User;
import lesson36.service.UserService;

public class UserController {
    private UserService userService;

    public UserController() throws UnexpectedException{
        userService = new UserService();
    }

    public User registerUser(User user) throws UnexpectedException {
        return userService.registerUser(user);
    }

    public void login(String userName, String password) throws UnexpectedException {
        userService.login(userName, password);
    }

    public void logout(){
        userService.logout();
    }

}
