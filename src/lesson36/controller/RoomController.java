package lesson36.controller;

import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.service.RoomService;

import java.util.HashSet;

public class RoomController {
    private RoomService roomService = new RoomService();

    //ADMIN
    public Room addRoom(Room room) throws Exception{
        return roomService.addRoom(room);
    }

    //ADMIN
    public void deleteRoom(long roomId) throws Exception{
        roomService.deleteRoom(roomId);
    }

    public HashSet<Room> findRooms(Filter filter){

        return null;
    }

}
