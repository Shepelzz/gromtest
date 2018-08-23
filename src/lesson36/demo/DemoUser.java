package lesson36.demo;

import lesson36.controller.UserController;
import lesson36.model.User;
import lesson36.model.types.UserType;

public class DemoUser {
    public static void main(String[] args) throws Exception{
        UserController userController = new UserController();

        //регистрация юзера
        try{
            User user = new User("Zhenya", "qwer1111", "Ukraine", UserType.ADMIN);
            //System.out.println(userController.registerUser(user));
        }catch (Exception e){
            System.err.println(e.toString());
        }

        //логин
        try{
            //userController.login("Zhenya", "qwer1111");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        //System.out.println(UserDAO.getLoggedUser());

        //логаут
        //userController.logout();
        //System.out.println(UserDAO.getLoggedUser());

        User user = new User("Zhenya", "qwer1111", "Ukraine", UserType.ADMIN);






    }
}
