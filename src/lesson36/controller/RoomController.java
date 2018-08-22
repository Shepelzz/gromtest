package lesson36.controller;

import lesson36.exception.BadRequestException;
import lesson36.exception.UnexpectedException;
import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.service.RoomService;

import java.util.Set;

public class RoomController {
    private RoomService roomService = new RoomService();

    //ADMIN
    public Room addRoom(Room room) throws BadRequestException, UnexpectedException {
        return roomService.addRoom(room);
    }

    //ADMIN
    public void deleteRoom(long roomId) throws BadRequestException, UnexpectedException {
        roomService.deleteRoom(roomId);
    }

    public Set<Room> findRooms(Filter filter) throws BadRequestException, UnexpectedException {
        return roomService.findRooms(filter);
    }

}
