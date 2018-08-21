package lesson36.demo;

import lesson36.controller.OrderController;
import lesson36.controller.UserController;
import lesson36.dao.UserDAO;

public class DemoOrder {
    public static void main(String[] args){
        OrderController orderController = new OrderController();

        //резервация
        try{
            UserController userController = new UserController();
            userController.login("Vasya", "1111");

            orderController.bookRoom(7713581945862736410L, UserDAO.getLoggedUser().getId(), 5800);

        }catch (Exception e){
            System.err.println(e.toString());
        }

        //отмена резервации
        try{
            UserController userController = new UserController();
            userController.login("Vasya", "1111");

            orderController.cancelReservation(7713581945862736410L, UserDAO.getLoggedUser().getId());

        }catch (Exception e){
            System.err.println(e.toString());
        }
    }
}
