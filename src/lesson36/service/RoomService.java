package lesson36.service;

import lesson36.model.Filter;
import lesson36.model.Room;
import lesson36.repository.RoomRepository;

import java.util.TreeSet;

public class RoomService {

    private RoomRepository roomRepository = new RoomRepository();

    public TreeSet<Room> findRooms(Filter filter){

        return null;
    }

}
