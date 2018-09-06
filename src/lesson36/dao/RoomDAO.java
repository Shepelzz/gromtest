package lesson36.dao;

import lesson36.exception.InternalServerError;
import lesson36.model.Filter;
import lesson36.model.Room;

import java.util.Set;
import java.util.stream.Collectors;

public class RoomDAO extends GeneralDAO<Room>{
    private static final String path = "files/RoomDb.txt";

    public RoomDAO() throws InternalServerError {
        super(path);
    }

    //ADMIN
    public Room addRoom(Room room) throws InternalServerError {
        return writeToFile(room);
    }

    //ADMIN
    public void deleteRoom(long roomId) throws InternalServerError {
        deleteFromFileById(roomId);
    }

    public Set<Room> findRooms(Filter filter) throws InternalServerError {
        return getAll().stream()
            .filter(x -> (filter.getNumberOfGuests() == 0 || x.getNumberOfGuests() == filter.getNumberOfGuests()))
            .filter(x -> (filter.getPrice() == 0 || x.getPrice() <= filter.getPrice()))
            .filter(x -> x.isBreakfastIncluded() == filter.isBreakfastIncluded())
            .filter(x -> x.isPetsAllowed() == filter.isPetsAllowed())
            .filter(x -> x.getDateAvailableFrom().before(filter.getDateAvailableFrom()))
            .filter(x -> (filter.getName()== null || x.getHotel().getName().equals(filter.getName())))
            .filter(x -> (filter.getCountry()== null || x.getHotel().getCountry().equals(filter.getCountry())))
            .filter(x -> (filter.getCity()== null || x.getHotel().getCity().equals(filter.getCity())))
            .collect(Collectors.toSet());
    }

    @Override
    public Room parseStringToObject(String input) throws InternalServerError {
        return new Room().parseStringToObject(input);
    }
}
