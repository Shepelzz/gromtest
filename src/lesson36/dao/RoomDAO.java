package lesson36.dao;

import lesson36.exception.DAOException;
import lesson36.model.Filter;
import lesson36.model.Room;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.LinkedHashMap;
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

        for(String[] dataLine : readFromFile(path)){
            Room room = parseToObject(dataLine);

            boolean numberOfGuests = (filter.getNumberOfGuests() == 0 || filter.getNumberOfGuests() == room.getNumberOfGuests());
            boolean price = (filter.getPrice() == 0 || filter.getPrice() >= room.getPrice());
            //TODO как выбрать оба?
            boolean breakfastIncluded = (filter.isBreakfastIncluded() == room.isBreakfastIncluded());
            //TODO как выбрать оба?
            boolean petsAllowed = (filter.isPetsAllowed() == room.isPetsAllowed());
            boolean dateAvailableFrom = (filter.getDateAvailableFrom().after(room.getDateAvailableFrom()));
            boolean name = (filter.getName() == null || filter.getName().equals(room.getHotel().getName()));
            boolean country = (filter.getCountry() == null || filter.getCountry().equals(room.getHotel().getCountry()));
            boolean city = (filter.getCity() == null || filter.getCity().equals(room.getHotel().getCity()));

            if(numberOfGuests && price && breakfastIncluded && petsAllowed && dateAvailableFrom && name && country && city)
                result.add(room);
        }
        return result;
    }

    public Room getRoomById(long id) throws DAOException{
        String[] data = getObjectByParameters(new LinkedHashMap<Integer, String>(){{put(0, String.valueOf(id));}}, path);
        if(data == null)
            return null;
        return parseToObject(data);
    }

    public void replaceRoomById(long id, Room newRoom) throws DAOException{
        replaceDataById(id, newRoom, path);
    }

    private Room parseToObject(String[] input) throws DAOException {
        try{
            return new Room(
                Long.valueOf(input[0]),
                Integer.valueOf(input[1]),
                Double.valueOf(input[2]),
                Boolean.valueOf(input[3]),
                Boolean.valueOf(input[4]),
                new SimpleDateFormat("dd-MM-yyyy").parse(input[5]),
                new HotelDAO().getHotelById(Long.valueOf(input[6]))  /*TODO static?*/
            );
        }catch (Exception e){
            throw new DAOException(e.getMessage());
        }
    }




}
