package lesson36.demo;

import lesson36.controller.OrderController;
import lesson36.controller.UserController;
import lesson36.service.UserService;

public class DemoOrder {
    public static void main(String[] args){
                //резервация
        try{
            OrderController orderController = new OrderController();
            UserController userController = new UserController();
            userController.login("Vasya", "1111");

            orderController.bookRoom(7713581945862736410L, UserService.getLoggedUser().getId(), 5800);

        }catch (Exception e){
            System.err.println(e.toString());
        }

        //отмена резервации
        try{
            OrderController orderController = new OrderController();
            UserController userController = new UserController();
            userController.login("Vasya", "1111");

            //orderController.cancelReservation(7713581945862736410L, UserDAO.getLoggedUser().getId());

        }catch (Exception e){
            System.err.println(e.toString());
        }
    }
}
