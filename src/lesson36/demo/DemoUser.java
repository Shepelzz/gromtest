package lesson36.demo;

import lesson36.controller.UserController;
import lesson36.model.User;
import lesson36.model.types.UserType;

public class DemoUser {
    public static void main(String[] args) throws Exception{
        UserController userController= new UserController();

        userController.registerUser(new User("user2", "pass2", "UA", UserType.USER));

    }
}
