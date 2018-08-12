package lesson36.controller;

import lesson36.model.User;
import lesson36.service.UserService;

public class UserController {

    private UserService userService = new UserService();
    private static User loggedUser = null;

    public User registerUser(User user){
        return userService.registerUser(user);
    }

    public void login(String userName, String password){

    }

    public void logout(){

    }

}
