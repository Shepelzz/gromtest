package lesson36.service;

import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.dao.RoomDAO;

import java.util.TreeSet;

public class RoomService {

    private RoomDAO roomRepository = new RoomDAO();

    public TreeSet<Room> findRooms(Filter filter){

        return null;
    }

}
