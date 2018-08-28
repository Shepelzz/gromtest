package lesson36.service;

import lesson36.dao.RoomDAO;
import lesson36.exception.BadRequestException;
import lesson36.exception.UnexpectedException;
import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.model.types.UserType;

import java.util.Date;
import java.util.Set;

public class RoomService {
    private RoomDAO roomDAO;

    public RoomService() throws UnexpectedException{
        roomDAO = new RoomDAO();
    }

    //ADMIN
    public Room addRoom(Room room) throws UnexpectedException {
        UserService.checkAuthorization();
        if(!UserService.getLoggedUser().getUserType().equals(UserType.ADMIN))
            throw new BadRequestException("Add room", "Access", "Only ADMIN can perform this operation");

        if(room.getNumberOfGuests() <= 0)
            throw new BadRequestException("Add room", "Validation", "Room numberOfGuests can not be less than 1");
        if(room.getPrice() <= 0)
            throw new BadRequestException("Add room", "Validation", "Room price can not be negative or zero");
        if(room.getDateAvailableFrom() == null)
            throw new BadRequestException("Add room", "Validation", "Room date available from can not be empty");

        return roomDAO.addRoom(room);
    }

    //ADMIN
    public void deleteRoom(long roomId) throws UnexpectedException {
        UserService.checkAuthorization();
        if(!UserService.getLoggedUser().getUserType().equals(UserType.ADMIN))
            throw new BadRequestException("Delete room", "Access", "Only ADMIN can perform this operation");

        roomDAO.deleteRoom(roomId);
    }

    public Set<Room> findRooms(Filter filter) throws UnexpectedException{
        UserService.checkAuthorization();
        if(filter.getDateAvailableFrom().before(new Date()))
            throw new BadRequestException("Find rooms", "Validation", "Date can not be earlier than current");

        return roomDAO.findRooms(filter);
    }
}
