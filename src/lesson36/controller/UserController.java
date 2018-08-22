package lesson36.controller;

import lesson36.exception.BadRequestException;
import lesson36.exception.UnexpectedException;
import lesson36.model.User;
import lesson36.service.UserService;

public class UserController {
    private UserService userService = new UserService();

    public User registerUser(User user) throws BadRequestException, UnexpectedException {
        return userService.registerUser(user);
    }

    public void login(String userName, String password) throws UnexpectedException {
        userService.login(userName, password);
    }

    public void logout(){
        userService.logout();
    }

}
