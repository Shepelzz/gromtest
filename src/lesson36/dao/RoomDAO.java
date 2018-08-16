package lesson36.dao;

import lesson36.model.Filter;
import lesson36.model.Room;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class RoomDAO {
    private static final String path = "src/lesson36/files/RoomDb.txt";
    private GeneralDAO<Room> generalDao = new GeneralDAO<>(path);

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

    public Set<Room> findRooms(Filter filter) throws Exception{
        Set<Room> result = new HashSet<>();

        long index = 1;
        for(String line : generalDao.readFromFile()){
            Room room = getValidRoom(line, index);

            if( room.getNumberOfGuests() >= filter.getNumberOfGuests() &&
                room.getPrice() <= filter.getPrice() &&
                room.isBreakfastIncluded() == filter.isBreakfastIncluded() &&
                room.isPetsAllowed() == filter.isPetsAllowed() &&
                room.getDateAvailableFrom().before(filter.getDateAvailableFrom()) &&
                    (filter.getName() == null || room.getHotel().getName().equals(filter.getName())) &&
                    (filter.getCountry() == null || room.getHotel().getCountry().equals(filter.getCountry())) &&
                    (filter.getCity() == null || room.getHotel().getCity().equals(filter.getCity()))
            )
                result.add(room);
        }
        return result;
    }

    public Room getRoomById(long id) throws Exception{
        long index = 1;
        for(String line : generalDao.readFromFile()){
            Room r = getValidRoom(line, index++);
            if(r.getId() == id)
                return r;
        }
        throw new Exception("Room id was not found");
    }

    private Room getValidRoom(String inputLine, long lineIndex) throws Exception{
        String[] roomValues = inputLine.split(",");

        if(roomValues.length != Room.class.getDeclaredFields().length)
            throw new Exception("Room data is not valid. Value: '"+inputLine+"'");

        try {
            return new Room(
                Long.valueOf(roomValues[0]),
                Integer.valueOf(roomValues[1]),
                Double.valueOf(roomValues[2]),
                Boolean.valueOf(roomValues[3]),
                Boolean.valueOf(roomValues[4]),
                Date.valueOf(roomValues[5]),
                new HotelDAO().getHotelById(Long.valueOf(roomValues[6]))
            );
        }catch (Exception e){
            System.err.println("Can not read data. "+e.getMessage()+" Line: "+lineIndex);
        }
        return null;
    }


}
