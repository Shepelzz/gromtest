package lesson36.demo;

import lesson36.controller.RoomController;
import lesson36.controller.UserController;
import lesson36.dao.HotelDAO;
import lesson36.model.Filter;
import lesson36.model.Room;

import java.util.Date;

public class DemoRoom {
    public static void main(String[] args){


        //добавление комнаты
        try{
            RoomController roomController = new RoomController();
            UserController userController = new UserController();
            //userController.login("admin1", "admin");
            Room room = new Room(2, 700, true, true, new Date(), new HotelDAO().getEntityById(1376800431651742536L));

            //roomController.addRoom(room);

        }catch (Exception e){
            System.err.println(e.toString());
        }

        //удаление комнаты
        try{
            RoomController roomController = new RoomController();
            UserController userController = new UserController();
            //userController.login("admin1", "admin");

            //roomController.deleteRoom(1410327107726515362L);

        }catch (Exception e){
            System.err.println(e.toString());
        }

        //поиск по фильтру
        try{
            RoomController roomController = new RoomController();
            UserController userController = new UserController();
            userController.login("user2", "pass2");

            Filter filter = new Filter(2, 900, true, true, new Date(), "", "", "Odessa");
            System.out.println(roomController.findRooms(filter));

        }catch (Exception e){
            System.err.println(e.toString());
        }

    }
}
