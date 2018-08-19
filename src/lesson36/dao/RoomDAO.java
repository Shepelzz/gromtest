package lesson36.dao;

import lesson36.exception.DAOException;
import lesson36.model.Filter;
import lesson36.model.Room;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class RoomDAO extends GeneralDAO<Room>{
    private static final String path = "src/lesson36/files/RoomDb.txt";

    //ADMIN
    public Room addRoom(Room room) throws DAOException{
        return writeToFile(room, path);
    }

    //ADMIN
    public void deleteRoom(long roomId) throws DAOException{
        deleteFromFileById(roomId, path);
    }

    public Set<Room> findRooms(Filter filter) throws DAOException{
        Set<Room> result = new HashSet<>();

//        long index = 1;
//        for(String line : readFromFile(path)){
//            Room room = getValidRoom(line, index);
//
//            assert room != null;
//            if( room.getNumberOfGuests() >= filter.getNumberOfGuests() &&
//                room.getPrice() <= filter.getPrice() &&
//                room.isBreakfastIncluded() == filter.isBreakfastIncluded() &&
//                room.isPetsAllowed() == filter.isPetsAllowed() &&
//                room.getDateAvailableFrom().before(filter.getDateAvailableFrom()) &&
//                    (filter.getName() == null || room.getHotel().getName().equals(filter.getName())) &&
//                    (filter.getCountry() == null || room.getHotel().getCountry().equals(filter.getCountry())) &&
//                    (filter.getCity() == null || room.getHotel().getCity().equals(filter.getCity()))
//            )
//                result.add(room);
//        }
        return result;
    }

    public Room getRoomById(long id) throws DAOException{
        return parseToObjectRoom(getDataById(id, path));
    }

    private Room parseToObjectRoom(String[] input) throws DAOException {
        try{
            return new Room(
                Long.valueOf(input[0]),
                Integer.valueOf(input[1]),
                Double.valueOf(input[2]),
                Boolean.valueOf(input[3]),
                Boolean.valueOf(input[4]),
                Date.valueOf(input[5]),
                new HotelDAO().getHotelById(Long.valueOf(input[6]))  /*TODO static?*/
            );
        }catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }


}
