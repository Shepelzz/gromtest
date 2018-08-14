package lesson36.demo;

import lesson36.controller.UserController;
import lesson36.model.User;
import lesson36.model.types.UserType;

public class DemoUser {
    public static void main(String[] args) throws Exception{
//        UserController userController= new UserController();
//
//        try {
//            User user1 = new User("1", "Pass", "UA", UserType.ADMIN);
//            System.out.println(userController.registerUser(user1));
//        } catch(Exception e){
//            System.err.println(e.getMessage());
//        }

        UserController userController = new UserController();

        try{
            User user = new User("Vasya1", "1111", "RU", UserType.USER);
            userController.registerUser(user);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}
