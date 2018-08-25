package lesson36.dao;

import lesson36.exception.UnexpectedException;
import lesson36.model.Filter;
import lesson36.model.GeneralModel;
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

        for(Room room : readFromFile()){
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
        return getObjectByParameters(new LinkedHashMap<String, String>(){{put("id", String.valueOf(id));}});
    }

    void replaceRoomById(long id, Room newRoom) throws UnexpectedException{
        replaceDataById(id, newRoom);
    }

    @Override
    public Room parseStringToObject(String input) {
        return new Room(input);
    }

    @Override
    public String parseObjectToString(Room room) {
        return room.toString();
    }
}
