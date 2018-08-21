package lesson36.controller;

import lesson36.exception.ServiceException;
import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.service.RoomService;

import java.util.Set;

public class RoomController {
    private RoomService roomService = new RoomService();

    //ADMIN
    public Room addRoom(Room room) throws ServiceException {
        return roomService.addRoom(room);
    }

    //ADMIN
    public void deleteRoom(long roomId) throws ServiceException{
        roomService.deleteRoom(roomId);
    }

    public Set<Room> findRooms(Filter filter) throws ServiceException{
        return roomService.findRooms(filter);
    }

}
