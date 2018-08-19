package lesson36.demo;

import lesson36.controller.RoomController;
import lesson36.dao.HotelDAO;
import lesson36.model.Room;

import java.util.Date;

public class DemoRoom {
    public static void main(String[] args) throws Exception{
        //try {
        RoomController roomController = new RoomController();
        Room room = new Room(3, 11000.65, false, false, new Date(), new HotelDAO().getHotelById(1080367633112369448L));
        System.out.println(room.toString());

        roomController.addRoom(room);
//        }catch (Exception e){
//            System.err.println(e.getMessage());
//        }
    }
}
