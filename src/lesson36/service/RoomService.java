package lesson36.service;

import lesson36.dao.RoomDAO;
import lesson36.dao.UserDAO;
import lesson36.exception.BadRequestException;
import lesson36.exception.UnexpectedException;
import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.model.types.UserType;

import java.util.Date;
import java.util.Set;

public class RoomService {
    private RoomDAO roomDAO = new RoomDAO();

    //ADMIN
    public Room addRoom(Room room) throws BadRequestException, UnexpectedException {
        if(!UserDAO.getLoggedUser().getUserType().equals(UserType.ADMIN))
            throw new BadRequestException("Add room error: Only ADMIN can perform this operation");

        validate(room);
        return roomDAO.addRoom(room);
    }

    //ADMIN
    public void deleteRoom(long roomId) throws BadRequestException, UnexpectedException {
        if(!UserDAO.getLoggedUser().getUserType().equals(UserType.ADMIN))
            throw new BadRequestException("Delete room error: Only ADMIN can perform this operation");

        roomDAO.deleteRoom(roomId);
    }

    public Set<Room> findRooms(Filter filter) throws BadRequestException, UnexpectedException{
        if(filter.getDateAvailableFrom().before(new Date()))
            throw new BadRequestException("Find rooms error: date can not be earlier than current");

        return roomDAO.findRooms(filter);
    }

    private void validate(Room room) throws BadRequestException{

        if(room.getNumberOfGuests() <= 0)
            throw new BadRequestException("Validation error: Room numberOfGuests can not be less than 1");
        if(room.getPrice() <= 0)
            throw new BadRequestException("Validation error: Room price can not be negative or zero");
        if(room.getDateAvailableFrom() == null)
            throw new BadRequestException("Validation error: Room date available from can not be empty");
    }
}
