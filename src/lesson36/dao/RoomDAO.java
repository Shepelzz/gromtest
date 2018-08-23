package lesson36.dao;

import lesson36.exception.UnexpectedException;
import lesson36.model.Filter;
import lesson36.model.Room;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class RoomDAO extends GeneralDAO<Room>{
    private static final String path = "src/lesson36/files/RoomDb.txt";

    public RoomDAO() {
        super(Room.class, path);
    }

    //ADMIN
    public Room addRoom(Room room) throws UnexpectedException {
        return writeToFile(room);
    }

    //ADMIN
    public void deleteRoom(long roomId) throws UnexpectedException{
        deleteFromFileById(roomId);
    }

    public Set<Room> findRooms(Filter filter) throws UnexpectedException{
        Set<Room> result = new HashSet<>();

        for(String[] dataLine : readFromFile()){
            Room room = parseToObject(dataLine);

            boolean numberOfGuests = (filter.getNumberOfGuests() == 0 || filter.getNumberOfGuests() == room.getNumberOfGuests());
            boolean price = (filter.getPrice() == 0 || filter.getPrice() >= room.getPrice());
            //надо ли выбрать оба?
            boolean breakfastIncluded = (filter.isBreakfastIncluded() == room.isBreakfastIncluded());
            //надо ли выбрать оба?
            boolean petsAllowed = (filter.isPetsAllowed() == room.isPetsAllowed());
            boolean dateAvailableFrom = (filter.getDateAvailableFrom().after(room.getDateAvailableFrom()));
            boolean name = (filter.getName().equals("") || filter.getName().equals(room.getHotel().getName()));
            boolean country = (filter.getCountry().equals("") || filter.getCountry().equals(room.getHotel().getCountry()));
            boolean city = (filter.getCity().equals("") || filter.getCity().equals(room.getHotel().getCity()));

            if( numberOfGuests &&
                price &&
                breakfastIncluded &&
                petsAllowed &&
                dateAvailableFrom &&
                name &&
                country &&
                city
            )
                result.add(room);
        }
        return result;
    }

    public Room getRoomById(long id) throws UnexpectedException{
        String[] data = getObjectByParameters(new LinkedHashMap<String, String>(){{put("id", String.valueOf(id));}});
        if(data == null)
            return null;
        return parseToObject(data);
    }

    public void replaceRoomById(long id, Room newRoom) throws UnexpectedException{
        replaceDataById(id, newRoom);
    }

    private static Room parseToObject(String[] input) throws UnexpectedException {
        try{
            return new Room(
                Long.valueOf(input[0]),
                Integer.valueOf(input[1]),
                Double.valueOf(input[2]),
                Boolean.valueOf(input[3]),
                Boolean.valueOf(input[4]),
                new SimpleDateFormat("dd-MM-yyyy").parse(input[5]),
                new HotelDAO().getHotelById(Long.valueOf(input[6]))
            );
        }catch (Exception e){
            throw new UnexpectedException(e.getMessage());
        }
    }




}