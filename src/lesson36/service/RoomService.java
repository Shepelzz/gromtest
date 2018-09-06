package lesson36.service;

import lesson36.dao.RoomDAO;
import lesson36.dao.Session;
import lesson36.exception.BadRequestException;
import lesson36.exception.InternalServerError;
import lesson36.exception.PermissionError;
import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.model.types.UserType;

import java.util.Date;
import java.util.Set;

public class RoomService {
    private RoomDAO roomDAO;

    public RoomService() throws InternalServerError {
        roomDAO = new RoomDAO();
    }

    //ADMIN
    public Room addRoom(Room room) throws InternalServerError {
        if(!Session.getLoggedUser().getUserType().equals(UserType.ADMIN))
            throw new PermissionError("Add room", "Access", "Only ADMIN can perform this operation");

        if(room.getNumberOfGuests() <= 0 || room.getPrice() <= 0)
            throw new BadRequestException("Add room", "Validation", "Room numberOfGuests or price can not be negative or zero");
        if(room.getDateAvailableFrom() == null)
            throw new BadRequestException("Add room", "Validation", "Room date available from can not be empty");

        return roomDAO.addRoom(room);
    }

    //ADMIN
    public void deleteRoom(long roomId) throws InternalServerError {
        if(!Session.getLoggedUser().getUserType().equals(UserType.ADMIN))
            throw new BadRequestException("Delete room", "Access", "Only ADMIN can perform this operation");

        roomDAO.deleteRoom(roomId);
    }

    public Set<Room> findRooms(Filter filter) throws InternalServerError {
        if(filter.getDateAvailableFrom().before(new Date()))
            throw new BadRequestException("Find rooms", "Validation", "Date can not be earlier than current");

        return roomDAO.findRooms(filter);
    }
}
