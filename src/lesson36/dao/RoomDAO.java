package lesson36.dao;

import lesson36.model.Filter;
import lesson36.model.Room;

import java.util.TreeSet;

public class RoomDAO {
    private static final String path = "src/lesson36/files/RoomDb.txt";
    private GeneralDAO<Room> generalDao = new GeneralDAO<>(path);

    public TreeSet<Room> findRooms(Filter filter){

        return null;
    }

    //ADMIN
    public Room addRoom(Room room) throws Exception{
        return generalDao.writeToFile(
            new Room(
                generalDao.randomId(),
                room.getNumberOfGuests(),
                room.getPrice(),
                room.isBreakfastIncluded(),
                room.isPetsAllowed(),
                room.getDateAvailableFrom(),
                room.getHotel()
            )
        );
    }

    //ADMIN
    public void deleteRoom(long roomId) throws Exception{
        generalDao.deleteFromFile(getRoomById(roomId));
    }

    private Room getRoomById(long id) throws Exception{
        long index = 1;
        for(String line : generalDao.readFromFile()){
            Room r = getValidRoom(line, index++);
            if(r.getId() == id)
                return r;
        }
        throw new Exception("id was not found");
    }

    private Room getValidRoom(String inputLine, long lineIndex) throws Exception{
        String[] hotelValues = inputLine.split(",");

        if(hotelValues.length != Room.class.getDeclaredFields().length)
            throw new Exception("HotelDAO. Data is not valid. Value: '"+inputLine+"'");

        if(hotelValues[1].trim().length() == 0)
            throw new Exception("HotelDAO. Data is not valid. Value: '"+inputLine+"'");

        if(hotelValues[2].trim().length() == 0)
            throw new Exception("HotelDAO. Data is not valid. Value: '"+inputLine+"'");

        if(hotelValues[3].trim().length() == 0)
            throw new Exception("HotelDAO. Data is not valid. Value: '"+inputLine+"'");

        if(hotelValues[4].trim().length() == 0)
            throw new Exception("HotelDAO. Data is not valid. Value: '"+inputLine+"'");

        /*
        return new Room(
                Long.valueOf(hotelValues[0]),
                hotelValues[1].trim(),
                hotelValues[2].trim(),
                hotelValues[3].trim(),
                hotelValues[4].trim(),
                hotelValues[5].trim(),
                hotelValues[6]
        );
        */
        return null;
    }


}
