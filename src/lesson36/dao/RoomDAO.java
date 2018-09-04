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

        for(Room room : getAll()){
            boolean numberOfGuests = (filter.getNumberOfGuests() == 0 || filter.getNumberOfGuests() == room.getNumberOfGuests());
            boolean price = (filter.getPrice() == 0 || filter.getPrice() >= room.getPrice());
            boolean breakfastIncluded = (filter.isBreakfastIncluded() == room.isBreakfastIncluded());
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

    //https://habr.com/post/256057/
//    public Optional<Room> getRooms(Filter filter) throws UnexpectedException{
//        return getAll().stream()
//                .filter(room -> room.getNumberOfGuests() == filter.getNumberOfGuests())
//                .findFirst();
//    }

    @Override
    public Room parseStringToObject(String input) throws UnexpectedException{
        return new Room().parseStringToObject(input);
    }
}
