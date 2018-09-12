package lesson36.controller;

import lesson36.dao.Session;
import lesson36.exception.InternalServerError;
import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.model.types.UserType;
import lesson36.service.RoomService;

import java.util.Set;

public class RoomController {
    private RoomService roomService;

    public RoomController() throws InternalServerError{
        roomService = new RoomService();
    }

    //ADMIN
    public Room addRoom(Room room) throws InternalServerError {
        Session.checkAuthorization("addRoom", UserType.ADMIN);
        return roomService.addRoom(room);
    }

    //ADMIN
    public void deleteRoom(long roomId) throws InternalServerError {
        Session.checkAuthorization("deleteRoom", UserType.ADMIN);
        roomService.deleteRoom(roomId);
    }

    public Set<Room> findRooms(Filter filter) throws InternalServerError {
        Session.checkAuthorization("findRooms");
        return roomService.findRooms(filter);
    }

}
