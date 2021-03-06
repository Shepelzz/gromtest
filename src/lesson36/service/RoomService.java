package lesson36.service;

import lesson36.dao.RoomDAO;
import lesson36.exception.BadRequestException;
import lesson36.exception.InternalServerError;
import lesson36.model.Filter;
import lesson36.model.Room;

import java.util.Date;
import java.util.Set;

public class RoomService {
    private RoomDAO roomDAO;

    public RoomService() throws InternalServerError{
        roomDAO = new RoomDAO();
    }

    //ADMIN
    public Room addRoom(Room room) throws InternalServerError {
        if(room.getNumberOfGuests() <= 0 || room.getPrice() <= 0 || room.getDateAvailableFrom() == null)
            throw new BadRequestException("addRoom", "values can not be empty");

        return roomDAO.addRoom(room);
    }

    //ADMIN
    public void deleteRoom(long roomId) throws InternalServerError {
        roomDAO.deleteRoom(roomId);
    }

    public Set<Room> findRooms(Filter filter) throws InternalServerError {
        if(filter.getDateAvailableFrom().before(new Date()))
            throw new BadRequestException("findRooms", "Date can not be earlier than current");

        return roomDAO.findRooms(filter);
    }
}
