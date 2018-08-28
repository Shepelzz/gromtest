package lesson36.dao;

import lesson36.exception.UnexpectedException;
import lesson36.model.Filter;
import lesson36.model.Room;

import java.util.HashSet;
import java.util.Set;

public class RoomDAO extends GeneralDAO<Room>{
    private static final String path = "files/RoomDb.txt";

    public RoomDAO() throws UnexpectedException {
        super(path);
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
        boolean numberOfGuests, price, breakfastIncluded, petsAllowed, dateAvailableFrom, name, country, city;

        for(Room room : getAll()){
            numberOfGuests = (filter.getNumberOfGuests() == 0 || filter.getNumberOfGuests() == room.getNumberOfGuests());
            price = (filter.getPrice() == 0 || filter.getPrice() >= room.getPrice());
            breakfastIncluded = (filter.isBreakfastIncluded() == room.isBreakfastIncluded());
            petsAllowed = (filter.isPetsAllowed() == room.isPetsAllowed());
            dateAvailableFrom = (filter.getDateAvailableFrom().after(room.getDateAvailableFrom()));
            name = (filter.getName().equals("") || filter.getName().equals(room.getHotel().getName()));
            country = (filter.getCountry().equals("") || filter.getCountry().equals(room.getHotel().getCountry()));
            city = (filter.getCity().equals("") || filter.getCity().equals(room.getHotel().getCity()));

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

    void replaceRoomById(long id, Room newRoom) throws UnexpectedException{
        replaceDataById(id, newRoom);
    }

    @Override
    public Room parseStringToObject(String input) throws UnexpectedException{
        return new Room(input);
    }
}
