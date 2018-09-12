package lesson36.demo;

import lesson36.controller.HotelController;
import lesson36.controller.UserController;

public class DemoHotel {
    public static void main(String[] args){


        //добавление отеля
        try{
//            HotelController hotelController = new HotelController();
            UserController userController = new UserController();

            userController.login("Zhenya", "qwer1111");
//            hotelController.addHotel(Hotel.newHotelBuilder()
//                    .setName("tratata")
//                    .setCountry("UA")
//                    .setCity("Odessa")
//                    .setStreet("unnamed road 2")
//                    .build()
//            );

        }catch (Exception e){
            System.err.println(e.toString());
        }


        //удаление отеля
        try{
//            HotelController hotelController = new HotelController();
//            UserController userController = new UserController();
//            userController.login("admin", "admin");
            //hotelController.deleteHotel(26540059603440722L);

        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        //поиск отеля по имени
        try{
            HotelController hotelController = new HotelController();
            System.out.println(hotelController.findHotelByName("tratata"));
        }catch (Exception e){
            System.err.println(e.getMessage());
        }


        //поиск отелей по городу
        try{

//            HotelController hotelController = new HotelController();
//            System.out.println(hotelController.findHotelByCity("Odessa"));

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
