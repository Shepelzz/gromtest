package lesson36.service;

import lesson36.dao.RoomDAO;
import lesson36.dao.UserDAO;
import lesson36.exception.DAOException;
import lesson36.exception.ServiceException;
import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.model.types.UserType;

import java.util.Date;
import java.util.Set;

public class RoomService {
    private RoomDAO roomDAO = new RoomDAO();

    //ADMIN
    public Room addRoom(Room room) throws ServiceException {
        if(!UserDAO.getLoggedUser().getUserType().equals(UserType.ADMIN))
            throw new ServiceException("Add room error: Only ADMIN can perform this operation");

        validate(room);
        try {
            return roomDAO.addRoom(room);
        }catch (DAOException e){
            throw  new ServiceException(e.getMessage());
        }
    }

    //ADMIN
    public void deleteRoom(long roomId) throws ServiceException {
        if(!UserDAO.getLoggedUser().getUserType().equals(UserType.ADMIN))
            throw new ServiceException("Delete room error: Only ADMIN can perform this operation");
        try {
            roomDAO.deleteRoom(roomId);
        }catch (DAOException e){
            throw  new ServiceException(e.getMessage());
        }
    }

    public Set<Room> findRooms(Filter filter) throws ServiceException{
        if(filter.getDateAvailableFrom().before(new Date()))
            throw new ServiceException("Find rooms error: date can not be earlier than current");
        try{
            return roomDAO.findRooms(filter);
        }catch (DAOException e){
            throw  new ServiceException(e.getMessage());
        }
    }

    private void validate(Room room) throws ServiceException{
        if(room.getNumberOfGuests() <= 0)
            throw new ServiceException("Validation error: Room numberOfGuests can not be less than 1");
        if(room.getPrice() <= 0)
            throw new ServiceException("Room adding error: Room price can not be negative or zero");
        if(room.getDateAvailableFrom() == null)
            throw new ServiceException("Room adding error: Room date available from can not be empty");
    }
}
