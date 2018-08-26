package lesson36.dao;

import lesson36.exception.UnexpectedException;
import lesson36.model.Hotel;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class HotelDAO extends GeneralDAO<Hotel>{
    private static final String path = "src/lesson36/files/HotelDb.txt";

    public HotelDAO() {
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
    public Hotel parseStringToObject(String input) {
        return new Hotel(input);
    }

    @Override
    public String parseObjectToString(Hotel hotel) {
        return hotel.toString();
    }
}
