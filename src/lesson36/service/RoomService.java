package lesson36.service;

import lesson36.dao.RoomDAO;
import lesson36.model.Filter;
import lesson36.model.Room;

import java.util.Set;

public class RoomService {
    private RoomDAO roomDAO = new RoomDAO();

    //ADMIN
    public Room addRoom(Room room) throws Exception{
        return roomDAO.addRoom(room);
    }

    //ADMIN
    public void deleteRoom(long roomId) throws Exception{
        roomDAO.deleteRoom(roomId);
    }

    public Set<Room> findRooms(Filter filter) throws Exception{
        return roomDAO.findRooms(filter);
    }

    private void validate(Room room) throws Exception{
        if(room.getNumberOfGuests() > 0)
            throw new Exception(getClass().getName()+". Hotel adding error: name can not be empty");

    }
}
