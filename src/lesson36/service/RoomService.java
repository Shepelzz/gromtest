package lesson36.service;

import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.dao.RoomDAO;

import java.util.TreeSet;

public class RoomService {
    private RoomDAO roomDAO = new RoomDAO();

    public TreeSet<Room> findRooms(Filter filter){
        return roomDAO.findRooms(filter);
    }

    //ADMIN
    public Room addRoom(Room room) throws Exception{
        return roomDAO.addRoom(room);
    }

    //ADMIN
    public void deleteRoom(long roomId) throws Exception{
        roomDAO.deleteRoom(roomId);
    }

}
