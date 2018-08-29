package lesson36.dao;

import lesson36.exception.UnexpectedException;
import lesson36.model.Hotel;

import java.util.HashSet;
import java.util.Set;

public class HotelDAO extends GeneralDAO<Hotel>{
    private static final String path = "files/HotelDb.txt";

    public HotelDAO() throws UnexpectedException {
        super(path);
    }

    //ADMIN
    public Hotel addHotel(Hotel hotel) throws UnexpectedException {
        return writeToFile(hotel);
    }

    //ADMIN
    public void deleteHotel(long hotelId) throws UnexpectedException{
        deleteFromFileById(hotelId);
    }

    public Set<Hotel> findHotelByName(String name) throws UnexpectedException{
        Set<Hotel> result = new HashSet<>();
        for(Hotel hotel : getAll())
            if(hotel.getName().equals(name))
                result.add(hotel);
        return result;
    }

    public Set<Hotel> findHotelByCity(String name) throws UnexpectedException{
        Set<Hotel> result = new HashSet<>();
        for(Hotel hotel : getAll())
            if(hotel.getCity().equals(name))
                result.add(hotel);
        return result;
    }

    @Override
    public Hotel parseStringToObject(String input) throws UnexpectedException {
        return new Hotel().parseStringToObject(input);
    }
}
