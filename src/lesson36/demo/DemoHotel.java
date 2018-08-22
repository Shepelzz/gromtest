package lesson36.demo;

import lesson36.controller.HotelController;
import lesson36.controller.UserController;

public class DemoHotel {
    public static void main(String[] args){
        HotelController hotelController = new HotelController();

        //добавление отеля
        UserController userController = new UserController();

        try{
            userController.login("admin", "admin");
            //hotelController.addHotel(new Hotel("", "Russia", "Moscow", "testStreet"));

        }catch (Exception e){
            System.err.println(e.toString());
        }


        //удаление отеля
        try{
            userController.login("admin", "admin");
            //hotelController.deleteHotel(26540059603440722L);

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        //поиск отеля по имени
        try{
            //System.out.println(hotelController.findHotelByName("Mot"));


        }catch (Exception e){
            System.err.println(e.getMessage());
        }


        //поиск отелей по городу
        try{
            //System.out.println(hotelController.findHotelByCity("Odessa"));

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
